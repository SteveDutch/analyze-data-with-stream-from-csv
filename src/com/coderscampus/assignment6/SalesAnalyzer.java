package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SalesAnalyzer {
	
	public static IntSummaryStatistics yearlySales(Map<YearMonth, Integer> teslaModel, YearMonth yearmonth) {
		Set<Entry<YearMonth, Integer>> entries3 = teslaModel.entrySet();

		IntSummaryStatistics salesthisyear = entries3.stream()
				.filter(ex -> ex.getKey().getYear() == (yearmonth.getYear()))
				.mapToInt((x) -> x.getValue()).summaryStatistics();
		return salesthisyear;
	}


}
