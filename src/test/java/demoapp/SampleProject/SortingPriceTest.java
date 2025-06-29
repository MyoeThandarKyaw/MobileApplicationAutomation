package demoapp.SampleProject;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortingPriceTest extends DriverFactory {
	// DriverFactory driverFactory;
	// public AndroidDriver driver;
	SortingPricePage sortingPricePage;
	String beforeSortingPrice;
	String afterSortingPrice;
	double beforeSortingValue;
	double afterSortingValue;

	@BeforeMethod
	public void configure() throws MalformedURLException {
		// super.setUp();
		sortingPricePage = new SortingPricePage(driver);

	}

	public void login() {
		sortingPricePage.setUserName("standard_user");
		sortingPricePage.setPassword("secret_sauce");
		sortingPricePage.clickLoginButton();
	}

	@Test
	public void testPriceLowtoHigh() {
		login();
		beforeSortingPrice = sortingPricePage.getBeforeSortingPrice();
		// System.out.println("beforeSortingPrice======" + beforeSortingPrice);
		beforeSortingValue = Double.parseDouble(beforeSortingPrice.replace("$", ""));
		sortingPricePage.clickFilterButton();

		sortingPricePage.choosePriceLowtoHigh();
		afterSortingPrice = sortingPricePage.getAfterSortingPrice();
		// System.out.println("afterSortingPrice======" + afterSortingPrice);
		afterSortingValue = Double.parseDouble(afterSortingPrice.replace("$", ""));

		Assert.assertTrue(afterSortingValue < beforeSortingValue);
		// driver.quit();
	}

	@Test(dependsOnMethods = "testPriceLowtoHigh")
	public void secondTest() throws MalformedURLException {

		// beforeSortingPrice = sortingPricePage.getBeforeSortingPrice();
		//System.out.println("beforeSortingPrice======" + beforeSortingPrice);
		sortingPricePage.clickFilterButton();
		sortingPricePage.choosePriceHightoLow();

		afterSortingPrice = sortingPricePage.getAfterSortingPriceHightoLow();
		// System.out.println("afterSortingPrice======" + afterSortingPrice);
		afterSortingValue = Double.parseDouble(afterSortingPrice.replace("$", ""));

		Assert.assertTrue(afterSortingValue > beforeSortingValue);

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
