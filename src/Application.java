
import java.util.Scanner;

import entities.Customer;
import entities.Item;
import entities.Product;
import entities.Shop;

public class Application {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Shop shop = new Shop();

		Item i1 = new Item(10, new Product(1, "Hamburguer"), 22.0);
		Item i2 = new Item(10, new Product(2, "Batata Frita"), 12.0);
		Item i3 = new Item(10, new Product(3, "Yakissoba"), 25.0);
		Item i4 = new Item(10, new Product(4, "Sanduíche"), 10.0);
		Item i5 = new Item(10, new Product(5, "Coca-Cola"), 6.0);
		Item i6 = new Item(10, new Product(6, "Guaraná"), 6.0);
		Item i7 = new Item(10, new Product(7, "Suco de Laranja"), 9.0);
		shop.getStock().add(i1);
		shop.getStock().add(i2);
		shop.getStock().add(i3);
		shop.getStock().add(i4);
		shop.getStock().add(i5);
		shop.getStock().add(i6);
		shop.getStock().add(i7);

		Customer c1 = new Customer(1, "Joao", "123");
		Customer c2 = new Customer(2, "Jackson", "123");
		shop.getCustomers().add(c1);
		shop.getCustomers().add(c2);
		
		
		shop.getCurrentCart().listItemsInCart();
		
		
		System.out.println("Informe seu nome de usuário: ");
		String username = sc.nextLine();
		System.out.println("Informe a senha: ");
		String password = sc.nextLine();
		
		
		shop.login(username, password);
		
		System.out.println(shop.getLoggedCustomer());
		
		
		
		
		// FOR EACH comlambda
		//nomedaLista.stream().map(novonomedaLista -> novonomedalist.getNome()).collect(Collectors.toList());
		
		
	}

}
