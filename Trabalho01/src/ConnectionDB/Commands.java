package ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

public class Commands extends Connection {
	
	public ArrayList<BooksAuthors> searchBooksAuthors(String name) {

		final String SqlQuery = "SELECT BKS.TITLE, STRING_AGG(AUTH.FNAME || ' ' || AUTH.NAME,'; ') AS AUTHORNAME, PS.NAME AS PUBLISHERNAME, BKS.PRICE "
				+ " FROM BOOKS BKS " + " JOIN BOOKSAUTHORS BA ON BA.ISBN =  BKS.ISBN "
				+ " JOIN AUTHORS AUTH ON AUTH.AUTHOR_ID = BA.AUTHOR_ID "
				+ " JOIN PUBLISHERS PS ON PS.PUBLISHER_ID = BKS.PUBLISHER_ID " + " WHERE TITLE ILIKE (?)"
				+ " GROUP BY BKS.TITLE, PS.NAME, BKS.PRICE";

		ArrayList<BooksAuthors> lstBooksAuthors = new ArrayList<BooksAuthors>();
		BooksAuthors booksAuthors;

		try (java.sql.Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(SqlQuery);
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
