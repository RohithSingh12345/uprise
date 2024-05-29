package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='email']")
	 WebElement EmailInputField;
	
	@FindBy(xpath= "//input[@id='password']")
   	WebElement PasswordInputField;
	
	@FindBy(xpath="//span[text()='Sign in']")
	 WebElement SignInButton;
	
	@FindBy(xpath="//label[@for='email' and @class='sc-csuQGl eMEOUq']")
	 WebElement ErrorMessage;
	
	@FindBy(xpath= "//h2[text()='Home']")
	 WebElement HomePage;

	
	
	//actions- to perform some action
	public void EnterDataInEmail(String email){
		EmailInputField.sendKeys(email);
		
	}
	public void EnterDataInPassword(String password) {
		PasswordInputField.sendKeys(password);
	}
	public void ClickOnSignInButton() {
		SignInButton.click();
	}
	public String ErrorMessageText() {
		String error = ErrorMessage.getText();
		return error;
	}
	public void Login(String email, String password) {
		EmailInputField.sendKeys(email);
		PasswordInputField.sendKeys(password);
		SignInButton.click();
	}
	public boolean Homepage() {
		boolean home = HomePage.isDisplayed();
	return home;
	}
}
