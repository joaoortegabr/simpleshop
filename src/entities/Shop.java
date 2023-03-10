package entities;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	protected List<Customer> customers = new ArrayList<Customer>();;
	protected List<Item> stock = new ArrayList<Item>();;
	protected Customer loggedCustomer = new Customer();
	protected Cart currentCart = new Cart();
	
	public Shop() {
//		List<Customer> customers = new ArrayList<Customer>();
//		List<Item> stock = new ArrayList<Item>();
//		Customer loggedCustomer = new Customer();
//		Cart currentCart = new Cart();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Item> getStock() {
		return stock;
	}
	
	public Customer getLoggedCustomer() {
		return loggedCustomer;
	}

	public void setLoggedCustomer(Customer loggedCustomer) {
		this.loggedCustomer = loggedCustomer;
	}

	public Cart getCurrentCart() {
		return currentCart;
	}

	public void setCurrentCart(Cart currentCart) {
		this.currentCart = currentCart;
	}

	public boolean checkIfItemExistsInShop(Item item) {
		boolean itemExists = false;
		for(Item i : stock) {
			if(i.equals(item)) {
				itemExists = true;
			}
		}
		return itemExists;
	}
	
	public boolean checkIfItemInStock(int quantity, Item item) {
		boolean itemAvailable = false;
		for(Item i : stock) {
			if(i.getQuantity() >= quantity) {
				itemAvailable = true;
			}
		}
		return itemAvailable;
	}
	
	public boolean checkItemInCart(Item item) {
		boolean itemInCart = false;
		for(Item i : currentCart.selectedItems) {
			if(i.equals(item)) {
				itemInCart = true;
			}
		}
		return itemInCart;
	}

	public int getQuantityOfItemInCart(Item item) {
		int quantity = 0;
		for(Item i : currentCart.selectedItems) {
			if(i.equals(item)) {
				quantity = i.getQuantity();
			}
		}
		return quantity;
	}
	
	
	public Item getItemByProduct(Product product) {
		Item item = null;
		for(Item i : stock) {
			if(i.getProduct().equals(product)) {
				item = i;
			}
		}
		return item;
	}

	public void addToCart(int quantity, Product product) {
		
		Item item = getItemByProduct(product);
		
		if(checkIfItemExistsInShop(item)) {
			if(checkIfItemInStock(quantity, item)) {
				if(checkItemInCart(item)) {
					for(Item i : currentCart.selectedItems ) {
						i.setQuantity(i.getQuantity() + quantity);
					}
				} else {
					currentCart.selectedItems.add(item);
				}
			} else {
				System.out.println("Quantidade n??o dispon??vel em estoque.");
			}
		} else {
			System.out.println("Produto n??o existe na loja.");
		}
	}

	public void removeFromCart(int quantity, Product product) {
		Item item = new Item(quantity, product);
		
		if(checkItemInCart(item)) {
			for(Item i : currentCart.selectedItems ) {
				if(i.getQuantity() >= quantity) {
					i.setQuantity(i.getQuantity() - quantity);
					return;
				} else {
					System.out.println("N??o h?? esta quantidade deste produto no carrinho.\n"
							+ "O carrinho tem " + i.getQuantity() + " deste item.");
					return;
				}
			}
		} else {
			System.out.println("Produto n??o existe no carrinho.");
		}
	}
	
	public void login(String username, String password) {
		
		if(checkIfCustomerExists(username)) {
			for(Customer c : customers) {
				if(c.getUsername().equals(username)) {
					if(c.checkIfPasswordIsBlank(password)) {
						if(c.checkIfPasswordIsValid(password)) {
							loggedCustomer.setId(c.getId()); 
							loggedCustomer.setUsername(c.getUsername());
							loggedCustomer.setCarts(c.getCarts());
							System.out.println("Usu??rio " + c.getUsername() + " logado com sucesso.\n"
									+ "Seu carrinho est?? vazio.");
						}
					}
				}
			}
		} else {
			System.out.println("Este usu??rio n??o existe no sistema.");
		}
	}
	
	public void logout() {
		loggedCustomer = null;
		currentCart = null;
		
	}
	
	public boolean checkIfCustomerExists(String username) {
		boolean customerExists = false;
		for(Customer c : customers) {
			if(c.getUsername().equals(username)) {
				customerExists = true;
			}
		}
		return customerExists;
	}
	
	public void mountOrderMenu() {
		System.out.println("\n========================");
		System.out.println("FA??A SEU PEDIDO");
		
		int numItems = 0;
		for(Item i : getStock()) {
			System.out.println(numItems++ + " - " + i.getProduct() + " - R$ " + i.getPrice());
		}
	}
	
	public Product selectProductFromOrderMenu(int option, Product product) {
		Product selectedProduct = getStock().get(option).getProduct();
		System.out.println("Voc?? escolheu " + selectedProduct);
		return selectedProduct;
	}
	

	
}
