package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtils {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;

	public static String read(int i, int j, String sheetName) throws IOException {
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\logindetails.xlsx");
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		Row r = ws.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();

	}
	public static String readIntegerData(int i,int j,String sheetname) throws
	IOException{
		
			fis = new FileInputStream(
			System.getProperty("user.dir") +"\\src\\main\\resources\\ExcelFiles\\logindetails.xlsx");
			wb=new XSSFWorkbook(fis);
			ws=wb.getSheet(sheetname);
			Row r=ws.getRow(i);
			Cell c=r.getCell(j);
			int a=(int) c.getNumericCellValue();
			return String.valueOf(a);
			
	}
}




	



