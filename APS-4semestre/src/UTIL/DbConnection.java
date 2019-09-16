package UTIL;

import java.sql.*;
//In�cio da classe de conex�o//

public class DbConnection {

	public static String status = "N�o conectou...";

	// M�todo Construtor da Classe//

	public DbConnection() {
	}

	// M�todo de Conex�o//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection

		try {

			// Carregando o JDBC Driver padr�o

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			// Configurando a nossa conex�o com um banco de dados//

			final String USER = "root";
			final String PASS = "root";
			final String DATABASE = "/biblioteca";
			final String serverName = "localhost";
			final String URL = "jdbc:mysql://" + serverName + DATABASE;

			connection = DriverManager.getConnection(URL, USER, PASS);

			// Testa sua conex�o//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->N�o foi possivel realizar conex�o");

			}

			return connection;

		} catch (ClassNotFoundException e) { // Driver n�o encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

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

			DbConnection.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	// M�todo que reinicia sua conex�o//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return DbConnection.getConexaoMySQL();

	}

}
