package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Rule 1 : create a separate class for every webppage
	
		//Rule 2: Identify the elements using annotations
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsTab;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsTab;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	// Rule 3: Create a consturctor to initialise these elements
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getters to access these variables

	public WebElement getContactsTab() {
		return contactsTab;
	}

	public WebElement getOrganizationsTab() {
		return organizationsTab;
	}

	public WebElement getSignOutImg() {
		return signOutImg;
	}

	public WebElement getSignOutLink() {
		return signoutLink;
	}
	
	//Business Library
	/**
	 * This method will click on organization link
	 * 
	 */
	public void clickOnOrgTab()
	{
		organizationsTab.click();
	}
	
	/**
	 * This method will click on contacts Tab
	 */
	public void clickOnContactTab()
	{
		contactsTab.click();
	}
	
	
	/**
	 * This method will perform signout operation
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver,signOutImg);
		signoutLink.click();
	}
	
		
	}
