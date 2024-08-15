package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_login() {
		logger.info("*****Startin TC002_LoginTest****");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			logger.info("Clicked on MyAccount Link.. ");
			hp.clickMyAccount();
			logger.info("Clicked on Login Link.. ");
			hp.clickLogin();
			// Login
			LoginPage lp = new LoginPage(driver);
			logger.info("Entered USER id ");
			lp.setLoginName(p.getProperty("email"));
			logger.info("Entered password  ");
			lp.setLoginPassword("testpassword1");
			lp.clickLogin();

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			// Assert.assertTrue(targetPage);
			Assert.assertEquals(targetPage, true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*****Finished TC002_LoginTest****");

	}

}
