package com.coderscampus.assignment6;

import java.io.IOException;
import java.time.YearMonth;
import java.util.stream.Collectors;
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

		System.out.println(model3.get(YearMonth.of(2017, 12)));
		System.out.println(modelS.get(YearMonth.of(2017, 12)));
		System.out.println("dies ist get(YearMonth) 2017-12 von modelX " + modelX.get(YearMonth.of(2017, 12)));
		System.out.println("dies ist Integer 3300 von modelX " + modelX.get(3300));


		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->");
		System.out.println("2018 ->");
		System.out.println("2019 ->");
		System.out.println("\n\nThe best month for Model 3 was: yyyy-MM");
		System.out.println("The worst month for Model 3 was: yyyy-MM");
		

		Set<Entry<YearMonth, Integer>> entries = model3.entrySet();
		// Collection<Integer> values = someMap.values();	}
		System.out.println(entries);
		entries.stream()
				.forEach((entry) ->entry.getKey());
	
		entries.stream()
				.forEach((elem) -> {System.out.println("zugriff auf value ->" + elem.getValue());});
		entries.stream()
		.forEach((elem) -> {System.out.println("zugriff auf key-> " + elem.getKey());});
//		entries.stream()
//				.max(elem1, elem2.getValue()) :: elem1.getValue().compareTo(elem2.getValue());
		
//		entries.stream()
//		.min((entry1.getKey(), entry2.getKey()) -> entry1.get.compareTo(entry2.get()));
		// TODO not quite sure how it works... but it does! here is the max coming!
		IntSummaryStatistics stats = entries.stream()
											.mapToInt((x) -> x.getValue()).summaryStatistics();
		System.out.println("maybe one value which is the highest ...?" + stats.getMax());
		entries.stream()
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
		
	}

}

