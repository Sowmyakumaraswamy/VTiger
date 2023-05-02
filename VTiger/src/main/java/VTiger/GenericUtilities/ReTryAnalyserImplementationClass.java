package VTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * This class is ana implementation class for IRETRYANALYSER interface of TestNG
 */
public class ReTryAnalyserImplementationClass implements IRetryAnalyzer {
	int count = 0;
	int retryCount =3;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while (count<retryCount) {
			count++;
			return true;
			
		}
		
		return false;
	}
	
}
