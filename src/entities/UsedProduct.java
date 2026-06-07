package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UsedProduct extends Product{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manufaturedDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufaturedDate) {
		super(name, price);
		this.manufaturedDate = manufaturedDate;
	}

	public LocalDate getManufaturedDate() {
		return manufaturedDate;
	}

	public void setManufaturedDate(LocalDate manufaturedDate) {
		this.manufaturedDate = manufaturedDate;
	}

	@Override
	public String toString() {
		return "UsedProduct [manufaturedDate=" + manufaturedDate.format(dtf) + "]";
	}
	
	
}
