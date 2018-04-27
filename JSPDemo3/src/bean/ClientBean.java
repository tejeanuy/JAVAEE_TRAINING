package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientBean {
	
	private int clientid;
	private String name;
	private String address;
	private String nationality;
	private int age;
	private String username;
	private String password;
	private String message;
	private CreditCardInfo ccinfo;
	
	public ClientBean() {
		ccinfo = new CreditCardInfo();
	}
	
	public CreditCardInfo getCcinfo() {
		return ccinfo;
	}
	public void setCcinfo(CreditCardInfo ccinfo) {
		this.ccinfo = ccinfo;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isUserFound() throws SQLException {
		Connection con = new DBConnector().getConnection();
		PreparedStatement ps = con.prepareStatement("select count(*) "
				+ "from tbl_client where username=? and password=?");
		ps.setString(1, this.username);
		ps.setString(2, this.password);
		
		ResultSet set = ps.executeQuery();
		set.next();
		int count = set.getInt(1);
		
		con.close();
		
		if(count > 0) {
			return true;
		} else {
			return false;	
		}
	}
	
	public void getClientDetails() throws SQLException {
		Connection con = new DBConnector().getConnection();
		PreparedStatement ps = con.prepareStatement("select name, address, nationality, age "
				+ "from tbl_client where username=? and password=?");
		ps.setString(1, this.username);
		ps.setString(2, this.password);
		
		ResultSet set = ps.executeQuery();
		while(set.next()) {
			this.name = set.getString(1);
			this.address = set.getString(2);
			this.nationality = set.getString(3);
			this.age = set.getInt(4);
		}
		con.close();
	}
	
	public int saveClientDetails() throws SQLException {
		Connection con = new DBConnector().getConnection();
		PreparedStatement ps = con.prepareStatement("insert into tbl_client "
				+ "values(TBL_CLIENT_SEQ.nextval,?,?,?,?,?,?)");
		ps.setString(1, this.name);
		ps.setString(2, this.address);
		ps.setString(3, this.nationality);
		ps.setInt(4, this.age);
		ps.setString(5, this.username);
		ps.setString(6, this.password);
		
		int result = ps.executeUpdate();
		
		con.close();
		
		return result;
	}
}











