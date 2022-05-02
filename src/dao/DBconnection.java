package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/dogs";
	private final static String username = "root";
	private final static String password = "Taco7786!";
	private static Connection connection;
	private static DBconnection instance;
	
	
	private DBconnection(Connection connection) {
		this.connection = connection;
		
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, username, password);
				instance = new DBconnection(connection);
				System.out.println("Connection Successful!!!");
			}
			catch (SQLException e) {
				e.printStackTrace();
				
			}}
			return DBconnection.connection;
		
	}
			
			

}
