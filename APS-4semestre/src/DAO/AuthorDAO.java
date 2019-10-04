package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Authors;
import UTIL.DbConnection;
import UTIL.Global;

public class AuthorDAO extends DbConnection {

	BooksAuthorsDAO ba = new BooksAuthorsDAO();
	BooksDAO b = new BooksDAO();

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

	public ArrayList<Authors> searchAuthor(String name) {

		final String query = "SELECT * FROM authors WHERE name like (?) ";
		Authors author;
		ArrayList<Authors> lstUser = new ArrayList<Authors>();

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, "%" + name + "%");
			ResultSet rs = pstm.executeQuery();
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

	public void addAuthor(String name, String fname) {

		final String insert = "INSERT INTO authors (name, fname) VALUES (?,?)";

		try (Connection con = getConexaoMySQL()) {

			PreparedStatement pstm = con.prepareStatement(insert);

			pstm.setString(1, name);
			pstm.setString(2, fname);

			pstm.execute();

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

		try (Connection con = getConexaoMySQL()) {

			final String delete = "DELETE FROM authors WHERE author_id = ?";

			if (ba.checkAuthorExist(id)) {

				final String deleteBa = "DELETE FROM booksauthors WHERE author_id = ?";

				PreparedStatement pstm = con.prepareStatement(deleteBa);

				pstm.setInt(1, id);

				pstm.execute();


				Global.limpaCampos();
			}

			PreparedStatement pstm = con.prepareStatement(delete);

			pstm.setInt(1, id);

			pstm.execute();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

	public void deleteAuthorBook(int id) {

		try (Connection con = getConexaoMySQL()) {

			final String delete = "DELETE FROM authors WHERE author_id = ?";

			if (ba.checkAuthorExist(id)) {
				
				for(int i = 0; i < Global.getIsbnLts().size(); i++) {
					
					final String deleteBa = "DELETE FROM booksauthors WHERE isbn = ?";
					
					PreparedStatement pstm = con.prepareStatement(deleteBa);
					
					pstm.setString(1, Global.getIsbnLts().get(i));
					
					pstm.execute();
					
					b.deleteBook(Global.getIsbnLts().get(i));
				}


				Global.limpaCampos();
			}

			PreparedStatement pstm = con.prepareStatement(delete);

			pstm.setInt(1, id);

			pstm.execute();

			FecharConexao();

		} catch (SQLException e) {
			e.printStackTrace();
			FecharConexao();
		}

	}

}
