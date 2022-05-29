package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.Map;

public class Printer {

	public void showResults (SalesAnalyzer aSalesAnalyzer, Map<YearMonth, Integer> teslaModel, String model, Object[] saleYears) {
		
		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------------");
		for (Object i : saleYears) {
			System.out.println(i + " ->  " + aSalesAnalyzer.yearlySales(teslaModel, Integer.parseInt(i.toString())).getSum());
		}
		System.out.println("\nThe best month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMax(teslaModel).get().getKey());
		System.out.println("The worst month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMin(teslaModel).get().getKey() + "\n");
		
	}
}
