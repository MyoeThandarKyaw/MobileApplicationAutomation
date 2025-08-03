package demoapp.SampleProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CheckErrorMessageinCheckOutScreen extends DriverFactory {
	LoginPage loginPage;
	CheckErrorMessageinCheckOutScreenPage checkErrorMessageifUserNameBlankPage;
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
		checkErrorMessageifUserNameBlankPage = new CheckErrorMessageinCheckOutScreenPage(driver);

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
		String actualErrorMessage = checkErrorMessageifUserNameBlankPage.getErrorMessageforFirstNameBlank();
		String expectedErrorMessage = strings.getProperty("first_name_error_message");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test
	public void checkErrorMessageDisplayForLastNameBlank() {
		checkErrorMessageifUserNameBlankPage.setUserInformation("Myoe", "", "+95");
		checkErrorMessageifUserNameBlankPage.clickContinueButton();
		String actualErrorMessage = checkErrorMessageifUserNameBlankPage.getErrorMessageforLastNameBlank();
		String expectedErrorMessage = strings.getProperty("last_name_error_message");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@Test
	public void checkErrorMessageDisplayForZipCodeBlank() {
		checkErrorMessageifUserNameBlankPage.setUserInformation("Myoe", "Thandar Kyaw", "");
		checkErrorMessageifUserNameBlankPage.clickContinueButton();
		String actualErrorMessage = checkErrorMessageifUserNameBlankPage.getErrorMessageforZipCodeBlank();
		String expectedErrorMessage = strings.getProperty("zip_code_error_message");
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
