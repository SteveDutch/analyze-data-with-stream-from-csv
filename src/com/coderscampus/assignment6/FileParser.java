package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.HashMap;

public class FileParser {

	public HashMap<YearMonth, Integer> readModel(String filename) throws IOException {

		BufferedReader fileReader = null;
		// if I wanted to try with an ArrayList:
//		ArrayList<SalesData> tempSalesArLi= new ArrayList<SalesData>();
		HashMap<YearMonth, Integer> haMa = new HashMap<>();
		// TODO catch an empty row in data? ergibt ArrayIndexOutOfBoundsException
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

//		return tempSalesArLi;
		return haMa;
	}

}
