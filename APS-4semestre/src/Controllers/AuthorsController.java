package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.AuthorDAO;
import Model.Authors;
import UTIL.Global;

public class AuthorsController {

	static ArrayList<Authors> authors;
	static AuthorDAO authorDAO = new AuthorDAO();

	public void createTableAuthor(DefaultTableModel modelo, String name) {

		modelo.setNumRows(0);

		authors = new ArrayList<Authors>();

		authors = name != " " ? authorDAO.searchAuthor(name) : authorDAO.getAllAuthors();

		for (Authors a : authors) {
			modelo.addRow(new Object[] { a.getAuthor_id(), a.getName(), a.getFname() });
		}

	}

	public boolean createAuthor(String name, String lastName) {

		if (validaCampos(name, lastName)) {

			authorDAO.addAuthor(name, lastName);
			return true;
		}
		return false;
	}

	public boolean validaCampos(String name, String lastName) {

		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Nome é um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lastName.equals("")) {
			JOptionPane.showMessageDialog(null, "Sobrenome é um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	public void deleteAuthor(String idAuthor) {
		int id = Integer.parseInt(idAuthor);

		authorDAO.deleteAuthor(id);
	}

	public Authors searchIdAuthor(String linhaSelecionada) {
		int id = Integer.parseInt(linhaSelecionada);

		authors = authorDAO.getAllAuthors();

		for (Authors a : authors) {
			if (a.getAuthor_id() == id) {
				return a;
			}
		}
		return null;
	}

	public void updateAuthor(int id, String name, String lastName) {

		if (validaCampos(name, lastName)) {
			authorDAO.updateAuthor(id, name, lastName);

			JOptionPane.showMessageDialog(null, "Autor alterado com sucesso!", "Alteração",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public String[] createComboBoxAuthors() {
		ArrayList<Authors> authors = authorDAO.getAllAuthors();
		String[] authorsList = new String[authors.size()];

		for (int ii = 0; ii < authorsList.length; ii++) {
			authorsList[ii] = authors.get(ii).getName();
		}

		return authorsList;
	}
	
	public int[] getIndexTableAuthors(DefaultTableModel modelo, int[] authorsId) {
		
		int rowsTable = modelo.getRowCount();
		
		int[] rowsIndex = new int[authorsId.length];
		
		for(int i = 0; i < rowsTable; i++) {
			int id = (int) modelo.getValueAt(i, 0);
			
			for(int j = 0; j < authorsId.length; j++) {
				if(authorsId[j] == id)
					rowsIndex[j] = i;					
			}
		}
		return rowsIndex;
	}

}
