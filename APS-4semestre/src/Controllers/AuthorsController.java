package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.AuthorDAO;
import Model.Authors;

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
			JOptionPane.showMessageDialog(null, "Nome � um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lastName.equals("")) {
			JOptionPane.showMessageDialog(null, "Sobrenome � um campo obrigatorio!", "Campo vazio",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}
	
	public void deleteAuthor(String idAuthor) {
		int id = Integer.parseInt(idAuthor);
		
		authorDAO.deleteAuthor(id);
	}

}
