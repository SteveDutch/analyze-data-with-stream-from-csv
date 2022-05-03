package com.coderscampus.assignment6;

import java.io.IOException;
import java.time.YearMonth;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class TeslaVehicleSalesAnalyzerApplication {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String fileModel3 = "model3.csv";
		final String fileModelS = "modelS.csv";
		final String fileModelX = "modelX.csv";
		FileParser report = new FileParser();

		HashMap<YearMonth, Integer> model3 = report.readModel(fileModel3);
		HashMap<YearMonth, Integer> modelS = report.readModel(fileModelS);
		HashMap<YearMonth, Integer> modelX = report.readModel(fileModelX);

		System.out.println(model3.get(YearMonth.of(2017, 12)));
		System.out.println(modelS.get(YearMonth.of(2017, 12)));
		System.out.println(modelX.get(YearMonth.of(2017, 12)));

		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		System.out.println("2017 ->");
		System.out.println("2018 ->");
		System.out.println("2019 ->");
		System.out.println("\n\nThe best month for Model 3 was: yyyy-MM");
		System.out.println("The worst month for Model 3 was: yyyy-MM");
		

	}

}
