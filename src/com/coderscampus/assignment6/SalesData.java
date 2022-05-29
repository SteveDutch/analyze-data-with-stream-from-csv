package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SalesData {
	
	private String modell = null;
	private YearMonth salesMonth;
	private Integer sales;
	Locale deLocale = Locale.GERMANY;

	public SalesData(String salesMo, String sales) {
		this.salesMonth = YearMonth.parse(salesMo, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		this.sales = Integer.parseInt(sales);
	}

	public SalesData(String[] array) {
		this.salesMonth = YearMonth.parse(array[0], DateTimeFormatter.ofPattern("MMM-yy", deLocale));
		this.sales = Integer.parseInt(array[1]);
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public YearMonth getSalesMonth() {
		return salesMonth;
	}

	public void setSalesMonth(YearMonth salesMonth) {
		this.salesMonth = salesMonth;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
