package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FileParser {
	
	public FileParser() {
		super();

		// TODO Auto-generated constructor stub
	}

	public HashMap<YearMonth, Integer> readModel(String filename) throws IOException {
		
		BufferedReader fileReader = null;
		ArrayList<SalesData> tempSalesArLi= new ArrayList<SalesData>();
		HashMap <YearMonth, Integer> testHaMa = new HashMap<>();
		try {
			fileReader = new BufferedReader(new FileReader(filename));

			String line = "";
			line = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] newData = line.split(",");			
				SalesData tempObj = new SalesData(newData[0], newData[1]); 
//				tempSalesArLi.add(tempObj.getMonthYear(), tempObj.getSales());
				testHaMa.put(tempObj.getSalesMonth(), tempObj.getSales());

//				System.out.println(tempSalesArLi);
				
//				return tempSalesArLi;
				
			}

		} finally {

			fileReader.close();
		}
		
		System.out.println(testHaMa.get(YearMonth.of(2016, 1)));
//		return tempSalesArLi;
		return testHaMa;
	}

}
