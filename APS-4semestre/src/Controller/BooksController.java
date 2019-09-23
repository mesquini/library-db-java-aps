package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Books;
import UTIL.DbConnection;

public class BooksController extends DbConnection {
	public ArrayList<Books> getAllBooks() {

		ArrayList<Books> lstBooks = new ArrayList<Books>();
		Books book;

		final String querry = "SELECT * FROM books";

		try (Connection con = getConexaoMySQL()) {

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(querry);

			while (rs.next()) {
				book = new Books();

				book.setIsbn(rs.getString(1));
				book.setPublisher_id(rs.getInt(2));
				book.setTitle(rs.getString(3));
				book.setPrice(rs.getDouble(4));

				lstBooks.add(book);
			}

			FecharConexao();
			return lstBooks;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public Books searchBook(String title) {

		final String query = "SELECT * FROM books WHERE title = ?";
		Books book = new Books();

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, title);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				book.setIsbn(rs.getString(1));
				book.setPublisher_id(rs.getInt(2));
				book.setTitle(rs.getString(3));
				book.setPrice(rs.getDouble(4));
			}

			FecharConexao();

			return book;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public void addBook(String isbn, int publisher_id, String title, Double price) {

		final String insert = "INSERT INTO books (isbn, publisher_id, title, price) VALUES (?,?,?,?)";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(insert);

			pstm.setString(1, isbn);
			pstm.setInt(2, publisher_id);
			pstm.setString(3, title);
			pstm.setDouble(4, price);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void updateBook(String isbn, String title, Double price) {

		final String update = "UPDATE books SET title = ?, price = ? WHERE isbn = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(update);

			pstm.setString(1, title);
			pstm.setDouble(2, price);
			pstm.setString(3, isbn);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void deleteBook(String isbn) {

		final String deleteBooksAuthors = "DELETE FROM booksauthors WHERE isbn = ?";
		final String deleteBooks = "DELETE FROM books WHERE isbn = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(deleteBooksAuthors);

			pstm.setString(1, isbn);

			pstm.execute();

			PreparedStatement pstm2 = con.prepareStatement(deleteBooks);

			pstm2.setString(1, isbn);

			pstm2.execute();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}
}
