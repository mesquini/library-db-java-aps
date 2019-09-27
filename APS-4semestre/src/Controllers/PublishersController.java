package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.PublishersDAO;
import Model.Publishers;

public class PublishersController {

	static ArrayList<Publishers> publishers;
	static PublishersDAO publishersDAO = new PublishersDAO();

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
			
			for(Publishers p : publishers) {
				if(p.getName().equals(name)) {
					JOptionPane.showMessageDialog(null, "Editora " + name+  " já está cadastrada!", "Aviso", JOptionPane.WARNING_MESSAGE);
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

}
