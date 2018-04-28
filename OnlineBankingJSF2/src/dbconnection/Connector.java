package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

public class Connector {
	
	private Connection con; 
	
	public Connector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // loading the oracle driver class
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "javauser", "javauser");// establishing connection to oracle
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException, NamingException{
		Connector connector = new Connector();
		Connection con = connector.getCon();
		Statement stat = con.createStatement(); // preparing the statement for query
		ResultSet rs = stat.executeQuery("select * from customer"); //executing query
		//getting data from resultset
		while(rs.next()) {
			System.out.println("name: " + rs.getString(2));
		}		
	}
}







