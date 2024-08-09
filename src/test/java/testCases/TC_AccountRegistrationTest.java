package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrartionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_AccountRegistrationTest extends BaseClass {

	@Test(invocationCount =10)
	void verify_account_registration() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegistration();
		AccountRegistrartionPage regpage = new AccountRegistrartionPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName((randomString().toUpperCase()));
		regpage.setEmail((randomString() + "@gmail.com"));
		regpage.SetTelephoneNo(randomNumber());

		String password = randomAlphaNumber();

		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		regpage.clickContinueAfterGettingMessage();
	}

	
}
