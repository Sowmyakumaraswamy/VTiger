package VTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Rule 1 : create a separate class for every webppage
	
			//Rule 2: Identify the elements using annotations
	
	@FindBy(xpath = "//img[@title = 'Create Contact...']")
	private WebElement createContactBtn;
	

	// Rule 3: Create a consturctor to initialise these elements
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access these variables

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	public void clickOnCreateNewContact()
	{
		createContactBtn.click();
	}
}
