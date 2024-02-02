package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	private Date manufactureDate;

	public UsedProduct(String name, Double price, String manufactureDateStr) {
		super(name, price);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.manufactureDate = sdf.parse(manufactureDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		return super.priceTag() + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}

}
