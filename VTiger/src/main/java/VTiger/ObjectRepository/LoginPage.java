package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule 1 : create a separate class for every webppage
	
	//Rule 2: Identify the elements using annotations
	
	@FindBy (name = "user_name")
	private WebElement userNameEdt;
	
	@FindAll({@FindBy (name = "user_password"), @FindBy(xpath = "//input[@type=\"password\"]")})
	private WebElement passwordEdt;
	
	@FindBy (id="submitButton")
	private WebElement submitBtn;
	
	// Rule 3: Create a consturctor to initialise these elements
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4: Provide getters to access these variables

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	public void logInToApp(String USERNAME, String PASSWORD)
	{
	userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}

}
