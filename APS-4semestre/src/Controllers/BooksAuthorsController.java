package Controllers;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.BooksAuthorsDAO;
import Model.BooksAuthors;

public class BooksAuthorsController {
	
	static ArrayList<BooksAuthors> booksAuthors;
	static BooksAuthorsDAO booksAuthorsDAO;

	public void createTableBooks(DefaultTableModel modelo, String name) {
		modelo.setNumRows(0);	
			
		booksAuthors = new ArrayList<BooksAuthors>();
		booksAuthorsDAO = new BooksAuthorsDAO();
		
		booksAuthors = name != " " ? booksAuthorsDAO.searchBooksAuthors(name) : booksAuthorsDAO.getAllBooksAuthors();

		for (BooksAuthors a : booksAuthors) {
			modelo.addRow(new Object[] { a.getIsbn(), a.getTitle(), a.getFname(), a.getName() ,a.getPrice() });
		}
		
	}

}
