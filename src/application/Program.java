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
			sc.nextLine();
			System.out.print("Nome: ");
			String name =  sc.nextLine();
			System.out.print("Preço: ");
			Double price =  sc.nextDouble();
			if(item == 'c') {
				list.add(new Product(name, price));
			}
			else if(item == 'u') {
				System.out.println("Manufacture date: ");
				String date = sc.next();
				LocalDate manufatureDate = LocalDate.parse(date, dtf);
				
				list.add(new UsedProduct(name, price, manufatureDate));
			}
			else {
				System.out.println("Custom fee:  ");
				double customsFee = sc.nextDouble();
			
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product item : list) {
			System.out.println(item.priceTag());
		}
		
		sc.close();
	}

}
