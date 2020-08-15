package Libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelSheet {
	
	public static String locOfInputExcel ;
    static Hashtable dict= new Hashtable();
    static Hashtable flaggedMethod=new Hashtable();

    public int totalrows(String testDataFileName, String sheetname) throws IOException {
       // locOfInputExcel = ReportLibrary.getPath()+"\\TestData\\"+testDataFileName+".xlsx";
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\TestData\\\\NDTV.xlsx");
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheet(sheetname);

       /* FileOutputStream fos=new FileOutputStream(locOfInputExcel);
        w.write(fos);
        fis.close();*/

        return s.getLastRowNum();
    }

    public int getRowNumber(String testDataFileName, String sheetname,String TestCaseName) throws IOException {
       // locOfInputExcel = ReportLibrary.getPath()+"\\TestData\\"+testDataFileName+".xlsx";
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\TestData\\\\NDTV.xlsx");
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheet(sheetname);

       for(int i=0;i<=s.getLastRowNum();i++)
       {
           Row r=s.getRow(i);
           Cell c=r.getCell(0);
           String name=c.getStringCellValue();
           if(name.equalsIgnoreCase(TestCaseName))
           {
               return i;
              // break;
           }
       }

        return 0;
    }

    
    public static XSSFRow getRow(String sheetname, int rownum, String  testDataFileName) throws IOException {
    	//locOfInputExcel = ReportLibrary.getPath()+"\\TestData\\"+testDataFileName+".xlsx";
        FileInputStream fis = new FileInputStream(locOfInputExcel);
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheet(sheetname);
        XSSFRow r = s.getRow(rownum);
       // w.close(fis);
        fis.close();
        return r;
    }

}
