package demoapp.SampleProject;

import java.net.MalformedURLException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SortingPrice extends DriverFactory {
	// DriverFactory driverFactory;
	// public AndroidDriver driver;
	SortingPricePage sortingPricePage;

	@BeforeClass
	public void configure() throws MalformedURLException {
		super.setUp();
		sortingPricePage = new SortingPricePage(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Test
	public void testPriceLowtoHigh() {
		sortingPricePage.setUserName("standard_user");
		sortingPricePage.setPassword("secret_sauce");
		sortingPricePage.clickLoginButton();
		sortingPricePage.clickFilterButton();
	}

}
