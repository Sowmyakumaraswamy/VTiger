package vTigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReTryAnalyserPractice {
	@Test(retryAnalyzer = VTiger.GenericUtilities.ReTryAnalyserImplementationClass.class)
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
