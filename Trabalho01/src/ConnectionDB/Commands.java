package ConnectionDB;

import DTO.*;
import java.sql.*;
import java.util.ArrayList;

public class Commands extends Connection{
	public ArrayList<BooksAuthors> searchBooksAuthors(String name) {

		final String query = "SELECT b.title, GROUP_CONCAT(a.fname) ,p.name, b.price  " + " FROM booksauthors ba "
				+ " inner join books b on ba.isbn = b.isbn "
				+ " inner join publishers p on b.publisher_id = p.publisher_id "
				+ " INNER JOIN authors a on ba.author_id = a.author_id " + " WHERE b.title like (?)"
				+ " GROUP BY b.title, b.price, p.name";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (java.sql.Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, "%" + name + "%");

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				booksAuthors = new BooksAuthors();

				booksAuthors.setTitle(rs.getString(1));
				booksAuthors.setFname(rs.getString(2));
				booksAuthors.setPublicherName(rs.getString(3));
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
}
