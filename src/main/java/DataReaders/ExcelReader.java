package DataReaders;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
	
	
	private String path;
	private FileInputStream fis=null;
	
	private FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	
	
	public ExcelReader(String path) {
		
		this.path = path;
		try {
			fis = new FileInputStream(this.path);
			workbook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String readData(String sheetName, String tcID, String key) {
		
		sheet=workbook.getSheet(sheetName);
		
		XSSFRow r=sheet.getRow(0);
		
		XSSFCell c=r.getCell(1);
		
		String v= c.getStringCellValue();
		
		return v;
			
		
	}
	
	public static void main(String arg[]) {

		ExcelReader obj1 = new ExcelReader(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\TestData\\\\CPIP.xlsx");
				//new DataReader("D:\\TestAutomation\\CPIS_CucumberFramework\\src\\main\\java\\DataReaders\\CPIP.xlsx");
	//	obj1.loadSheetData("Sheet1");
  	//   System.out.println("Value >> " + obj1.getValueForKey("Sheet1", "TC_427210", "1000Char"));
  	  obj1.readData("kratika", "TCID1", "URL");
  	
	//IniFile iniobj = new IniFile();
	
	//System.out.println(iniobj.getIniValue("HPIP", "ini_1000_Character"));	
//	System.out.println(obj1.getValueForKey("Sheet1", "TC_427210", "1000Char"));
//         	obj1.getIterationValueForKey("TCID_001", "url", 5);
	}
	
	
}
