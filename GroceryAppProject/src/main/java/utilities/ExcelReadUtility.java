package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUtility {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;

	public static String read(String sheetname,int i, int j) throws IOException {
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\ExcelFiles\\LoginDetails.xlsx");
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetname);
		Row r = ws.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();

	}

}