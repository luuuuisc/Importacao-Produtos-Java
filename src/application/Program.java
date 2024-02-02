package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product # " + i + " data: ");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (type == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct (name, price, customsFee));
			}
			
			else if(type == 'u') {
				System.out.println("Manufacture date (dd/MM/yyyy): ");
				sc.nextLine();
				String dateString = sc.next();
				products.add(new UsedProduct(name, price, dateString));
			}
			
			else {
				products.add(new Product(name,price));
			}
		}
		
		for (Product prod : products) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();

	}

}
