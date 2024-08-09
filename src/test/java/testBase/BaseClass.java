package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	void setup() {
		ChromeOptions op =new ChromeOptions();
		op.addArguments("--headless=new");
		driver = new ChromeDriver(op);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomNumber() {
		String generatedNum = RandomStringUtils.randomNumeric(6);
		return generatedNum;
	}

	public String randomAlphaNumber() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatedNum = RandomStringUtils.randomNumeric(6);
		return (generatedstring + "@" + generatedNum);
	}
}
