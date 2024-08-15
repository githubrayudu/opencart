package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrartionPage;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test()
	public void verify_account_registration() {
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");
			AccountRegistrartionPage regpage = new AccountRegistrartionPage(driver);
			logger.info("Providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message..");

			String confmsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
			logger.info("Test passed");
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			logger.debug("Debug logs...");
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

			}
	


}
