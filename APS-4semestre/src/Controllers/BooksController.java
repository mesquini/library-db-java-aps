package Controllers;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DAO.*;
import Model.Authors;
import Model.Books;
import Model.BooksAuthors;
import Model.Publishers;
import UTIL.Global;
import View.Livro.AddLivro;

public class BooksController {

	BooksDAO booksDAO = new BooksDAO();
	BooksAuthorsDAO booksAuthorsDAO = new BooksAuthorsDAO();
	ArrayList<BooksAuthors> booksAuthors;
	ArrayList<Books> books;
	PublishersDAO publishersDAO = new PublishersDAO();
	AuthorDAO authorDAO = new AuthorDAO();

	public void deleteBook(int linhaSelecionada) {
		
		String idBook = Global.getObjIdBooks()[linhaSelecionada];
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
			Global.limpaCampos();
			AddLivro.limpaCampos();
		}
	}

	public void searchIdBook(int linhaselecionada) {
		String isbn = Global.getObjIdBooks()[linhaselecionada];

		books = new ArrayList<Books>();
		books = booksDAO.getAllBooks();
		String price = null;

		/* PESQUISA E MONTA VALORES PARA A TELA DE ALTERA��O */
		for (Books b : books) {
			if (b.getIsbn().equals(isbn)) {
				Global.setIsbn(b.getIsbn());
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
				Publishers p = publishersDAO.searchPublisherId(b.getPublisher_id());
				Global.setPublisher(p);
			}
		}

		booksAuthors = new ArrayList<BooksAuthors>();
		booksAuthors = booksAuthorsDAO.getBooksAuthorsForISBN(isbn);
		int[] authorsId = new int[booksAuthors.size()];
		
		for (int i = 0; i < booksAuthors.size(); i++) {
			authorsId[i] = booksAuthors.get(i).getAuthor_id();

		}
		
		String[] authorsName = new String[authorsId.length];
		
		for(int i = 0; i < authorsId.length; i++) {
			Authors a = authorDAO.searchAuthor(authorsId[i]);
			authorsName[i] = a.getName().trim() + " " + a.getFname().trim();
		}
		Global.setObjNameAuthors(authorsName);
	}

	public boolean validaCampos(String isbn, String title, String price, String seq_no, int[] authors) {

		if (isbn.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'isbn' � obrigatorio!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (title.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O campo 'Titulo' � obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (price.equals("___,__")) {
			JOptionPane.showMessageDialog(null, "O campo 'Pre�o' � obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (seq_no.equals("__")) {
			JOptionPane.showMessageDialog(null, "O campo 'Volume' � obrigatorio!", "Aviso!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (authors == null) {
			JOptionPane.showMessageDialog(null, "Selecione pelo menos 1 autor!", "Aviso!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;
	}

	public void updateBook(String title, String price) {

		booksDAO.updateBook(Global.getIsbn(), title, Double.parseDouble(price.replace(",", ".")));

		JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!", "Livro Alte��o",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
