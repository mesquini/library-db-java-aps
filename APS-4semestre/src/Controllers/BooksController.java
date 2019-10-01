package Controllers;

import java.util.ArrayList;
import java.util.List;

import DAO.BooksDAO;
import DAO.PublishersDAO;
import Model.Publishers;

public class BooksController {
	
	BooksDAO booksDAO = new BooksDAO();
	BooksAuthorsController booksauthorsController = new BooksAuthorsController();
	PublishersDAO publishersDAO = new PublishersDAO();
	
	public void deleteBook(String idBook) {
		booksDAO.deleteBook(idBook);
		
		
	}
	
	

}
