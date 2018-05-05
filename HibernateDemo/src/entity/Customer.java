package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String email;
	private Set<BankAccount> bankAccounts = new HashSet<BankAccount>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CUSTOMERIDSEQ")
	@SequenceGenerator(name="CUSTOMERIDSEQ", sequenceName="CUSTOMERIDSEQ")
	@Column(name="ID",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="FIRSTNAME")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="LASTNAME")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	public Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	
	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
}