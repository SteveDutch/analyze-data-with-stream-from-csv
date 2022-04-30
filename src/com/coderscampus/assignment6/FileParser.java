package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	
	public FileParser(String filename) throws IOException {
		
		BufferedReader fileReader = null;
		ArrayList <String[]> tempSales = new ArrayList<String[]>();
		
		try {
			fileReader = new BufferedReader(new FileReader(filename));

			String line = "";
			while ((line = fileReader.readLine()) != null) {
				String[] newData = line.split(",");			
				tempSales.add(newData);

				System.out.println(tempSales);
							
			}

		} finally {

			//fileReader.close();
		}
	}

}
