package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class FileParser {
	
	// TODO do I need this constructor?
	public FileParser() {
		super();
	}

	public HashMap<YearMonth, Integer> readModel(String filename) throws IOException {
		
		BufferedReader fileReader = null;
		//if I wanted to try with an ArrayList: 
//		ArrayList<SalesData> tempSalesArLi= new ArrayList<SalesData>();
		HashMap <YearMonth, Integer> haMa = new HashMap<>();
		
		try {
			fileReader = new BufferedReader(new FileReader(filename));

			String line = ""; // to get rid off the first line
			line = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] newData = line.split(",");			
				SalesData tempObj = new SalesData(newData[0], newData[1]); 
//				tempSalesArLi.add(tempObj.getMonthYear(), tempObj.getSales());
				haMa.put(tempObj.getSalesMonth(), tempObj.getSales());

			}

		} finally {

			fileReader.close();
		}
		//how to get the value to a key;)
//		System.out.println("null here?" + haMa.get(YearMonth.of(2016, 1)));
//		return tempSalesArLi;
		return haMa;
	}

}
