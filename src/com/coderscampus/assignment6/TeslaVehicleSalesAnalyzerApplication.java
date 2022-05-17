package com.coderscampus.assignment6;

import java.io.IOException;
import java.time.YearMonth;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

public class TeslaVehicleSalesAnalyzerApplication {

	

//	public TeslaVehicleSalesAnalyzerApplication(SalesAnalyzer aSalesAnalyzer) {
//		salesAnalyzer = aSalesAnalyzer;
//	}

	public static void main(String[] args) throws IOException {
		
		final String fileModel3 = "model3.csv";
		final String fileModelS = "modelS.csv";
		final String fileModelX = "modelX.csv";
		FileParser report = new FileParser();
		SalesAnalyzer aSalesAnalyzer = new SalesAnalyzer();
		
		//read in files
		Map<YearMonth, Integer> model3 = report.readModel(fileModel3);
		Map<YearMonth, Integer> modelS = report.readModel(fileModelS);
		Map<YearMonth, Integer> modelX = report.readModel(fileModelX);

		
		
	
				
		// TODO da ich dies 3x printen soll -> Methode, gell?
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(model3, 2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(model3, 2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(model3, 2019).getSum());
		System.out.println("\nThe best month for Model 3 was: " + aSalesAnalyzer.getmonthlySalesMax(model3).get().getKey());
		System.out.println("The worst month for Model 3 was: " +  aSalesAnalyzer.getmonthlySalesMin(model3).get().getKey() + "\n");
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelS, 2016).getSum());
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelS, 2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(modelS, 2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(modelS, 2019).getSum());
		System.out.println("\nThe best month for Model S was: " + aSalesAnalyzer.getmonthlySalesMax(modelS).get().getKey());
		System.out.println("The worst month for Model S was: " +  aSalesAnalyzer.getmonthlySalesMin(modelS).get().getKey() + "\n");
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2016 ->  " + aSalesAnalyzer.yearlySales(modelX, 2016).getSum());
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelX, 2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(modelX, 2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(modelX, 2019).getSum());
		System.out.println("\nThe best month for Model X was: " + aSalesAnalyzer.getmonthlySalesMax(modelX).get().getKey());
		System.out.println("The worst month for Model X was: " +  aSalesAnalyzer.getmonthlySalesMin(modelX).get().getKey() + "\n");
		
		

	}

	
	


}

