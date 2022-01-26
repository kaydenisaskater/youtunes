//A class to manage the JDBC driver for connecting to the database
package youtunes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcManager {
	//private variables for connecting to the database
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	
	public JdbcManager() {
		//variables are assigned
		jdbcUrl = "jdbc:mysql://localhost:3306/youtunes?";
		jdbcUserName = "youtunes_user";
		jdbcPassword = "youtunespass";
		
		//try locating the jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public Connection getConn() {
		//initialize the database connection
		Connection conn = null;
		
		//try connecting to the database with the variables
		try {
			conn = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
		catch (SQLException e){
			System.out.println("Could not connect to DB: " + e.getMessage());
		}
		
		return conn;
	}
	
	//close the connection to the database
	public void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println("Could not close DB connection: " + e.getMessage());
			}
		}
	}
}
