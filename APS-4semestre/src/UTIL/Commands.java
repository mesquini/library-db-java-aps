package UTIL;

import DTO.*;

import java.sql.*;
import java.util.ArrayList;

public class Commands extends DbConnection {

	/**********************************************************
	 * COMMANDS AUTHORS
	 ******************************************************************************/
	public ArrayList<Authors> getAllAuthors() {

		ArrayList<Authors> lstUser = new ArrayList<Authors>();
		Authors author;

		final String querry = "SELECT * FROM authors";

		try (Connection con = getConexaoMySQL()) {

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(querry);

			while (rs.next()) {
				author = new Authors();

				author.setAuthor_id(Integer.parseInt(rs.getString(1)));
				author.setName(rs.getString(2));
				author.setFname(rs.getString(3));

				lstUser.add(author);
			}

			FecharConexao();
			return lstUser;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public Authors searchAuthor(String name) {

		final String query = "SELECT * FROM authors WHERE name = ?";
		Authors author = new Authors();

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				author.setAuthor_id(Integer.parseInt(rs.getString(1)));
				author.setName(rs.getString(2));
				author.setFname(rs.getString(3));
			}

			FecharConexao();

			return author;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public void addAuthor(String name, String fname) {

		final String insert = "INSERT INTO authors (name, fname) VALUES (?,?)";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(insert);

			pstm.setString(1, name);
			pstm.setString(2, fname);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void updateAuthor(int id, String name, String fname) {

		final String update = "UPDATE authors SET name = ?, fname = ? WHERE author_id = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(update);

			pstm.setString(1, name);
			pstm.setString(2, fname);
			pstm.setInt(3, id);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void deleteAuthor(int id) {

		final String delete = "DELETE FROM authors WHERE author_id = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(delete);

			pstm.setInt(1, id);

			pstm.execute();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	/**********************************************************
	 * COMMANDS PUBLISHERS
	 ******************************************************************************/
	public ArrayList<Publishers> getAllPublishers() {

		ArrayList<Publishers> lstPublisher = new ArrayList<Publishers>();
		Publishers publisher;

		final String querry = "SELECT * FROM publishers";

		try (Connection con = getConexaoMySQL()) {

			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(querry);

			while (rs.next()) {
				publisher = new Publishers();

				publisher.setPublisher_id(Integer.parseInt(rs.getString(1)));
				publisher.setName(rs.getString(2));
				publisher.setUrl(rs.getString(3));

				lstPublisher.add(publisher);
			}

			FecharConexao();
			return lstPublisher;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public Publishers searchPublisher(String name) {

		final String query = "SELECT * FROM publishers WHERE name = ?";
		Publishers publisher = new Publishers();

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				publisher.setPublisher_id(Integer.parseInt(rs.getString(1)));
				publisher.setName(rs.getString(2));
				publisher.setUrl(rs.getString(3));
			}

			FecharConexao();

			return publisher;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public void addPublisher(String name, String url) {

		final String insert = "INSERT INTO publishers (name, url) VALUES (?,?)";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(insert);

			pstm.setString(1, name);
			pstm.setString(2, url);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void updatePublisher(int id, String name, String url) {

		final String update = "UPDATE publishers SET name = ?, url = ? WHERE publisher_id = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(update);

			pstm.setString(1, name);
			pstm.setString(2, url);
			pstm.setInt(3, id);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void deletePublisher(int id) {

		final String delete = "DELETE FROM publishers WHERE publisher_id = ?";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(delete);

			pstm.setInt(1, id);

			pstm.execute();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	/****************************************	COMMANDS BOOK	 ******************************************************************************/
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

	public ArrayList<BooksAuthors> searchBooksAuthors(String name) {

		

		final String query = "SELECT b.title, GROUP_CONCAT(a.fname) ,p.name, b.price  "
				+ " FROM booksauthors ba "
				+ " inner join books b on ba.isbn = b.isbn " 
				+ " inner join publishers p on b.publisher_id = p.publisher_id "
				+ " INNER JOIN authors a on ba.author_id = a.author_id "
				+ " WHERE b.title like '%"+name+"%'"
				+ " GROUP BY b.title, b.price, p.name";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			//pstm.setString(1, name);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				booksAuthors = new BooksAuthors();
				
				booksAuthors.setTitle(rs.getString(1));
				booksAuthors.setFname(rs.getString(2));
				booksAuthors.setName(rs.getString(3));
				booksAuthors.setPrice(rs.getDouble(4));

				lstBooksAuthors.add(booksAuthors);
			}

			FecharConexao();

			return lstBooksAuthors;

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return null;
		}

	}

	public void addBookAuthors(int author_id, String isbn, int seq_no) {

		final String insert = "INSERT INTO booksauthors (isbn, author_id, seq_no) VALUES (?,?,?)";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(insert);

			pstm.setString(1, isbn);
			pstm.setInt(2, author_id);
			pstm.setInt(3, seq_no);

			pstm.executeUpdate();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

}
