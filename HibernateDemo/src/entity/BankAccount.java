package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANKACCOUNT")
public class BankAccount {
	
	private Double accountbalance;
	private String accountid;
	private Customer customer;

	@Id
	@Column(name="ACCOUNTID",unique=true,nullable=false)
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	
	@Column(name="ACCOUNTBALANCE",unique=true,nullable=false)
	public Double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(Double accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMERID", nullable = true)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}