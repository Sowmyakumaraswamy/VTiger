package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(id="mouseArea_Last Name")
	private WebElement LastNameInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgNameInfo;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactInfoHeader;
	
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getLastNameInfo() {
		return LastNameInfo;
	}


	public WebElement getOrgNameInfo() {
		return OrgNameInfo;
	}
	
	public WebElement getContactInfoHeader() {
		return ContactInfoHeader;
	}
	
	//Business Library
	
	/**
	 * This method will return contact Header value
	 * @return
	 */
	
	public String contactHeader()
	{
		return ContactInfoHeader.getText();
	}
	
	/**
	 * This method will return Lastname value in contact info page
	 * @return
	 */
	public String contactInfoLastName() {
		return LastNameInfo.getText();
	}
	
	/**
	 * This method will return Organization value in contact Info page
	 * @return
	 */
	public String contactInfoOrgName()
	{
		return OrgNameInfo.getText();
		
	}
	
	
	

}
