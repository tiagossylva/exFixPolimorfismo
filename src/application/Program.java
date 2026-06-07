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
		}
		System.out.println("products");
		for(Product item : list) {
			if(item instanceof UsedProduct) {
				UsedProduct usedItem = (UsedProduct) item;
				System.out.println(usedItem.getName()+ " " + usedItem.getPrice() +" " + usedItem.getManufaturedDate().format(dtf) );
			}
			else {
				System.out.println(item.getName()+ " "+ item.getPrice());
			}
		}

	}

}
