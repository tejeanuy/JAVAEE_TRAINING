package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import dbconnection.Connector;

public class Customer {
	
	private int id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String email;
	private BankAccount bankaccount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BankAccount getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(BankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}

	public boolean insertCustomer() {
		Connector connector = new Connector();
		int row = 0;
		try {
			PreparedStatement ps = connector.getCon().prepareStatement("insert into customer values (?,?,?,?,?,null)");
			ps.setInt(1, id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setDate(4, birthday);
			ps.setString(5, email);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row > 0) {
			return true;
		} else {
			return false;
		}
	}
}



