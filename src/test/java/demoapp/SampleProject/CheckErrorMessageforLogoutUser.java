package demoapp.SampleProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckErrorMessageforLogoutUser extends DriverFactory {
	CheckErrorMessageforLogoutUserPage checkErrorMessageforLogoutUserPage;
	LoginPage loginPage;
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
		checkErrorMessageforLogoutUserPage = new CheckErrorMessageforLogoutUserPage(driver);

	}

	@Test
	public void checkErrorMessageforLogoutUser() {
		// login to mobile app
		login();
		String errorMessageforLogedOutUser = checkErrorMessageforLogoutUserPage.getErrorMessageForLoggedOutUser();
		System.out.println("ErrorMessage" + errorMessageforLogedOutUser);
		Assert.assertEquals(errorMessageforLogedOutUser, strings.getProperty("lockedOutUserErrorMessage"));

	}

	public void login() {
		loginPage.setUserName(strings.getProperty("lockedOutUserName"));
		loginPage.setPassword(strings.getProperty("lockedOutPassword"));
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
