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

			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			// Configurando a nossa conexão com um banco de dados//

			final String USER = "root";
			final String PASS = "root";
			final String DATABASE = "/library";
			final String serverName = "localhost";
			final String complements = "?autoReconnect=true&useSSL=false";
			final String URL = "jdbc:mysql://" + serverName + DATABASE + complements;

			connection = DriverManager.getConnection(URL, USER, PASS);

			// Testa sua conexão//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

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
