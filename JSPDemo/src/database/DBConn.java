package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

	private Connection con; 
	
	public DBConn() {
		try {
			//Load the Driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			//Make a Connection 
			con = 
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java","java");

			//Create SQL Statement
			Statement stat = con.createStatement();
			
			//Execute the Statement
			ResultSet rs = stat.executeQuery("select * from tbl_client");
			
			//Iterate over the ResultSet
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getString(4) + " "
						+ rs.getInt(5)
				);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getClient(String nationality) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from tbl_client where "
					+ "nationality = ?");
			ps.setString(1, nationality);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3) + " "
						+ rs.getString(4) + " "
						+ rs.getInt(5)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertClient(int clientid, String name, String address,
			String nationality, int age) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into tbl_client values(?,?,?,?,?)");
			ps.setInt(1, clientid);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, nationality);
			ps.setInt(5, age);
			
			int check = ps.executeUpdate();
			
			if(check > 0) {
				System.out.println("Insert Successful.");
			} else {
				System.out.println("Insert Failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteClient(int clientid) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from tbl_client "
					+ "where clientid = ?");
			ps.setInt(1, clientid);
			
			int check = ps.executeUpdate();
			
			if(check > 0) {
				System.out.println("Delete Successful.");
			} else {
				System.out.println("Delete Failed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		//Cleanup the resources
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBConn db = new DBConn();
		db.getClient("American");
		//db.insertClient(4, "Eric Stolz", "Canada", "Canadian", 40);
		db.deleteClient(2);
		db.closeConnection();
	}
	
	
	
	
	
	
	
}