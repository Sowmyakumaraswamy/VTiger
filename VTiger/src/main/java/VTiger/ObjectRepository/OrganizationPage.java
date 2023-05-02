package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Rule 1 : create a separate class for every webppage
	
	//Rule 2: Identify the elements using annotations
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgImg;
	
			
	// Rule 3: Create a consturctor to initialise these elements
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4: Provide getters to access these variables

	public WebElement getCreateNewOrgImg() {
		return createNewOrgImg;
	}
	
	
	//Business Library
	
	
	/**
	 * This method will click on Organization tab
	 */
	public void clickOncreateNewOrgImg()
	{
		createNewOrgImg.click();
	}

	
	
}
