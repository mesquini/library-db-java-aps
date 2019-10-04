package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Publishers;
import UTIL.DbConnection;
import UTIL.Global;

public class PublishersDAO extends DbConnection {

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

	public ArrayList<Publishers> searchPublisher(String name) {

		final String query = "SELECT * FROM publishers WHERE name like (?)";

		ArrayList<Publishers> lstPublisher = new ArrayList<Publishers>();
		Publishers publisher;

		try (Connection connection = getConexaoMySQL()) {

			PreparedStatement pstm = connection.prepareStatement(query);
			pstm.setString(1, "%" + name + "%");
			ResultSet rs = pstm.executeQuery();
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

	public void deletePublisherBooks(int id) {

		final String delete = "DELETE FROM publishers WHERE publisher_id = ?";

		try (Connection con = getConexaoMySQL()) {

			for (int i = 0; i < Global.getIsbnLts().size(); i++) {
				final String delete2 = "DELETE FROM booksauthors WHERE isbn = ?";
				
				PreparedStatement pstm = con.prepareStatement(delete2);

				pstm.setString(1, Global.getIsbnLts().get(i));

				pstm.execute();

			}

			for (int i = 0; i < Global.getIdPublisherLts().size(); i++) {
				final String delete2 = "DELETE FROM books WHERE publisher_id = ?";
				
				PreparedStatement pstm = con.prepareStatement(delete2);

				pstm.setInt(1, Global.getIdPublisherLts().get(i));

				pstm.execute();

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
