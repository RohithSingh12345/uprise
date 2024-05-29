package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SignUpPage extends BasePage{
    public WebDriver driver;
    
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailInputField;
	
	@FindBy(xpath= "//input[@id='password']")
    private	WebElement PasswordInputField;
	
	 @FindBy(xpath="//span[text()='Sign up']")
     private WebElement SignUpButton;
     
     @FindBy(xpath = "//a[text()='Sign up']")
     private WebElement SignUpLink;
     
     @FindBy(xpath="//input[@id='name']")
     private WebElement NameInputField;
     
     @FindBy(xpath="//button[@id='downshift-0-toggle-button']")
     private WebElement CountryCodeIcon;
     
     @FindBy(xpath="//p[text()='India']")
     private WebElement CountryCodeText;
     
     @FindBy(xpath="//input[@id='phone']")
     private WebElement Phone;
     
     @FindBy(xpath = "//*[text()='+91']")
     private WebElement CountryCode;
     
    
     @FindBy(xpath= "//input[@id='accessCode']")
     private WebElement AccessCode;
     
     @FindBy(xpath= "//div[@type='error']")
     private WebElement AlreadyRegisteredEmailErrorMessage;
     //password and email from loginpage
     
     //actions
     
     public SignUpPage SignUpLink() {
    	 SignUpLink.click();
    	 return new SignUpPage(driver);
     }
     public String GetErrorMessageText() {
    	 String ErrorMessage = AlreadyRegisteredEmailErrorMessage.getText();
    	 return ErrorMessage;
     }
     
     public String GetCountryCode() {
    	String countrycode=  CountryCode.getText();
    	return countrycode;
     }
     
     public void NameInput(String name) {
    	 NameInputField.sendKeys(name);
     }
     public void SignUpButton() {
    	 SignUpButton.click();
     }
     public void EnterDataInEmail(String email){
 		EmailInputField.sendKeys(email);
 		
 	}
 	public void EnterDataInPassword(String password) {
 		PasswordInputField.sendKeys(password);
 	}
 	
     public void CountryCodeIcon() {
    	 CountryCodeIcon.click();
     }
     public void CountryCodeText() {
    	 CountryCodeText.click();
     }
     public void phoneNumber(String phone) {
    	 Phone.sendKeys(phone);
     }
     public void AccessCode(String accesscode) {
    	 AccessCode.sendKeys(accesscode);
     }
     
     
}
