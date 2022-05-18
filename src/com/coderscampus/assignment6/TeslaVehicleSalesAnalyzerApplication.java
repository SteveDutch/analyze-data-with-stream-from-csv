package com.coderscampus.assignment6;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Map;

public class TeslaVehicleSalesAnalyzerApplication {

	public static void main(String[] args) throws IOException {

		final String fileModel3 = "model3.csv";
		final String fileModelS = "modelS.csv";
		final String fileModelX = "modelX.csv";
		FileParser report = new FileParser();
		SalesAnalyzer aSalesAnalyzer = new SalesAnalyzer();
		Printer printer = new Printer();

		// read in files
		Map<YearMonth, Integer> model3 = report.readModel(fileModel3);
		Map<YearMonth, Integer> modelS = report.readModel(fileModelS);
		Map<YearMonth, Integer> modelX = report.readModel(fileModelX);

		// show reports
		printer.showResultsThreeYears(aSalesAnalyzer, model3, "Model 3");
		printer.showResults(aSalesAnalyzer, modelS, "Model S");
		printer.showResults(aSalesAnalyzer, modelX, "Model X");

	}

}
