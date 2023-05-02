package VTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This CLass consists of generic methods related to Excel file
 * @author sowmy
 *
 */
public class ExcelFileUtility  {
	/**
	 * This method will read data from Excel file
	 * @param SheetName
	 * @param Row
	 * @param Cell
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String SheetName,int Row,int Cell) throws IOException
	{
	
	FileInputStream fs = new FileInputStream(ConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fs);
	String Value = wb.getSheet(SheetName).getRow(Row).getCell(Cell).getStringCellValue();
	return Value;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param CellNo
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void WriteDatatoExcel(String SheetName, int RowNo, int CellNo, String Value) throws EncryptedDocumentException, IOException {
		
		FileInputStream fs = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fs);
	
		wb.createSheet(SheetName).createRow(RowNo).createCell(CellNo).setCellValue(Value);
		
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
				
	}
	
	/**
	 * This method will capture all the daata inside a sheet for dataProvider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
	
		Object[][] data = new Object[lastRow][lastCel];
	
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
	
		return data;
	}
}

