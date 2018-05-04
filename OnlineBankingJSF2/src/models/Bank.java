package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dbconnection.Connector;

@SuppressWarnings("deprecation")
@ManagedBean(name="bank")
@SessionScoped
public class Bank {
	
	private ArrayList<Customer> customers;

	public Bank() {
		customers = new ArrayList<Customer>();
		Connector connector = new Connector();
		try {
			Statement stat = connector.getCon().createStatement();
			ResultSet set = stat.executeQuery("select * from customer c join bankaccount b on c.id = b.customerid");
			while(set.next()) {
				Customer c = new Customer();
				c.setId(set.getInt(1));
				c.setFirstname(set.getString(2));
				c.setLastname(set.getString(3));
				c.setBirthday(set.getDate(4).toString());
				c.setEmail(set.getString(5));
				c.setBankaccount(new BankAccount());
				c.getBankaccount().setAccountid(set.getString(6));
				c.getBankaccount().setAccountbalance(set.getDouble(7));
				customers.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
}
