package VTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;

public class BaseClass {
		
		public JavaUtility jUtil = new JavaUtility();
		public ExcelFileUtility eUtil = new ExcelFileUtility();
		public WebDriverUtility wUtil = new WebDriverUtility();
		public PropertyFileUtility pUtil = new PropertyFileUtility();
		
		public WebDriver driver = null;
		public static WebDriver sDriver;
		
		@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
		public void bsConfig()
		{
			System.out.println(" --- Database Connection Successful ---");
		}
		
		//@Parameters("BROWSER")
		//@BeforeTest
		@BeforeClass (groups = {"SmokeSuite","RegressionSuite"})
		public void bcConfig(/*String BROWSER*/) throws IOException
		{
			String BROWSER = pUtil.readDatafromPropertyFile("browser");
			String URL = pUtil.readDatafromPropertyFile("url");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				
				driver = new ChromeDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				
				driver = new FirefoxDriver();
				System.out.println(BROWSER+" --- Browser launch successful ---");
			}
			else
			{
				System.out.println("invalid browser name in property file");
			}
			
			sDriver=driver;
			wUtil.windowMaximize(driver);
			wUtil.waitForPageLoad(driver);
			driver.get(URL);
		}
		
		@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
		public void bmConfig() throws IOException
		{
		    String USERNAME = pUtil.readDatafromPropertyFile("username");
		    String PASSWORD = pUtil.readDatafromPropertyFile("password");
		    
		    LoginPage lp = new LoginPage(driver);
		    lp.logInToApp(USERNAME, PASSWORD);
		    System.out.println(" --- Login is Successful ---");
		}

		@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
		public void amConfig() throws InterruptedException
		{
			HomePage hp = new HomePage(driver);
			Thread.sleep(2000);
			hp.logOutOfApp(driver);
			System.out.println(" --- Logout is Successful ---");
			
		}
		
		//@AfterTest
		@AfterClass (groups = {"SmokeSuite","RegressionSuite"})
		public void acConfig()
		{
			driver.quit();
			System.out.println(" --- browser closed Successfully ---");
		}
		
		@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
		public void asConfig()
		{
			System.out.println(" --- Database closed Successfully ---");
		}
		
			
	}


