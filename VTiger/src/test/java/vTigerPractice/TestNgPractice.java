package vTigerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test(priority =1, invocationCount=2)
	public void createUser() {
		Assert.fail();
		
		System.out.println("createUser");
	}
	
	@Test(priority=-2, dependsOnMethods= {"createUser", "deleteUser" },invocationCount=2)
	public void modifyUser() {
		
		System.out.println("modifyUser");
	}
	
	@Test(priority=-3, invocationCount=1)
	public void deleteUser() {
		
		System.out.println("deleteUser");
	}
	

}
