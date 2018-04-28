package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dbconnection.Connector;

public class Customer {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String birthday;
	private String email;
	private BankAccount bankaccount;
	private Boolean created;
	
	public Boolean getCreated() {
		return created;
	}
	public void setCreated(Boolean created) {
		this.created = created;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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

	public void createCustomer() {
		Connector connector = new Connector();
		int custrow = 0; boolean bankaccountcreated = false;
		
		/** Convert String to java.sql.Date **/
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date bday = null;
		try {
			bday = dateFormat.parse(this.birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		java.sql.Date bdaySQLDate = new java.sql.Date(bday.getTime());
		/***********************************/
		
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
			ps.setDate(4, bdaySQLDate);
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
			created = true;
		}
	}
	
	public String validateLogin() {
		Connector connector = new Connector();
		try {
			PreparedStatement ps = connector.getCon().prepareStatement("select count(*) from customer c join bankaccount b on c.id = b.customerid where c.id = ? and b.accountid = ?");
			ps.setInt(1, id);
			ps.setString(2, bankaccount.getAccountid());
			ResultSet set = ps.executeQuery();
			set.next();
			int count = set.getInt(1);
			if(count != 0) {
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		FacesMessage msg = new FacesMessage("Invalid login.", "Invalid customer id or account id.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesMessage msg2 = new FacesMessage("", "Another message");
		FacesContext.getCurrentInstance().addMessage(null, msg2);
		return "failed";
	}
	
	public String goToCustomerList() {
		return "customerlist";
	}
}



