package ddt_extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

//		when we fetch the data => getCell()
//		Cell cell = wb.getSheet("contact").getRow(1).getCell(0);

//		when we write the data => createCell()
		Cell cell = wb.getSheet("contact").getRow(2).createCell(0);

//		set the data
		cell.setCellValue("Sharma");

//		save the data 
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testScriptData.xlsx");
		wb.write(fos); // => save

//		don't forget to close the wb
		wb.close();
	}
}
