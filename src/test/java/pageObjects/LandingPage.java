package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[@data-testid='You-button']")
	private WebElement YouButton;
	
	//span[text()='Logout']
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement LogoutButton;
	
	
	
	public void clickOnYouButton() {
		YouButton.click();
	}
	
	public void clickOnLogoutButton() {
		LogoutButton.click();
	}

}
