package entities;

public class Product {

	protected int productId;
	protected String name;
	
	public Product() {
	}

	public Product(int id, String name) {
		this.productId = id;
		this.name = name;
	}

	public int getId() {
		return productId;
	}

	public void setId(int id) {
		this.productId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
