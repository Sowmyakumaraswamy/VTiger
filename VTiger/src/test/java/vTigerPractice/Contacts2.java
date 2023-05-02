package vTigerPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts2 {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		String partialWinTitleOrg = pUtil.readDatafromPropertyFile("windowTitleOrganization");
		String partialWinTitleCon = pUtil.readDatafromPropertyFile("windowTitleContacts");
		
		
		String Organization = eUtil.readDataFromExcel("organization",1,2)+jUtil.getRandomNumber();
		String LastName = eUtil.readDataFromExcel("Contact",1,2);
		
		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		
		driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
		
		wUtil.switchToWindow(driver,partialWinTitleOrg);
		
		
				
		driver.findElement(By.id("1")).click();
		
		wUtil.switchToWindow(driver, partialWinTitleCon);
				
		driver.findElement(By.name("button")).click();
		
		String ContactInfo = driver.findElement(By.id("mouseArea_Last Name")).getText();
		String OrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		System.out.println("LastName: "+ContactInfo+" Organization: "+OrgName);
		
		if (ContactInfo.contains(LastName)) 
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Signout Successful");
		
		driver.close();
		
	}


	}


