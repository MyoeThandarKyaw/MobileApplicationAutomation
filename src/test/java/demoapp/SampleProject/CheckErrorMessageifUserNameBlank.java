package demoapp.SampleProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CheckErrorMessageifUserNameBlank extends DriverFactory {
	LoginPage loginPage;
	CheckErrorMessageifUserNameBlankPage checkErrorMessageifUserNameBlankPage;
	private Properties strings;

	@BeforeClass
	public void setup() {
		strings = new Properties();
		try {
			strings.load(getClass().getResourceAsStream("/test-strings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void configure() throws MalformedURLException {
		loginPage = new LoginPage(driver);
		checkErrorMessageifUserNameBlankPage = new CheckErrorMessageifUserNameBlankPage(driver);
	}

	@Test
	public void checkErrorMessageDisplay() {
		login();
		checkErrorMessageifUserNameBlankPage.clickChangeViewIcon();
		for (int i = 0; i < 3; i++) {
			checkErrorMessageifUserNameBlankPage.clickFirstItem();
		}
		checkErrorMessageifUserNameBlankPage.clickCheckOuticon();
		checkErrorMessageifUserNameBlankPage.clickCheckOutButton();
		checkErrorMessageifUserNameBlankPage.setUserInformation("", "Kyaw", "+95");
		checkErrorMessageifUserNameBlankPage.clickContinueButton();
		String actualErrorMessage = checkErrorMessageifUserNameBlankPage.getErrorMessage();
		String expectedErrorMessage = strings.getProperty("first_name_error_message");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	public void login() {
		loginPage.setUserName("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
