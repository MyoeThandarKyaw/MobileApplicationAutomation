package demoapp.SampleProject;

import java.net.MalformedURLException;

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
		login();
		checkRemoveProductfromDetailScreenPage.clickChangeViewIcon();
		for (int i = 0; i < 3; i++) {
			checkRemoveProductfromDetailScreenPage.clickFirstItem();
		}
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
