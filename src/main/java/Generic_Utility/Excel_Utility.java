package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String readExcelData(String sheetname,int row,int col) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vTigerExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(col);
		String data = c.getStringCellValue();
		return data;
		}
	
	public String excelFormat(String sheetname,int r,int c) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vTigerExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		DataFormatter d=new DataFormatter();
		String data = d.formatCellValue(book.getSheet(sheetname).getRow(r).getCell(c));
		return data;
		
	}


}
