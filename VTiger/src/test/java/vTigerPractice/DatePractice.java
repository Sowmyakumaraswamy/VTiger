package vTigerPractice;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.annotations.Test;

public class DatePractice {
	@Test
	public void DatePractice() {
		Date d= new Date();
		System.out.println("System date: "+d);
		String[] dArr = d.toString().split(" ");
		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":","-");
		
		String date = day+"-"+month+"-"+year+" "+time;
		System.out.println("Formatted date : "+ date);
	}

}
