package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.UsedProduct;
import entities.ImportedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<Product>  list = new ArrayList<>();
		
		System.out.println("Enter the number of products ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Produt #" + i +" data:" );
			System.out.println("Common, used or imported (c/u/i)? ");
			char item = sc.next().charAt(0);
			if(item == 'c') {
				sc.nextLine();
				System.out.print("Nome: ");
				String name =  sc.nextLine();
				System.out.print("Preço: ");
				Double price =  sc.nextDouble();
				
				list.add(new Product(name, price));
			}
			else if(item == 'u') {
				sc.nextLine();
				System.out.print("Nome: ");
				String name =  sc.nextLine();
				System.out.print("Preço: ");
				Double price =  sc.nextDouble();
				System.out.println("Manufacture date: ");
				String date = sc.next();
				LocalDate manufatureDate = LocalDate.parse(date, dtf);
				
				list.add(new UsedProduct(name, price, manufatureDate));
			}
			else {
				sc.nextLine();
				System.out.print("Nome: ");
				String name =  sc.nextLine();
				System.out.print("Preço: ");
				double price =  sc.nextDouble();
				System.out.println("Custom free:  ");
				double customsFree = sc.nextDouble();
				
				
				list.add(new ImportedProduct(name, price, customsFree));
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product item : list) {
			if(item instanceof UsedProduct) {
				UsedProduct usedItem = (UsedProduct) item;
				System.out.println(usedItem.getName()+ " (used)" + String.format(" $ %.2f", usedItem.getPrice())  + " (Manufactured Date: " + usedItem.getManufaturedDate().format(dtf)+")");
			}
			else if(item instanceof ImportedProduct) {
				ImportedProduct importedItem = (ImportedProduct) item;
				System.out.println(importedItem.getName() + String.format(" $ %.2f", importedItem.totalPrice()) + String.format(" (Custom Free: Custom Free: $ %.2f)", importedItem.getCustomsFree()));
				
			}
			else  {
				System.out.println(item.getName()+ String.format(" $ %.2f", item.getPrice()));
			}
		}

	}

}
