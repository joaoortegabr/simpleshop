package entities;

import java.util.ArrayList;
import java.util.List;

public class Shop {

	protected List<Customer> customers = new ArrayList<Customer>();;
	protected List<Item> stock = new ArrayList<Item>();;
	protected Customer loggedCustomer = new Customer();
	protected Cart currentCart = new Cart();
	
	public Shop() {
		List<Customer> customers = new ArrayList<Customer>();
		List<Item> stock = new ArrayList<Item>();
		Customer loggedCustomer = new Customer();
		Cart currentCart = new Cart();
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
	
	public void addToCart(int quantity, Product product) {
		Item item = new Item(quantity, product);
		
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
				System.out.println("Quantidade não disponível em estoque.");
			}
		} else {
			System.out.println("Produto não existe na loja.");
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
					System.out.println("Não há esta quantidade deste produto no carrinho.\n"
							+ "O carrinho tem " + i.getQuantity() + " deste item.");
					return;
				}
			}
		} else {
			System.out.println("Produto não existe no carrinho.");
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
							System.out.println("Usuário " + c.getUsername() + " logado com sucesso.");
						}
					}
				}
			}
		} else {
			System.out.println("Este usuário não existe no sistema.");
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
	
	

	
}
