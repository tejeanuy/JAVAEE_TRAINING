package ejb;

import java.util.ArrayList;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ManagedBean
@SessionScoped
public class ClientEJBBean {
	
	private ArrayList<Product> productlist;
	
	private ShoppingCartInt cart;
	
	private int id;
	
	public ClientEJBBean() {}

	@PostConstruct
	public void init() {
		System.out.println("Getting EJB");
		productlist = new ArrayList<Product>();
		productlist.add(new Product(1, "PS4", 25000d));
		productlist.add(new Product(2, "Xbox", 26000d));
		productlist.add(new Product(3, "Switch", 28000d));
		
		final Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, 
				org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		prop.put("jboss.naming.client.ejb.context", true);
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8082");
		try {
			InitialContext remoteContext = new InitialContext(prop);
			cart = (ShoppingCartInt) remoteContext.lookup("StatefulEJB/ShoppingCart!ejb.ShoppingCartInt");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Product>  getProductlist() {
		return productlist;
	}

	public void setProductlist(ArrayList<Product> productlist) {
		this.productlist = productlist;
	}

	public ArrayList<Product> getCart() {
		return cart.getCart();
	}
	
	public String addToCart() {
		this.cart.addToCart(productlist.get(id - 1));
		return "shoppingcart";
	}
	
	public String getTotalPrice() {
		return this.cart.getTotalPrice();
	}
}
