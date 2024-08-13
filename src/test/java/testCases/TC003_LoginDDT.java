package testCases;
/*
Data is valid - login success -test pass - logout 

Data is valid --login failed -test fail

Data is invalid - login success -test fail -logout 

Data is invslid -- login failed -test pass 
*/

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccoutPage;
import testBase.BaseClass;

public class TC003_LoginDDT  extends BaseClass{

	public void verify_loginDDT() {
		
		HomePage hp = new HomePage(driver);
		logger.info("Clicked on MyAccount Link.. ");
		hp.clickMyAccount();
		logger.info("Clicked on Login Link.. ");
		hp.clickLogin();
		//Login
		LoginPage lp = new LoginPage(driver);
		logger.info("Entered USER id ");
		lp.setLoginName(p.getProperty());
		logger.info("Entered password");
		lp.setLoginPassword();
		lp.clickLogin();
		//MyAccount  
		
		MyAccoutPage macc = new MyAccoutPage(driver);
		boolean targetPage = macc.isMyAccoutnPageExistes();
		// Assert.assertTrue(targetPage);
		Assert.assertEquals(targetPage, true, "Login failed");
		
	}
}
