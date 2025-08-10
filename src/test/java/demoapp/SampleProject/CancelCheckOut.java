package demoapp.SampleProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CancelCheckOut extends DriverFactory {
	CancelCheckOutPage cancelCheckOutPage;
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
		cancelCheckOutPage = new CancelCheckOutPage(driver);

	}

	@Test
	public void cancelCheckOut() {
		login();
		cancelCheckOutPage.clickChangeViewIcon();
		for (int i = 0; i < 3; i++) {
			cancelCheckOutPage.clickFirstItem();
		}
		cancelCheckOutPage.clickCheckOuticon();
		cancelCheckOutPage.clickCheckOutButton();
		cancelCheckOutPage.setUserInformation("Myoe Thandar", "Kyaw", "+95");
		cancelCheckOutPage.clickCancelButton();
		String actualPageLabel = cancelCheckOutPage.getPageLabel();
		String expectedPageLabel = strings.getProperty("page_label");
		Assert.assertEquals(actualPageLabel, expectedPageLabel);

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
