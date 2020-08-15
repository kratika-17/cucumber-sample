package Libraries;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;

import Libraries.ExcelSheet;



public class CommonLibrary {

	public static HashMap<String, String> dataObj;
	 public static HashMap<String, String> getEachExcelRowDataIntoHashMapObj(ExcelSheet ex, String sheetName, int currentRowNumber, String testDataFileName) {

	        DataFormatter formatter = new DataFormatter();
	        XSSFRow rowWithColumnNames = null;
	        try {
	            rowWithColumnNames = ExcelSheet.getRow(sheetName, 0, testDataFileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        HashMap<String, String> eachTestCaseData = new HashMap<String, String>();

	        XSSFRow rowCurrent = null;
	        try {
	            rowCurrent = ExcelSheet.getRow(sheetName, currentRowNumber, testDataFileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        for (int p = 0; p < rowWithColumnNames.getLastCellNum(); p++) {
	            //Ignore the columns without any column name in test case excel file
	            if (formatter.formatCellValue(rowWithColumnNames.getCell(p)) == "") {
	                continue;
	            }
	            String RowValue;

	            RowValue = formatter.formatCellValue((rowCurrent.getCell(p))).trim();

	            eachTestCaseData.put(formatter.formatCellValue((rowWithColumnNames.getCell(p))).trim(), RowValue);
	            //System.out.println(eachTestCaseData);
	        }

	        return eachTestCaseData;

	    }

}
