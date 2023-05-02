package VTiger.Organizations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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
import VTiger.ObjectRepository.CreateNewOrganizationPage;
import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.OrganizationInfoPage;
import VTiger.ObjectRepository.OrganizationPage;
@Listeners(VTiger.GenericUtilities.ListnersImplementationClass.class)
public class CreateNewOrganizationTest extends BaseClass {

	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	
	public void createNewOrgTest() throws IOException {
				
		String OrgName = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();		
		
		//Step 1: launch the browser
						
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
				Assert.assertTrue(OrgHeader.contains(OrgName));
								
				
	}


	}

