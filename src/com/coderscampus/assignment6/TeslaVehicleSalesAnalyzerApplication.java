package com.coderscampus.assignment6;

import java.io.IOException;
import java.time.YearMonth;
import java.util.Map;

public class TeslaVehicleSalesAnalyzerApplication {

	public static void main(String[] args) throws IOException {

		final String fileModel3 = "model3.csv";
		final String fileModelS = "modelS.csv";
		final String fileModelX = "modelX.csv";
		FileParser fileParser = new FileParser();
		SalesAnalyzer aSalesAnalyzer = new SalesAnalyzer();
		Printer printer = new Printer();

		// read in files
		Map<YearMonth, Integer> model3 = fileParser.readModel(fileModel3);
		Map<YearMonth, Integer> modelS = fileParser.readModel(fileModelS);
		Map<YearMonth, Integer> modelX = fileParser.readModel(fileModelX);

		// get sale Years
		Object[] saleYearsModel3 = aSalesAnalyzer.saleYears(model3);
		Object[] saleYearsModelS = aSalesAnalyzer.saleYears(modelS);
		Object[] saleYearsModelX = aSalesAnalyzer.saleYears(modelX);
		
		// show reports
		printer.showResults(aSalesAnalyzer, model3, "Model 3", saleYearsModel3);
		printer.showResults(aSalesAnalyzer, modelS, "Model S", saleYearsModelS);
		printer.showResults(aSalesAnalyzer, modelX, "Model X", saleYearsModelX);
		
	}

}
