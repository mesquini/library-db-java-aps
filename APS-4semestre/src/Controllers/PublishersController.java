package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.*;
import Model.Publishers;
import UTIL.Global;

public class PublishersController {

	static ArrayList<Publishers> publishers;
	static PublishersDAO publishersDAO = new PublishersDAO();
	static BooksDAO booksDAO = new BooksDAO();

	public DefaultTableModel createTablePublisher(DefaultTableModel modelo, String name) {
		modelo.setNumRows(0);

		publishers = new ArrayList<Publishers>();

		publishers = name != " " ? publishersDAO.searchPublisher(name) : publishersDAO.getAllPublishers();

		for (Publishers a : publishers) {
			modelo.addRow(new Object[] { a.getPublisher_id(), a.getName(), a.getUrl() });
		}

		return modelo;

	}

	public boolean createPublisher(String name, String url) {
		if (validaCampos(name, url)) {

			publishers = new ArrayList<Publishers>();
			publishers = publishersDAO.searchPublisher(name);

			for (Publishers p : publishers) {
				if (p.getName().equals(name)) {
					JOptionPane.showMessageDialog(null, "Editora " + name + " já está cadastrada!", "Aviso",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}

			publishersDAO.addPublisher(name, url);
			return true;
		}
		return false;
	}

	public boolean validaCampos(String name, String url) {

		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Nome é um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (url.equals("")) {
			JOptionPane.showMessageDialog(null, "URL é um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	public void deletePublisher(String idPublisher) {
		int id = Integer.parseInt(idPublisher);

		boolean rest = booksDAO.searchBook(id);// VERIFICA SE EXISTE ALGUM LIVRO VINCULADO COM A EDITORA

		if (rest) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja deletar os livros desta Editora?",
					"Confirmação...", JOptionPane.YES_NO_OPTION);

			if (resposta == JOptionPane.YES_OPTION)
				publishersDAO.deletePublisherBooks(id);// FAZ O DELETE EM 3 TABELAS, BOOKSAUTHORS, BOOKS E PUBLISHERS

		} else
			publishersDAO.deletePublisher(id);// DELETA APENAS A EDITORA

		Global.limpaCampos();

	}

	public Publishers searchID(String idPublisher) {
		int id = Integer.parseInt(idPublisher);

		publishers = publishersDAO.getAllPublishers();
		for (Publishers p : publishers) {
			if (p.getPublisher_id() == id) {
				return p;
			}
		}
		return null;

	}

	public void updatePublisher(int publisher_id, String name, String url) {

		if (validaCampos(name, url)) {
			publishersDAO.updatePublisher(publisher_id, name, url);

			JOptionPane.showMessageDialog(null, "Editora foi alterado com sucesso!", "Alteração Editora",
					JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public String[] createComboBoxPublishers() {
		ArrayList<Publishers> publishers = publishersDAO.getAllPublishers();
		String[] publishersList = new String[publishers.size()];
		int[] objIdPublisher = new int[publishers.size()];

		for (int ii = 0; ii < publishersList.length; ii++) {
			publishersList[ii] = publishers.get(ii).getName();
			objIdPublisher[ii] = publishers.get(ii).getPublisher_id();
		}

		Global.setObjIdPublisher(objIdPublisher);

		return publishersList;
	}

}
