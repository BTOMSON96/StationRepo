package connection;

import java.sql.*;

public class Connect {
	static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn != null) return conn;
		
		String db = "station";
		String username = "root";
		String password = "123456";
		
		return getConnection(db, username, password);	
	}
	private static Connection getConnection(String dbName, String username, String password) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" +dbName + "?user =" +username+ "&password=" +password);
		}
		catch (Exception e) {
			System.out.println(e);
	}
		return conn;
	}
}
