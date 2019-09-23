package Controllers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.AuthorDAO;
import Model.Authors;

public class AuthorsController{
	
	static ArrayList<Authors> authors;
	static AuthorDAO authorDAO = new AuthorDAO();
	
	public static DefaultTableModel createTableAuthor(DefaultTableModel modelo) {
		modelo.setNumRows(0);

		authors = new ArrayList<Authors>();
		authors = authorDAO.getAllAuthors();

		for (Authors a : authors) {
			modelo.addRow(new Object[] { a.getName(), a.getFname() });
		}
		
		return modelo;

	}
	
	public ArrayList<Authors> getAuthors(String name){
		
		authors = new ArrayList<Authors>();
		
		return authors;
	}
}
