package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BooksAuthors;
import UTIL.DbConnection;
import UTIL.Global;

public class BooksAuthorsDAO extends DbConnection {

	public ArrayList<BooksAuthors> searchBooksAuthors(String name) {

		final String SqlQuery = "SELECT BKS.isbn, BKS.TITLE, STRING_AGG(AUTH.FNAME || ' ' || AUTH.NAME,'; ') AS AUTHORNAME, PS.NAME AS PUBLISHERNAME, BKS.PRICE "
				+ " FROM BOOKS BKS " + " JOIN BOOKSAUTHORS BA ON BA.ISBN =  BKS.ISBN "
				+ " JOIN AUTHORS AUTH ON AUTH.AUTHOR_ID = BA.AUTHOR_ID "
				+ " JOIN PUBLISHERS PS ON PS.PUBLISHER_ID = BKS.PUBLISHER_ID " + " WHERE TITLE ILIKE (?)"
				+ " GROUP BY BKS.isbn, BKS.TITLE, PS.NAME, BKS.PRICE";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(SqlQuery);
			pstm.setString(1, "%" + name + "%");

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				booksAuthors = new BooksAuthors();

				booksAuthors.setIsbn(rs.getString(1));
				booksAuthors.setTitle(rs.getString(2));
				booksAuthors.setFname(rs.getString(3));
				booksAuthors.setName(rs.getString(4));
				booksAuthors.setPrice(rs.getDouble(5));

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

	public ArrayList<BooksAuthors> getBooksAuthorsForISBN(String isbn) {

		final String query = "SELECT isbn, author_id  " + " FROM booksauthors ba " + " WHERE ba.isbn = (?)";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, isbn);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				booksAuthors = new BooksAuthors();

				booksAuthors.setIsbn(rs.getString(1));
				booksAuthors.setAuthor_id(rs.getInt(2));

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

	public ArrayList<BooksAuthors> getAllBooksAuthors() {

		final String query = "SELECT b.isbn, b.title, GROUP_CONCAT(a.fname) ,p.name, b.price  "
				+ " FROM booksauthors ba " + " inner join books b on ba.isbn = b.isbn "
				+ " inner join publishers p on b.publisher_id = p.publisher_id "
				+ " INNER JOIN authors a on ba.author_id = a.author_id " + " GROUP BY b.isbn, b.title, b.price, p.name";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				booksAuthors = new BooksAuthors();

				booksAuthors.setIsbn(rs.getString(1));
				booksAuthors.setTitle(rs.getString(2));
				booksAuthors.setFname(rs.getString(3));
				booksAuthors.setName(rs.getString(4));
				booksAuthors.setPrice(rs.getDouble(5));

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

	public boolean checkAuthorExist(int id) {

		final String query = "SELECT * FROM booksauthors WHERE author_id = ?";

		BooksAuthors booksAuthors = new BooksAuthors();

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);

			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();

			ArrayList<String> isbnLts = new ArrayList<String>();

			if (rs != null) {

				while (rs.next()) {

					booksAuthors.setIsbn(rs.getString(1));
					booksAuthors.setAuthor_id(rs.getInt(2));
					booksAuthors.setSeq_no(rs.getInt(3));

					isbnLts.add(rs.getString(1));
				}

				Global.setIsbnLts(isbnLts);

				FecharConexao();

				return true;
			}
			FecharConexao();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
			return false;
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
