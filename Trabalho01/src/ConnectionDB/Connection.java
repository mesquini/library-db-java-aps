package ConnectionDB;

import java.sql.*;
//Início da classe de conexão//

public class Connection {

	public static String status = "Não conectou...";

	// Método Construtor da Classe//

	public Connection() {
	}

	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		java.sql.Connection connection = null; // atributo do tipo Connection

		try {
			// Configurando a nossa conexão com um banco de dados//

			final String USER = "postgres";
			final String PASS = "mesquini";
			final String DATABASE = "library";
			final String URL = "jdbc:postgresql:" + DATABASE;

			connection = DriverManager.getConnection(URL, USER, PASS);

			// Testa sua conexão//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (SQLException e) {

			// Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}

	// Método que fecha sua conexão//

	public static boolean FecharConexao() {

		try {

			Connection.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return Connection.getConexaoMySQL();

	}

}
