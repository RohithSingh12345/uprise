package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_Login extends BaseClass {

	

	@Test(groups= {"regression","master"})
	public void Verify_Login() {
		
	try {	
		LoginPage lp= new LoginPage(driver);
		logger.info("*** Logging in ************");
		lp.EnterDataInEmail(propfile.getProperty("Email"));
		lp.EnterDataInPassword(propfile.getProperty("Password"));
		lp.ClickOnSignInButton();
		Assert.assertEquals(lp.Homepage(), true);
		logger.info("homepage");
	}
	catch(Exception e) {
		logger.error("test failed");
		Assert.fail();
	}
		
		
	}
	
	
	

	
}
