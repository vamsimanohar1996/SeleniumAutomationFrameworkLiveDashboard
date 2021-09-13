package org.personal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.personal.constants.Constants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestData(String sheetName) {
		
		List<Map<String, String>> list=null;
		FileInputStream fs = null;
		try {

			 fs = new FileInputStream(Constants.getExcelPath());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			 list = new ArrayList<>();
			for (int i = 1; i <= rows; i++) 
			{
				map = new HashMap<>();
				for (int j = 0; j < cols; j++) 
				{
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
			
	
		} catch (FileNotFoundException fn) {
			fn.printStackTrace();

		} catch (IOException io) {
			io.printStackTrace();
		}
		
		finally
		{
			try {
				if(Objects.nonNull(fs))
				{
					fs.close();
				}
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

}
