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
		// preparedata for analyzing
		Set<Entry<YearMonth, Integer>> entries3 = model3.entrySet();
		Set<Entry<YearMonth, Integer>> entriesS = modelS.entrySet();
		Set<Entry<YearMonth, Integer>> entriesX = modelX.entrySet();
		
		// date variables for streams 
		YearMonth jan2016 = YearMonth.of(2016, 1); 
		YearMonth jan2017 = YearMonth.of(2017, 1);
		YearMonth jan2018 = YearMonth.of(2018, 1); 
		YearMonth jan2019 = YearMonth.of(2019, 1);
		
		
		// Verständnis SYSOs
//		System.out.println("dies ist get(YearMonth) 2017-12 von modelX :  " + modelX.get(YearMonth.of(2017, 12)));
//		System.out.println("dies ist  (modelX.get(3300)) funkt. aber nicht : " + modelX.get(3300));

		// -> monthly statistics (model 3)
//		IntSummaryStatistics monthlySalesStatistics = aSalesAnalyzer.getmonthlySaleStatistics(model3);
//		Optional<Entry<YearMonth, Integer>> maxMonth = extracted(entries3, monthlySalesStatistics);
//		Optional<Entry<YearMonth, Integer>> minMonth = entries3.stream()
//				.filter(ex -> ex.getValue() == monthlySalesStatistics.getMin()).findFirst();
		
				
		// TODO da ich dies 3x printen soll -> Methode, gell?
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(model3, jan2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(model3, jan2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(model3, jan2019).getSum());
		System.out.println("\nThe best month for Model 3 was: " + aSalesAnalyzer.getmonthlySalesMax(model3).get().getKey());
		System.out.println("The worst month for Model 3 was: " +  aSalesAnalyzer.getmonthlySalesMin(model3).get().getKey() + "\n");
		
		System.out.println("Model S Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelS, jan2016).getSum());
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelS, jan2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(modelS, jan2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(modelS, jan2019).getSum());
		System.out.println("\nThe best month for Model S was: " + aSalesAnalyzer.getmonthlySalesMax(modelS).get().getKey());
		System.out.println("The worst month for Model S was: " +  aSalesAnalyzer.getmonthlySalesMin(modelS).get().getKey() + "\n");
		
		System.out.println("Model X Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2016 ->  " + aSalesAnalyzer.yearlySales(modelX, jan2016).getSum());
		System.out.println("2017 ->  " + aSalesAnalyzer.yearlySales(modelX, jan2017).getSum());
		System.out.println("2018 ->  " + aSalesAnalyzer.yearlySales(modelX, jan2018).getSum());
		System.out.println("2019 ->  " + aSalesAnalyzer.yearlySales(modelX, jan2019).getSum());
		System.out.println("\nThe best month for Model X was: " + aSalesAnalyzer.getmonthlySalesMax(modelX).get().getKey());
		System.out.println("The worst month for Model X was: " +  aSalesAnalyzer.getmonthlySalesMin(modelX).get().getKey() + "\n");
		// TODO maybe do  it like Dan: put all learn stuff in an extra class

		// for me to learn: how wrap syso in.forEach
		entries3.stream()
		.forEach((elem) -> {System.out.print("stream-Zugriff auf key (elem.getKey) -> " + elem.getKey());});
		
		Stream<Entry<YearMonth,Integer>> YearSales20173 = entries3.stream()
										.filter((elem) -> elem.getKey().isBefore(jan2017));
										

		//Versuch mit filter()/.getMonthDate
		Stream<Entry<YearMonth, Integer>> result = YearSales20173
                .filter(ex -> ex.getKey().getYear() == (jan2017.getYear()));
		IntSummaryStatistics result2 = result.mapToInt((x) -> x.getValue()).summaryStatistics();
               
		//zwar kein Compilation-Fehler,abernicht das gewünscheErgebnis, oder: was wid hie gegroupt?
		Map<Object, Integer> YearSales2017X = entriesX.stream()
						.collect(Collectors.groupingBy(Entry::getKey, Collectors.summingInt(Entry::getValue)));
		System.out.println("another try with grouping by ...:  " + YearSales2017X);
		
		
		// TODO not quite sure how it works... but it does! here is the max coming! ... schön,wenn ein Plan gelingt ;)
		IntSummaryStatistics stats = entries3.stream().filter(ex -> ex.getKey().getYear() == (jan2017.getYear()))
											.mapToInt((x) -> x.getValue()).summaryStatistics();
		System.out.println("hier kriege ich die summe, müßte nur noch auf das gewünschte jahr reduzieren ..." + stats.getSum() + "yessssssssssss");
		
		// oh, eine frühe Version, die funktioniert hätte, hätte ich den Hinweis auf equals verstanden
		// TODOcheck if it's better than my code above
		Optional<YearMonth> optionalIsbn = model3.entrySet().stream()
				  .filter(e -> stats.getMax() == (e.getValue().intValue()))
				  .map(Map.Entry::getKey)
				  .findFirst();
		System.out.println("how to print an optional" + optionalIsbn.get().toString());

	}

	
	


}

