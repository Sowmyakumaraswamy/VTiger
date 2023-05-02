package vTigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import VTiger.ObjectRepository.CreateNewOrganizationPage;
import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.OrganizationInfoPage;
import VTiger.ObjectRepository.OrganizationPage;

public class DemoScript {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
					
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		
		
		String OrgName = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();		
		
		//Step 1: launch the browser
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
				wUtil.waitForPageLoad(driver);
				driver.get(URL);
				
				//Step 2: Login to App
				LoginPage lp = new LoginPage(driver);
				lp.logInToApp(USERNAME, PASSWORD);
				
				//Step 3: Navigate to Organizations LInk
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgTab();
				
				
				//Step 4: click on Create Organization Look Up Image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOncreateNewOrgImg();
				
							
				//Step 5: Create Organization with Mandatory fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(OrgName);
				
								
				//Step 6: Validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.OrgHeaderTxt();
				
				System.out.println("Organization Name is:"+OrgHeader);
				if(OrgHeader.contains(OrgName))
				{
					System.out.println("=== PASS ===");
				}
				else
				{
					System.out.println("=== FAIL ===");
				}
				
				hp.logOutOfApp(driver);
				
				System.out.println("Signout Succeful");
				
				driver.close();
	}

}
