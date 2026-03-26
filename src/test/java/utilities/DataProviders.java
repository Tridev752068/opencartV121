package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider1
	    @DataProvider(name = "LoginData")
	    public static Object[][] getExcelData() throws IOException {

	        String excelPath = ".\\testData\\Opencart.xlsx";
	        String sheetName = "Sheet1";

	        ExcelUtility.setExcelFile(excelPath, sheetName);

	        int rows = ExcelUtility.getRowCount();
	        int cols = ExcelUtility.getColumnCount();

	        Object[][] data = new Object[rows][cols];

	        for (int i = 1; i <= rows; i++) { // skip header
	            for (int j = 0; j < cols; j++) {
	                data[i - 1][j] = ExcelUtility.getCellData(i, j);
	            }
	        }
	        return data;
	    }
	}

	//DataProvider2

	//DataProvider3

	//DataProvider4