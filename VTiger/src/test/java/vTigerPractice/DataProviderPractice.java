package vTigerPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider = "getData")
public class DataProviderPractice {

	public void sampleTest(String BrandName, int Price, int Size)
	{
		System.out.println(BrandName+"____"+Price+"____"+Size);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[5][3];
	
		data[0][0]="Nike";
		data[0][1]=1000;
		data[0][2]=4;
		
		
		data[1][0]="adidas";
		data[1][1]=2000;
		data[1][2]=6;
		
		data[2][0]="Tommy";
		data[2][1]=3000;
		data[2][2]=8;
		
		data[3][0]="UnderArmer";
		data[3][1]=4000;
		data[3][2]=4;
		
		data[4][0]="NOrthFace";
		data[4][1]=5000;
		data[4][2]=4;
		return data;
				
	}
}
