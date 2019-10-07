package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.BooksAuthorsDAO;
import Model.BooksAuthors;

public class BooksAuthorsController {

	static ArrayList<BooksAuthors> booksAuthors;
	static BooksAuthorsDAO booksAuthorsDAO = new BooksAuthorsDAO();

	public void createTableBooks(DefaultTableModel modelo, String name) {
		modelo.setNumRows(0);

		booksAuthors = new ArrayList<BooksAuthors>();

		booksAuthors = name != " " ? booksAuthorsDAO.searchBooksAuthors(name) : booksAuthorsDAO.getAllBooksAuthors();

		if (booksAuthors.size() > 0)
			for (BooksAuthors a : booksAuthors) {
				modelo.addRow(
						new Object[] { a.getIsbn(), a.getTitle(), a.getFname(), a.getName(), "$ " + a.getPrice() });
			}
		else
			JOptionPane.showMessageDialog(null, "Não foi possivel localizar esse livro", "Aviso", JOptionPane.INFORMATION_MESSAGE);

	}

}
