package demoapp.SampleProject;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckRemoveProductfromDetailScreen extends DriverFactory {
	CheckRemoveProductfromDetailScreenPage checkRemoveProductfromDetailScreenPage;
	LoginPage loginPage;

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
