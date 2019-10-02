package Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

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
	
	public void createBook(String isbn, String title, String price, int seq_no, String editora, int[] authors) {
		if (validaCampos(isbn, title, price, seq_no, editora, authors)) {
			
		}
	}
	
	public boolean validaCampos(String isbn, String title, String price, int seq_no, String editora, int[] authors) {
		System.out.println(seq_no);
		System.out.println(price);
		if(isbn.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'isbn' é obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(title.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo' é obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(price.equals("___,__")) {
			JOptionPane.showMessageDialog(null, "O campo 'Preço' é obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(seq_no > 0) {
			JOptionPane.showMessageDialog(null, "O campo 'Volume' é obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(authors == null) {
			JOptionPane.showMessageDialog(null, "Selecione pelo menos 1 autor!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	

}
