package ConnectionDB;

import java.sql.*;
//In�cio da classe de conex�o//

public class Connection {

	public static String status = "N�o conectou...";

	// M�todo Construtor da Classe//

	public Connection() {
	}

	// M�todo de Conex�o//

	public static java.sql.Connection getConexaoMySQL() {

		java.sql.Connection connection = null; // atributo do tipo Connection

		try {
			// Configurando a nossa conex�o com um banco de dados//

			final String USER = "postgres";
			final String PASS = "mesquini";
			final String DATABASE = "library";
			final String URL = "jdbc:postgresql:" + DATABASE;

			connection = DriverManager.getConnection(URL, USER, PASS);

			// Testa sua conex�o//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->N�o foi possivel realizar conex�o");

			}

			return connection;

		} catch (SQLException e) {

			// N�o conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	// M�todo que retorna o status da sua conex�o//

	public static String statusConection() {

		return status;

	}

	// M�todo que fecha sua conex�o//

	public static boolean FecharConexao() {

		try {

			Connection.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	// M�todo que reinicia sua conex�o//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return Connection.getConexaoMySQL();

	}

}
