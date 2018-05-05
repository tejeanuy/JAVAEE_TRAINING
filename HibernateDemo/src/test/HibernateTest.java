package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import entity.BankAccount;
import entity.Customer;
import util.HibernateUtil;

public class HibernateTest {

	private Session session;

	public HibernateTest() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void getClients() {

		session.beginTransaction();
		/*CriteriaQuery<Customer> criteriaQuery = session.getCriteriaBuilder().createQuery(Customer.class);
        criteriaQuery.from(Customer.class);
        List<Customer> customers = session.createQuery(criteriaQuery).getResultList();*/
        
        Query q = session.createQuery("from Customer");
        List<Customer> customers = q.getResultList();

		for(Customer c : customers) {
			System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getBirthday() + " " + c.getEmail());
			Iterator<BankAccount> accounts = c.getBankAccounts().iterator();
			while(accounts.hasNext()) {
				BankAccount ba = accounts.next();
				System.out.println(ba.getAccountid());
				System.out.println(ba.getAccountbalance());
			}
		}
		session.close();
	}
	
	public void getClient(String firstname,String lastname) {

		session.beginTransaction();
		/*CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> customer = criteriaQuery.from(Customer.class);
        criteriaQuery.select(customer);
        criteriaQuery.where(builder.equal(customer.get("firstname"), firstname),
        		builder.equal(customer.get("lastname"), lastname));
		List<Customer> customers = session.createQuery(criteriaQuery).getResultList();*/
		
		Query q = session.createQuery("from Customer where firstname = :firstname and lastname = :lastname");
		q.setParameter("firstname", firstname);
		q.setParameter("lastname", lastname);
		 
		List<Customer> customers = q.getResultList();

		for(Customer c : customers) {
			System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getBirthday() + " " + c.getEmail());
			Iterator<BankAccount> accounts = c.getBankAccounts().iterator();
			while(accounts.hasNext()) {
				BankAccount ba = accounts.next();
				System.out.println(ba.getAccountid());
				System.out.println(ba.getAccountbalance());
			}
			
		}
		session.close();
	}

	public void addCustomer(String firstname, String lastname, java.util.Date birthday, String email, Double accountbalance) {
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customer.setBirthday(birthday);
		customer.setEmail(email);

		session.save(customer);

		BankAccount ba = new BankAccount();
		StringBuilder sb = new StringBuilder();
		sb.append(firstname.substring(0, 1) + lastname.substring(0, 1) + customer.getId());
		ba.setAccountid(sb.toString());
		ba.setAccountbalance(accountbalance);
		
		ba.setCustomer(customer);
		customer.getBankAccounts().add(ba);
		
		session.save(customer);
		
		session.getTransaction().commit();

		session.close();
	}

	public void updateBalance(int customerid, Double accountbalance) {
		session.beginTransaction();

		Query q = session.createQuery("from BankAccount where customerid = :customerid");
		q.setParameter("customerid", customerid);

		BankAccount b = (BankAccount) q.getResultList().get(0);
		b.setAccountbalance(accountbalance);

		session.save(b);

		session.getTransaction().commit();

		session.close();
	}

	public void deleteCustomer(int id) {
		session.beginTransaction();

		Query q = session.createQuery("from Customer where id = :id");
		q.setParameter("id", id);
		Customer customer = (Customer) q.getResultList().get(0);
		session.delete(customer);

		session.getTransaction().commit();

		session.close();
	}
	
	public static void main(String[] args) throws ParseException {
		/*new HibernateTest().getClients();
		new HibernateTest().getClient("John","Doe");
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date bday = formatter.parse("12-Jan-2000");
		new HibernateTest().addCustomer("Chris", "Pratt", bday, "cp@gmail.com", 500d);*/
		//new HibernateTest().updateBalance(1001, 600d);
		new HibernateTest().deleteCustomer(1001);
	}
}
