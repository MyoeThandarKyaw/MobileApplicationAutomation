package demoapp.SampleProject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductBeforeCheckOutTest extends DriverFactory {
	RemoveProductBeforeCheckOutPage removeProductBeforeCheckOutPage;
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
		removeProductBeforeCheckOutPage = new RemoveProductBeforeCheckOutPage(driver);

	}

	@Test
	public void testRemoveProductBeforeCheckOutPage() {
		login();
		removeProductBeforeCheckOutPage.clickChangeViewIcon();
		for (int i = 0; i < 2; i++) {
			removeProductBeforeCheckOutPage.clickFirstItem();
		}
		removeProductBeforeCheckOutPage.clickCheckOuticon();
		// System.out.println("
		// getItemCount"+removeProductBeforeCheckOutPage.getItemCount());
		removeProductBeforeCheckOutPage.clickRemoveButton();
//		removeProductBeforeCheckOutPage.clickCheckOutButton();
//		removeProductBeforeCheckOutPage.setUserInformation("Myoe Thandar", "Kyaw", "+95");
//		removeProductBeforeCheckOutPage.clickContinueButton();
//		removeProductBeforeCheckOutPage.clickFinishButton();
//		removeProductBeforeCheckOutPage.clickBackHomeButton();
//Need to fix doesn't click remove button

	}

	public void login() {
		loginPage.setUserName(strings.getProperty("userName"));
		loginPage.setPassword(strings.getProperty("password"));
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			// driver.quit();
		}
	}
}
