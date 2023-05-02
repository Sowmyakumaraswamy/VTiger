package vTigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
@Test
public void assertPractice()
{
	SoftAssert sa = new SoftAssert();
	System.out.println("step1");
	
	System.out.println("step2");
	sa.assertEquals(true, true);
	System.out.println("step3");
	sa.assertTrue(false);
	System.out.println("step4");
	
	sa.assertAll();
	Assert.assertEquals(false, true);
}

@Test
public void practice()
{
	System.out.println("second script step1");
	Assert.assertEquals(true, true);
	System.out.println("second script step2");
	
}

}
