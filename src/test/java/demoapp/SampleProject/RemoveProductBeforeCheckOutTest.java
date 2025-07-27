package demoapp.SampleProject;
import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductBeforeCheckOutTest extends DriverFactory{
	RemoveProductBeforeCheckOutPage removeProductBeforeCheckOutPage;
	LoginPage loginPage;
	
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
		//System.out.println(" getItemCount"+removeProductBeforeCheckOutPage.getItemCount());
		removeProductBeforeCheckOutPage.clickRemoveButton();
//		removeProductBeforeCheckOutPage.clickCheckOutButton();
//		removeProductBeforeCheckOutPage.setUserInformation("Myoe Thandar", "Kyaw", "+95");
//		removeProductBeforeCheckOutPage.clickContinueButton();
//		removeProductBeforeCheckOutPage.clickFinishButton();
//		removeProductBeforeCheckOutPage.clickBackHomeButton();
//Need to fix doesn't click remove button

	}
	public void login() {
		loginPage.setUserName("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLoginButton();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}
}
