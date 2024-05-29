package testCases;

import org.testng.annotations.Test;

import pageObjects.SignUpPage;
import testBase.BaseClass;

public class TC_SignUp extends BaseClass {

	
	
	
	
	@Test(groups = {"sanity","regression"})
	public void SignUp() {
		
		logger.info("*** Signing up ************");
		SignUpPage signup = new SignUpPage(driver);
		signup.SignUpLink();
		signup.NameInput(randomString().toUpperCase());
		logger.info("****entered phn number****");
		signup.EnterDataInPassword(alphaNumeric());
		signup.EnterDataInEmail(randomString()+"@yopmail.com");
		signup.CountryCodeIcon();
		signup.CountryCodeText();
		signup.phoneNumber(randomNumeric());
		signup.AccessCode("testingau1234");
		signup.SignUpButton();
		
	}
	
	
	
}

