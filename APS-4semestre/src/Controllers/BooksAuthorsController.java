package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.BooksAuthorsDAO;
import Model.BooksAuthors;
import UTIL.Global;

public class BooksAuthorsController {

	static ArrayList<BooksAuthors> booksAuthors;
	static BooksAuthorsDAO booksAuthorsDAO = new BooksAuthorsDAO();

	public void createTableBooks(DefaultTableModel modelo, String name) {
		modelo.setNumRows(0);

		booksAuthors = new ArrayList<BooksAuthors>();

		booksAuthors = name != " " ? booksAuthorsDAO.searchBooksAuthors(name) : booksAuthorsDAO.getAllBooksAuthors();

		String ObjIdBooks[] = new String[booksAuthors.size()];
		if (booksAuthors.size() > 0)
			for (int i = 0; i < booksAuthors.size(); i++) {
				modelo.addRow(
						new Object[] { booksAuthors.get(i).getTitle(), booksAuthors.get(i).getFname(), booksAuthors.get(i).getName(), "$ " + booksAuthors.get(i).getPrice() });
				ObjIdBooks[i] = booksAuthors.get(i).isbn;

			}
		else
			JOptionPane.showMessageDialog(null, "Não foi possivel localizar esse livro", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
		Global.setObjIdBooks(ObjIdBooks);
	}

}
