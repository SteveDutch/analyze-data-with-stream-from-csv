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

	public static void main(String[] args) throws IOException {
		
		final String fileModel3 = "model3.csv";
		final String fileModelS = "modelS.csv";
		final String fileModelX = "modelX.csv";
		FileParser report = new FileParser();

		Map<YearMonth, Integer> model3 = report.readModel(fileModel3);
		Map<YearMonth, Integer> modelS = report.readModel(fileModelS);
		Map<YearMonth, Integer> modelX = report.readModel(fileModelX);

		Set<Entry<YearMonth, Integer>> entries3 = model3.entrySet();
		Set<Entry<YearMonth, Integer>> entriesS = modelS.entrySet();
		Set<Entry<YearMonth, Integer>> entriesX = modelX.entrySet();
		
		
		YearMonth jan2016 = YearMonth.of(2016, 1); 
		YearMonth jan2017 = YearMonth.of(2017, 1);
		YearMonth jan2018 = YearMonth.of(2018, 1); 
		YearMonth jan2019 = YearMonth.of(2019, 1);
		YearMonth jan2020 = YearMonth.of(2020, 1); 


		
		IntSummaryStatistics sales3year2017 = entries3.stream()
				.filter(ex -> ex.getKey().getYear() == (jan2017.getYear()))
				.mapToInt((x) -> x.getValue()).summaryStatistics();
		
		IntSummaryStatistics sales3year2018 = entries3.stream().filter(ex -> ex.getKey().getYear() == (jan2018.getYear()))
				.mapToInt((x) -> x.getValue()).summaryStatistics();
		IntSummaryStatistics sales3year2019 = entries3.stream().filter(ex -> ex.getKey().getYear() == (jan2019.getYear()))
				.mapToInt((x) -> x.getValue()).summaryStatistics();
		

		System.out.println(model3.get(YearMonth.of(2017, 12)));
		System.out.println(modelS.get(YearMonth.of(2017, 12)));
		System.out.println("dies ist get(YearMonth) 2017-12 von modelX " + modelX.get(YearMonth.of(2017, 12)));
		System.out.println("dies ist Integer 3300 von modelX (modelX.get(3300)) funkt. aber nicht \n" + modelX.get(3300));

//		-> TODO hier


		IntSummaryStatistics testSales20173 = entries3.stream().mapToInt((x) -> x.getValue()).summaryStatistics();
		Optional<Entry<YearMonth, Integer>> maxMonth = entries3.stream()
				.filter(ex -> ex.getValue() == testSales20173.getMax()).findFirst();
		Optional<Entry<YearMonth, Integer>> minMonth = entries3.stream()
				.filter(ex -> ex.getValue() == testSales20173.getMin()).findFirst();
		
		
		
		// TODO da ich dies 3x printen soll -> Methode, gell?
		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->  " + sales3year2017.getSum());
		System.out.println("2018 ->  " + sales3year2018.getSum());
		System.out.println("2019 ->  " + sales3year2019.getSum());
		System.out.println("\nThe best month for Model 3 was: " + maxMonth.get().getKey());
		System.out.println("The worst month for Model 3 was: " +  minMonth.get().getKey() + "\n");
		


		// Collection<Integer> values = someMap.values();	}
		System.out.println("entry-set of model x =  " + entriesX);
//		Integer year20173  = entries3.stream()
//				.forEach((entry) -> entry.getValue());
	
		entries3.stream()
				.forEach((elem) -> {System.out.print("stream-Zugriff auf value (elem.getValue) ->" + elem.getValue());});
		entries3.stream()
		.forEach((elem) -> {System.out.print("stream-Zugriff auf key (elem.getKey) -> " + elem.getKey());});
//		entries.stream()
//				.max(elem1, elem2.getValue()) :: elem1.getValue().compareTo(elem2.getValue());
		Stream<Entry<YearMonth,Integer>> YearSales20173 = entries3.stream()
										.filter((elem) -> elem.getKey().isBefore(jan2017));
									//	.reduce((elem1.getValue()), elem2.getValue()) :: elem1.getValue() + elem2.getValue();
		System.out.println(YearSales20173);
		

		//Versuch mit filter()/.getMonthDate
		Stream<Entry<YearMonth, Integer>> result = YearSales20173
                .filter(ex -> ex.getKey().getYear() == (jan2017.getYear()));
		IntSummaryStatistics result2 = result.mapToInt((x) -> x.getValue()).summaryStatistics();
               
		
		Map<Object, Integer> YearSales2017X = entriesX.stream()
						.collect(Collectors.groupingBy(Entry::getKey, Collectors.summingInt(Entry::getValue)));
		System.out.println("another try with grouping by ...:  " + YearSales2017X);
		//		entries.stream()
//		.min((entry1.getKey(), entry2.getKey()) -> entry1.get.compareTo(entry2.get()));
		
		// TODO not quite sure how it works... but it does! here is the max coming!
		IntSummaryStatistics stats = entries3.stream().filter(ex -> ex.getKey().getYear() == (jan2017.getYear()))
											.mapToInt((x) -> x.getValue()).summaryStatistics();
		System.out.println("hier kriege ich die summe, müßte nur noch auf das gewünschte jahr reduzieren ..." + stats.getSum() + "yessssssssssss");
		entriesX.stream()
				.forEach((x) -> x.getKey());
		// Optional<Integer> minNumber = entries.stream().min(elem1.getValue(), elem2.getValue()); -> {elem1.compareTo(elem2);}
		
//		System.out.printl("Max merge time=%d%n", ((Entry<YearMonth, Integer>) entries).getValue().stream().max(Integer::compare).get());
		
//		Optional<YearMonth> optionalIsbn = model3.entrySet().stream()
//				  .filter(e -> stats.getMax().equals(e.getValue().intValue()))
//				  .map(Map.Entry::getKey)
//				  .findFirst();
//
//		-->	hier weiter		assertEquals("978-0134685991", optionalIsbn.get());

//		Optional<Integer> minNumber = entries
//		.stream()
//		.max(Comparator.comparingInt(entries :: elem.getValue));
//		entries3.stream()
//		.map((elem) -> elem.getKey(withYear(2019))
//				.forEach((x) -> System.out.println("stream-Zugriff auf key (elem.getKey) -> ")));
	}

}

