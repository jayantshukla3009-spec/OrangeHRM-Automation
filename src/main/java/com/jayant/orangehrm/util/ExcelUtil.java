package com.jayant.orangehrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] getLoginData(String filepath, String sheetName) throws IOException {
		Object[][] logindata = null;
		try {

			File f1 = new File(filepath);
			FileInputStream fis = new FileInputStream(f1);
			Workbook wb = new XSSFWorkbook(fis);// we are reading the workbook data
			Sheet sheet = wb.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = sheet.getRow(0).getPhysicalNumberOfCells();
			logindata = new Object[rows - 1][cells];
			for (int i = 1; i < rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cells; j++) {
					Cell cell = row.getCell(j);
					logindata[i - 1][j] = cell.toString();
				}
			}
			wb.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logindata;
	}
}
