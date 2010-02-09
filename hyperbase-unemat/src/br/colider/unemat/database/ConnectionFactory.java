package br.colider.unemat.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:"
					+ "mysql://localhost/hyperbase", "root", "002589");
			
			return conn;
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
