package demoapp.SampleProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class CheckHamburgerMenu extends DriverFactory{
	LoginPage loginPage;
	CheckHamburgerMenuPage checkHamBurgerMenuPage;
	String latitudeLabel;
	String expetedLatitudeLabel ="Latitude:";
	String longitudeLabel;
	String expetedLongitudeLabel ="Longitude:";
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException{
		
		loginPage = new LoginPage(driver);
		checkHamBurgerMenuPage = new CheckHamburgerMenuPage(driver);
	}
	public void login() {
		loginPage.setUserName("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLoginButton();
	}
	@Test
	public void checkGeoLocation() {
		login();
		checkHamBurgerMenuPage.clickHamburgerMenu();
		checkHamBurgerMenuPage.clickGeoLocationItem();
		latitudeLabel=checkHamBurgerMenuPage.getLatitudeLabel();		
		Assert.assertTrue(expetedLatitudeLabel.contains(latitudeLabel), "latitudeLabel '" + latitudeLabel + "' not found in text");
		longitudeLabel=checkHamBurgerMenuPage.getLongitudeLabel();		
		Assert.assertTrue(expetedLongitudeLabel.contains(longitudeLabel), "longitudeLabel '" + longitudeLabel + "' not found in text");
	}
	
	@Test(dependsOnMethods = "checkGeoLocation")
	public void checkDrawing() throws MalformedURLException {
		checkHamBurgerMenuPage.clickHamburgerMenu();
		checkHamBurgerMenuPage.clickDrawingItem();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
