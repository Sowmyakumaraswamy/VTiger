package vTigerPractice;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;

import VTiger.GenericUtilities.ExcelFileUtility;
import VTiger.GenericUtilities.JavaUtility;
import VTiger.GenericUtilities.PropertyFileUtility;
import VTiger.GenericUtilities.WebDriverUtility;

public class Organizations2 {

	public static void main(String[] args) throws IOException {
		        JavaUtility jUtil = new JavaUtility();
		        PropertyFileUtility pUtil = new PropertyFileUtility();
		        ExcelFileUtility eUtil = new ExcelFileUtility();
		        WebDriverUtility wUtil = new WebDriverUtility();
								
				
				String BROWSER = pUtil.readDatafromPropertyFile("browser");
				String URL = pUtil.readDatafromPropertyFile("url");
				String USERNAME = pUtil.readDatafromPropertyFile("username");
				String PASSWORD = pUtil.readDatafromPropertyFile("password");
								
				String Organization = eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
				String IndustryName = eUtil.readDataFromExcel("Organization", 7, 3);
				String Type = eUtil.readDataFromExcel("Organization", 7, 4);
				
				
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
						
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
						driver.get(URL);
						
						//Step 2: Login to App
						driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
						
						//Step 3: Navigate to Organizations LInk
						driver.findElement(By.linkText("Organizations")).click();
						
						//Step 4: click on Create Organization Look Up Image
						driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
						
						//Step 5: Create Organization with Mandatory fields
						driver.findElement(By.name("accountname")).sendKeys(Organization);
						
						WebElement industry = driver.findElement(By.name("industry"));
						wUtil.handleDropDown(industry, IndustryName);
							
						
						WebElement AcctType = driver.findElement(By.name("accounttype"));
						wUtil.handleDropDown(AcctType,Type);
												
						
						//Step 6: Save
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
						//Step 7: Validate
						String IndustryType = driver.findElement(By.id("mouseArea_Industry")).getText();
						String AccountType = driver.findElement(By.id("mouseArea_Type")).getText();
						
						System.out.println("IndustryType:"+IndustryType+ " and Account Type:"+AccountType);
						
						if(IndustryType.contains(IndustryName)& AccountType.contains(Type))
						{
							System.out.println("=== PASS ===");
						}
						else
						{
							System.out.println("=== FAIL ===");
						}
						
						WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
						Actions act = new Actions(driver);
						act.moveToElement(ele).perform();
						
						driver.findElement(By.linkText("Sign Out")).click();
						
						System.out.println("Sign out Successful");
						
						driver.close();
				
			}

	

		}
