package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryNameDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(name="button")
	private WebElement saveBtn;

	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryNameDD() {
		return industryNameDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create a new org with mandatory fields and save
	 * @param ORGNAME
	 */
	public void createNewOrg(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new Org with Industry and save
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrg(String ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryNameDD,INDUSTRY);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization with Industry and Type
	 * @param OrgName
	 * @param Industry
	 * @param TYPE
	 */
	public void createNewOrg(String ORGNAME,String INDUSTRY, String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryNameDD,INDUSTRY);
		handleDropDown(typeDD, TYPE);
		saveBtn.click();
	}
	
}
