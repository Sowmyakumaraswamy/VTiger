package vTigerPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws IOException {
		//Step1: Open the document in Java Readable format using FileInputStream
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
				//Step 2: Create a workbook using workbook factory
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 //Step3: Get the control of sheet
		 Sheet sh = wb.getSheet("Contact");
		 
		 //Step4: Create a row
		 Row rw = sh.createRow(10);
		 
		 //Step5: Create cell
		 Cell ce = rw.createCell(8);
		 
		 //Step6: Set the value into the cell
		 ce.setCellValue("Chelsea");
		 
		 //Step7: open the file in writable format
		 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 
		 //Step 8: Write the data into workbook
		 
		 wb.write(fos);
		 
		 //Step 9 : close the workbook
		
		 wb.close();
		 
		 System.out.println("Data added and workbook closed");
			
	}



	
}

