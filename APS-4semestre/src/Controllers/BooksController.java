package Controllers;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.*;
import Model.Authors;
import Model.Books;
import Model.BooksAuthors;
import UTIL.Global;

public class BooksController {

	BooksDAO booksDAO = new BooksDAO();
	BooksAuthorsDAO booksAuthorsDAO = new BooksAuthorsDAO();
	ArrayList<BooksAuthors> booksAuthors;
	ArrayList<Books> books;
	PublishersDAO publishersDAO = new PublishersDAO();

	public void deleteBook(String idBook) {

		booksDAO.deleteBook(idBook); // deleta nas duas tabelas na books e booksauthors

	}

	public void createBook(String isbn, String title, String price, String seq_no, int editora, int[] authors) {
		if (validaCampos(isbn, title, price, seq_no, authors)) {

			booksDAO.addBook(isbn, editora, title, Double.parseDouble(price.replace(",", ".")));

			for (int i = 0; i < authors.length; i++) {
				booksAuthorsDAO.addBookAuthors(authors[i], isbn, Integer.parseInt(seq_no));
			}
			JOptionPane.showMessageDialog(null, "Livro criado com sucesso!", "Livro criado",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void searchIdBook(String linhaSelecionada) {

		booksAuthors = new ArrayList<BooksAuthors>();
		books = new ArrayList<Books>();
		books = booksDAO.getAllBooks();
		booksAuthors = booksAuthorsDAO.getAllBooksAuthors();
		String price = null;

		for (Books b : books) {
			if (b.getIsbn().equals(linhaSelecionada)) {
				Global.setTitle(b.getTitle());

				price = b.getPrice().toString();
				Pattern pattern = Pattern.compile("\\.", Pattern.CASE_INSENSITIVE);
				String a[] = pattern.split(price);

				if (a[0].length() < 3) {

					if (a[0].length() < 2)
						a[0] = "00" + a[0];
					else
						a[0] = "0" + a[0];

				}
				if (a[1].length() < 2)
					a[1] += "0";
				price = a[0] + "," + a[1];

				Global.setPrice(price);
			}
		}
	}

	public boolean validaCampos(String isbn, String title, String price, String seq_no, int[] authors) {

		if (isbn.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'isbn' é obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (title.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo' é obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (price.equals("___,__")) {
			JOptionPane.showMessageDialog(null, "O campo 'Preço' é obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (seq_no.equals("__")) {
			JOptionPane.showMessageDialog(null, "O campo 'Volume' é obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (authors == null) {
			JOptionPane.showMessageDialog(null, "Selecione pelo menos 1 autor!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

}
