package VTiger.Organizations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class CreateNewOrganizationWithIndustryAndType extends BaseClass{
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	@Test
	public void createNewOrgWithIndustryAndType() throws IOException {
				
		String OrgName = eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber() ;
		String IndustryName = eUtil.readDataFromExcel("Organization",7,3);	
		String Type = eUtil.readDataFromExcel("Organization", 7, 4);
		
						
				//Step 3: Navigate to Organizations LInk
				HomePage hp = new HomePage(driver);
				hp.clickOnOrgTab();
				
				//Step 4: click on Create Organization Look Up Image
				OrganizationPage op = new OrganizationPage(driver);
				op.clickOncreateNewOrgImg();
				
				//Step 5: Create Organization with Mandatory fields
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(OrgName, IndustryName, Type);
				
								
				//Step 6: Validate
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String Organization =oip.OrgHeaderTxt();
				String IndustryType = oip.industryInfo();
				 				
				System.out.println("Organization:"+Organization+" Industry: "+IndustryType);
				Assert.assertTrue(Organization.contains(Organization) & IndustryType.contains(IndustryName));
			}

}
