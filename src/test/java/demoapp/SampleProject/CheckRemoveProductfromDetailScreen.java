package demoapp.SampleProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckRemoveProductfromDetailScreen extends DriverFactory {
	CheckRemoveProductfromDetailScreenPage checkRemoveProductfromDetailScreenPage;
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
		checkRemoveProductfromDetailScreenPage = new CheckRemoveProductfromDetailScreenPage(driver);

	}

	@Test
	public void checkRemoveProductfromDetailScreen() {
		// login to mobile app
		login();

		// change Grid view to list view
		checkRemoveProductfromDetailScreenPage.clickChangeViewIcon();
		// click first item
		checkRemoveProductfromDetailScreenPage.clickFirstItem();

		// Check Product Name correctly display or not
		String productName = checkRemoveProductfromDetailScreenPage.getProductNameBeforeDetailScreen();
		checkRemoveProductfromDetailScreenPage.clickProductDetailButton();
		String productNamefromDetailScreen = checkRemoveProductfromDetailScreenPage.getProductNamefromDetailScreen();
		Assert.assertEquals(productName, productNamefromDetailScreen);

		// Check REMOVE Button display or not
		boolean isVisible = checkRemoveProductfromDetailScreenPage.isDisplayRemoveButton();
		Assert.assertTrue(isVisible, "Remove button should be visible");
	}

	public void login() {
		loginPage.setUserName(strings.getProperty("userName"));
		loginPage.setPassword(strings.getProperty("password"));
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
