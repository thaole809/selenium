package com.automation.pom.pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenProvider {

	private static final String DATA_PATH = "./data/assignment2_data_test.xlsx";

	@DataProvider(name = "Excel")
	public static Object[][] testDataGenerator() throws IOException {
		FileInputStream file = new FileInputStream(DATA_PATH);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Login");
		int numOfData = sheet.getPhysicalNumberOfRows();
		int numOfField = 2;
		Object data[][] = new Object[numOfData][numOfField];

		for (int i = 0; i < numOfData; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < numOfField; j++) {
				XSSFCell cell = row.getCell(j);
				if (cell == null || cell.getStringCellValue().isEmpty()) {
					continue;
				}
				data[i][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}

}
