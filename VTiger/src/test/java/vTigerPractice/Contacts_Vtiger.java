package vTigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import VTiger.GenericUtilities.ExcelFileUtility;
import VTiger.GenericUtilities.JavaUtility;
import VTiger.GenericUtilities.PropertyFileUtility;
import VTiger.GenericUtilities.WebDriverUtility;
import VTiger.ObjectRepository.ContactInfoPage;
import VTiger.ObjectRepository.ContactsPage;
import VTiger.ObjectRepository.CreateNewContactPage;
import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;

public class Contacts_Vtiger {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		
		String LastName = eUtil.readDataFromExcel("Contact", 1, 2);
		
		
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();
		}
			
		wUtil.windowMaximize(driver);
		driver.get(URL);
		
		wUtil.waitForPageLoad(driver);
			
				
		LoginPage lp = new LoginPage(driver);
		lp.logInToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContactTab();
			
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContact();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LastName);
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		
		String ContactInfo = cip.contactHeader();
		System.out.println(ContactInfo);
		if (ContactInfo.contains(LastName)) {
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		
		hp.logOutOfApp(driver);
		
		System.out.println("Signout Succesful");
		driver.close();
		
	}

}

