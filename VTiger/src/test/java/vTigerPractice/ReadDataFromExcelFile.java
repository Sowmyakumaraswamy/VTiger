package vTigerPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step1: Open the document in Java Readable format using FileInputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook using workbook factory
 Workbook wb = WorkbookFactory.create(fis);
 
 //Step3: Get the control of sheet
 Sheet sh = wb.getSheet("Organization");
 
 //Step4: Get the control of row
 Row rw = sh.getRow(1);
 
 //Step5: get the control of cell
 Cell ce = rw.getCell(2);
 
 //Step6: Read the data inside the cell
 String value = ce.getStringCellValue();
 
 System.out.println(value);
 
 wb.close();
	}

}
