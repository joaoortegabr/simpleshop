package entities;

public class Item {

	protected int quantity;
	protected Product product;
	protected Double price;

	public Item() {
	}
	
	public Item(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	
	public Item(int quantity, Product product, Double price) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return quantity + "x " + product + " - R$ " + price;
	}
	
	
	
}
