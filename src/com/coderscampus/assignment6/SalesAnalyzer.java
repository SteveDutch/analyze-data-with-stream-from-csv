package com.coderscampus.assignment6;

import java.time.YearMonth;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

public class SalesAnalyzer {

	public IntSummaryStatistics yearlySales(Map<YearMonth, Integer> teslaModel, Integer year) {
		Set<Entry<YearMonth, Integer>> entries = teslaModel.entrySet();
		YearMonth yearmonth = YearMonth.of(year, 1);
		IntSummaryStatistics salesThisYear = entries.stream()
				.filter(ex -> ex.getKey().getYear() == (yearmonth.getYear())).mapToInt((x) -> x.getValue())
				.summaryStatistics();
		return salesThisYear;
	}

	public Optional<Entry<YearMonth, Integer>> getMonthlySalesMax(Map<YearMonth, Integer> teslaModel) {
		Set<Entry<YearMonth, Integer>> entries = teslaModel.entrySet();
		IntSummaryStatistics monthlySalesStatistics = entries.stream().mapToInt((x) -> x.getValue())
				.summaryStatistics();

		Optional<Entry<YearMonth, Integer>> maxMonth = entries.stream()
				.filter(ex -> ex.getValue() == monthlySalesStatistics.getMax()).findFirst();
		return maxMonth;

	}

	public Optional<Entry<YearMonth, Integer>> getMonthlySalesMin(Map<YearMonth, Integer> teslaModel) {
		Set<Entry<YearMonth, Integer>> entries = teslaModel.entrySet();
		IntSummaryStatistics monthlySalesStatistics = entries.stream().mapToInt((x) -> x.getValue())
				.summaryStatistics();

		Optional<Entry<YearMonth, Integer>> minMonth = entries.stream()
				.filter(ex -> ex.getValue() == monthlySalesStatistics.getMin()).findFirst();
		return minMonth;

	}

}
