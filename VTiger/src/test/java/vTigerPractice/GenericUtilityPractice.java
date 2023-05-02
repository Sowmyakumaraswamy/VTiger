package vTigerPractice;

import java.io.IOException;

import VTiger.GenericUtilities.ExcelFileUtility;
import VTiger.GenericUtilities.JavaUtility;
import VTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[] args) throws IOException {
		JavaUtility Jutil = new JavaUtility();
		
		 int Value = Jutil.getRandomNumber();
		 System.out.println(Value);
		 
		 System.out.println(Jutil.getSystemDate());
		 
		 System.out.println(Jutil.getSystemDateInFormat());
		 
		 PropertyFileUtility pUtil = new PropertyFileUtility();
		System.out.println(pUtil.readDatafromPropertyFile("browser"));
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		System.out.println(eUtil.readDataFromExcel("Organization", 1, 2));
		
		eUtil.WriteDatatoExcel("new", 1, 2, "sowmya");
		
		
	}

}
