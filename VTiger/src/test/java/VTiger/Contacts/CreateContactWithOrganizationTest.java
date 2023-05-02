package VTiger.Contacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import VTiger.GenericUtilities.BaseClass;
import VTiger.GenericUtilities.ExcelFileUtility;
import VTiger.GenericUtilities.JavaUtility;
import VTiger.GenericUtilities.PropertyFileUtility;
import VTiger.GenericUtilities.WebDriverUtility;
import VTiger.ObjectRepository.ContactInfoPage;
import VTiger.ObjectRepository.ContactsPage;
import VTiger.ObjectRepository.CreateNewContactPage;
import VTiger.ObjectRepository.CreateNewOrganizationPage;
import VTiger.ObjectRepository.HomePage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.OrganizationInfoPage;
import VTiger.ObjectRepository.OrganizationPage;

public class CreateContactWithOrganizationTest extends BaseClass {

	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	@Test
	
	public void createContactWithOrgTest() throws IOException {
		
		
		String OrgName = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();		
		String LastName = eUtil.readDataFromExcel("Contact", 4, 2);
		
						
				//Step 3: Navigate to Organizations LInk
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgTab();
				
				//Step 4: click on Create Organization Look Up Image
				OrganizationPage op=new OrganizationPage(driver);
				op.clickOncreateNewOrgImg();
				
				//Step 5: Create Organization with Mandatory fields
				CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
				cnp.createNewOrg(OrgName);
												
				//Step 6: Validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader=oip.OrgHeaderTxt();
				 
				System.out.println("Organization Name is:"+OrgHeader);
				Assert.assertTrue(OrgHeader.contains(OrgName));
								
				//Step 7 click on contacts tab
				hp.clickOnContactTab();
				
				//Step 8 click on create new contact img
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateNewContact();
				
				//Step 9 create contact with mandatory fields and Organization name
			
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(LastName, OrgName, driver);
							
				ContactInfoPage cip =new ContactInfoPage(driver);
				
				String ContactInfo = cip.contactHeader();
				String ActOrgName = cip.contactInfoOrgName();
				
				System.out.println("LastName: "+ContactInfo+" Organization: "+ActOrgName);
				Assert.assertTrue(ContactInfo.contains(LastName)& ActOrgName.contains(OrgName));
													
			}

				
	}

