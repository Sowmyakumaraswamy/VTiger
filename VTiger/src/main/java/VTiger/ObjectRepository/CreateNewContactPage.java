package VTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//img[@title ='Select']")
	private WebElement addOrgBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement SelectOrgBtn;
	
	@FindBy(id="search_txt")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getSelectOrgBtn() {
		return SelectOrgBtn;
	}
	
	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	//Business Library
	/** 
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new contact with Organization name
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver)
	{
		lastNameEdt.sendKeys(LASTNAME);
		addOrgBtn.click();
		switchToWindow(driver,"Accounts");
		SearchEdt.sendKeys(ORGNAME);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	

}
