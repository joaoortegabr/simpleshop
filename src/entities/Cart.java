package entities;

import java.util.HashSet;
import java.util.Set;

public class Cart {

	protected int id;
	protected Set<Item> selectedItems = new HashSet<Item>();
	
	public Cart() {
	}

	public Cart(int id, Set<Item> selectedItems) {
		this.id = id;
		this.selectedItems = selectedItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Item> getSelectedItems() {
		return selectedItems;
	}
	
	public void listItemsInCart() {
		if(this.selectedItems != null) {
			for(Item i : getSelectedItems() ) {
				System.out.println(i);
			}	
		} else {
			System.out.println("O carrinho está vazio.");
		}
		
	}
	
	
}
