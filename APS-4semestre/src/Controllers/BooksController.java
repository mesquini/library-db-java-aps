package Controllers;

import DAO.BooksAuthorsDAO;
import DAO.BooksDAO;

public class BooksController {
	
	BooksDAO booksDAO = new BooksDAO();
	BooksAuthorsController booksauthorsController = new BooksAuthorsController();
	
	public void deleteBook(String idBook) {
		booksDAO.deleteBook(idBook);
		
		
	}

}
