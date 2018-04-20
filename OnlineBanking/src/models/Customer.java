package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public boolean createCustomer() {
		Connector connector = new Connector();
		int custrow = 0; boolean bankaccountcreated = false;
		try {
			Statement stat = connector.getCon().createStatement();
			ResultSet set = stat.executeQuery("select CUSTOMERIDSEQ.NEXTVAL from dual");
			
			while(set.next()) {
				id = set.getInt(1);
			}
			
			PreparedStatement ps = connector.getCon().prepareStatement("insert into customer values (?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setDate(4, birthday);
			ps.setString(5, email);
			custrow = ps.executeUpdate();

			StringBuilder sb = new StringBuilder();
			sb.append(firstname.substring(0, 1) + lastname.substring(0, 1) + id);
			bankaccount.setAccountid(sb.toString());
			bankaccountcreated = bankaccount.createBankAccount(id);
			
			connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(custrow > 0 && bankaccountcreated) {
			return true;
		} else {
			return false;
		}
	}
}



