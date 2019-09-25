package Controllers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.AuthorDAO;
import Model.Authors;

public class AuthorsController{
	
	static ArrayList<Authors> authors;
	static AuthorDAO authorDAO;
	
	public static void createTableAuthor(DefaultTableModel modelo, String name) {      
        
		modelo.setNumRows(0);	
		
		
				
		authors = new ArrayList<Authors>();
		authorDAO = new AuthorDAO();
		
		authors = name != " " ? authorDAO.searchAuthor(name) : authorDAO.getAllAuthors();

		for (Authors a : authors) {
			modelo.addRow(new Object[] { a.getAuthor_id(), a.getName(), a.getFname() });
		}

	}	
	
}
