package ejb;

import java.io.Serializable;

public class Product implements Serializable {
	
	private int id;
	private String prodname;
	private Double price;
	
	public Product(int id, String prodname, Double price) {
		this.id = id; this.prodname = prodname; this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
