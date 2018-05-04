package ejb;

import java.util.ArrayList;

import javax.ejb.Remote;

@Remote
public interface ShoppingCartInt {

	public void addToCart(Product prod);
	
	public ArrayList<Product> getCart();
	
	public String getTotalPrice();
}