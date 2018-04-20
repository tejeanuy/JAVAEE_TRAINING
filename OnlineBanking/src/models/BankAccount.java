package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnection.Connector;

public class BankAccount {
	
	private Double accountbalance;
	private String accountid;

	public Double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(Double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public boolean createBankAccount(Integer customerid) {
		Connector connector = new Connector();
		int row = 0;
		try {
			PreparedStatement ps = connector.getCon().prepareStatement("insert into bankaccount values (?,?,?)");
			ps.setString(1, accountid);
			ps.setDouble(2, accountbalance);
			ps.setInt(3, customerid);
			
			row = ps.executeUpdate();
			connector.close();
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
