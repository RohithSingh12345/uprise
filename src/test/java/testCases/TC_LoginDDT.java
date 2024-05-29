package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LoginDDT extends BaseClass
{

	@Test(dataProvider = "LoginData", dataProviderClass= DataProviders.class)
	public void Verify_Login(String email, String password, String res) {
		
	try {
		LoginPage lp= new LoginPage(driver);
		
		lp.EnterDataInEmail(email);
		lp.EnterDataInPassword(password);
		lp.ClickOnSignInButton();
		
		boolean targetPage = lp.Homepage();
		Assert.assertEquals(targetPage, true);
		LandingPage landing = new LandingPage(driver);
		
		
		
		if(res.equalsIgnoreCase("Pass"))
		{
			if(targetPage== true) {
				landing.clickOnYouButton();
				landing.clickOnLogoutButton();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("fail")) {
			if(targetPage==true) {
				landing.clickOnYouButton();
				landing.clickOnLogoutButton();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
		}

	}
	catch (Exception e)
	{
		logger.info("fail");
	}
	
}
}

