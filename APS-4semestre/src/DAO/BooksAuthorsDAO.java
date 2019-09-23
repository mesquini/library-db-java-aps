package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BooksAuthors;
import UTIL.DbConnection;

public class BooksAuthorsDAO extends DbConnection {
	public ArrayList<BooksAuthors> searchBooksAuthors(String name) {

		final String query = "SELECT b.title, GROUP_CONCAT(a.fname) ,p.name, b.price  " + " FROM booksauthors ba "
				+ " inner join books b on ba.isbn = b.isbn "
				+ " inner join publishers p on b.publisher_id = p.publisher_id "
				+ " INNER JOIN authors a on ba.author_id = a.author_id " + " WHERE b.title like '%" + name + "%'"
				+ " GROUP BY b.title, b.price, p.name";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			// pstm.setString(1, name);

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
