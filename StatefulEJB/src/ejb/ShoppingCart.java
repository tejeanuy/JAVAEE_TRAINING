package ejb;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.ejb.Stateful;

@Stateful
public class ShoppingCart implements ShoppingCartInt, Serializable {

	private ArrayList<Product> cart;
	
	public ShoppingCart() {
		cart = new ArrayList<Product>();
	}

	@Override
	public void addToCart(Product prod) {
		cart.add(prod);
	}

	@Override
	public ArrayList<Product> getCart() {
		return cart;
	}

	@Override
	public String getTotalPrice() {
		double total = 0d;
		for(Product prod : cart) {
			total += prod.getPrice();
		}
		DecimalFormat df = new DecimalFormat("Php###,###.00");
		return df.format(total);
	}
}
