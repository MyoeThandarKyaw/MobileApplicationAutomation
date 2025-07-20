package demoapp.SampleProject;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Buy3ProductsTest extends DriverFactory {
	Buy3ProductsTestPage buy3ProductsTestPage;
	LoginPage loginPage;

	@BeforeMethod
	public void configure() throws MalformedURLException {
		loginPage = new LoginPage(driver);
		buy3ProductsTestPage = new Buy3ProductsTestPage(driver);

	}

	@Test
	public void testBuy3Products() {
		login();
		buy3ProductsTestPage.clickChangeViewIcon();
		for (int i = 0; i < 3; i++) {
			buy3ProductsTestPage.clickFirstItem();
		}
		buy3ProductsTestPage.clickCheckOuticon();
		buy3ProductsTestPage.clickCheckOutButton();
		buy3ProductsTestPage.setUserInformation("Myoe Thandar", "Kyaw", "+95");
		buy3ProductsTestPage.clickContinueButton();
		buy3ProductsTestPage.clickFinishButton();
		buy3ProductsTestPage.clickBackHomeButton();

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
