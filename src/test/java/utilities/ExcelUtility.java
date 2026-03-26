package utilities;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	public class ExcelUtility {

	    private static Workbook workbook;
	    private static Sheet sheet;
	    private static DataFormatter formatter = new DataFormatter();

	    // Set Excel file and sheet
	    public static void setExcelFile(String excelPath, String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(excelPath);
	        workbook = WorkbookFactory.create(fis);
	        sheet = workbook.getSheet(sheetName);
	    }

	    // Get row count (excluding header)
	    public static int getRowCount() {
	        return sheet.getLastRowNum(); // header not counted
	    }

	    // Get column count
	    public static int getColumnCount() {
	        return sheet.getRow(0).getLastCellNum();
	    }

	    // Get cell data
	    public static String getCellData(int rowNum, int colNum) {
	        return formatter.formatCellValue(
	                sheet.getRow(rowNum).getCell(colNum)
	        );
	    }
	}
