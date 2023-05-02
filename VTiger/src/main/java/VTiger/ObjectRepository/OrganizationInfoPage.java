package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgNameInfo;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement IndustryInfo;
	
	@FindBy(id="mouseArea_Type")
	private WebElement TypeInfo;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderInfo;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgNameInfo() {
		return OrgNameInfo;
	}

	public WebElement getIndustryInfo() {
		return IndustryInfo;
	}

	public WebElement getTypeInfo() {
		return TypeInfo;
	}

	public WebElement getOrgHeaderInfo() {
		return OrgHeaderInfo;
	}


	
	//Business Library
	
	/**
	 * This method will return Organization Info page header text
	 * @return
	 */
	public String OrgHeaderTxt()
	{
		return OrgHeaderInfo.getText();
	}
	
	/**
	 * This method will return organization Name value
	 * @return
	 */
	
	public String orgNameInfo()
	{
		return OrgNameInfo.getText();
	}
	
	/**
	 * This method will return Industry name in orgInfo page
	 * @return
	 */
	public String industryInfo()
	{
		return IndustryInfo.getText();
	}
	
	/**
	 * This method will return Type Info in Org info page
	 * @return
	 */
	public String typeInfo()
	{
		return TypeInfo.getText();
	}
	
	

}
