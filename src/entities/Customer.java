package entities;

import java.util.List;

public class Customer {

	protected int id;
	protected String username;
	protected String password;
	protected List<Cart> carts;
	
	public Customer() {
	}

	public Customer(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + ", Username: " + username + ", carts: " + carts;
	}
	
	public boolean checkIfPasswordIsBlank(String password) {
		boolean passwordProvided = true;
		if(password.isBlank()) {
			passwordProvided = false;
		} else if(password.isEmpty()) {
			passwordProvided = false;
		}
		return passwordProvided;
	}
	
	public boolean checkIfPasswordIsValid(String passwordProvided) {
		boolean passwordIsValid = false;
		if(this.password.equals(passwordProvided)) {
			passwordIsValid = true;
		} else {
			System.out.println("Senha incorreta. Tente novamente.");
		}
		return passwordIsValid;
	}
	
	
	
}
