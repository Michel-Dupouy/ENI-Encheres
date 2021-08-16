package fr.eni.formation.ENIEncheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {
	
	private static Connection connection;
	
	
	public  static Connection getConnection() {
		
		String url= "jdbc:sqlserver://localhost:1433;databaseName=projet";
		String user="sa";
		String password ="Pa$$w0rd";
		if(connection==null) {			
			try {
				connection = DriverManager.getConnection(url, user, password);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connection;
	}
	
	
	public static boolean isClosed() throws SQLException {
		return connection.isClosed();
	}
	
	
	
	public static void close() {
		try {
			connection.close();
			connection=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


