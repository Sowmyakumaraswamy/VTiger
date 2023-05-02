package VTiger.Contacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import VTiger.GenericUtilities.BaseClass;
import VTiger.GenericUtilities.ExcelFileUtility;
import VTiger.GenericUtilities.JavaUtility;
import VTiger.GenericUtilities.PropertyFileUtility;
import VTiger.GenericUtilities.WebDriverUtility;
import VTiger.ObjectRepository.ContactInfoPage;
import VTiger.ObjectRepository.ContactsPage;
import VTiger.ObjectRepository.CreateNewContactPage;
import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;

@Listeners(VTiger.GenericUtilities.ListnersImplementationClass.class)
public class CreateContactTest extends BaseClass {
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	
	@Test

	public void createNewContactTest() throws IOException{
		
		
			
		String LastName = eUtil.readDataFromExcel("Contact", 1, 2);
							
				
		HomePage hp = new HomePage(driver);
		hp.clickOnContactTab();
			
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContact();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LastName);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		String ContactInfo = cip.contactHeader();
		System.out.println(ContactInfo);
		//Assert.fail();
		Assert.assertTrue(ContactInfo.contains(LastName));
						
	}

}
