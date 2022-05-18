package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.Map;

public class Printer {

	public void showResults(SalesAnalyzer aSalesAnalyzer, Map<YearMonth, Integer> teslaModel, String model) {

		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2016 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2016).getSum());
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2019).getSum());
		System.out.println("\nThe best month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMax(teslaModel).get().getKey());
		System.out.println("The worst month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMin(teslaModel).get().getKey() + "\n");
	}

	public void showResultsThreeYears(SalesAnalyzer aSalesAnalyzer, Map<YearMonth, Integer> teslaModel, String model) {
		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(teslaModel, 2019).getSum());
		System.out.println("\nThe best month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMax(teslaModel).get().getKey());
		System.out.println("The worst month for " + model + " was: "
				+ aSalesAnalyzer.getMonthlySalesMin(teslaModel).get().getKey() + "\n");
	}
}
