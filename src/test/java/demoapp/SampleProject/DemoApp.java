package demoapp.SampleProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class DemoApp {
	public AndroidDriver driver;
	SwagLabsOnlineShopPage swagLabsOnlineShopPage;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Galaxy A16 5G"); // "device" or real name from adb
		caps.setCapability("udid", "R94XC07VMMV"); // optional if only one device connected
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appium:platformVersion", "14");
		caps.setCapability("app",
				"D:\\Testing Information\\AUTOMATION\\AUTOMATION-UPDATE\\SampleProject\\resources\\Onlineshop.apk");
		caps.setCapability("appPackage", "com.swaglabsmobileapp");
		caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		caps.setCapability("autoGrantPermissions", true);

		// Optional: you can specify appPackage & appActivity if needed

		URL appiumServerUrl = URI.create("http://127.0.0.1:4723").toURL();
		// driver = new AndroidDriver<>(appiumServerUrl, caps);
		driver = new AndroidDriver(appiumServerUrl, caps);
		swagLabsOnlineShopPage = new SwagLabsOnlineShopPage(driver);
		
	}

	@Test
	public void testSampleApp() {
		swagLabsOnlineShopPage.setUserName("standard_user");
		swagLabsOnlineShopPage.setPassword("secret_sauce");
		swagLabsOnlineShopPage.clickLoginButton();
		swagLabsOnlineShopPage.clickAddtoCartButton();
		swagLabsOnlineShopPage.clickCardButton();
		swagLabsOnlineShopPage.clickCheckOutButton();
		swagLabsOnlineShopPage.setUserInformation("Myoe Thandar", "Kyaw", "+95");
		swagLabsOnlineShopPage.clickContinueButton();
		swagLabsOnlineShopPage.clickFinishButton();
		swagLabsOnlineShopPage.clickBackHomeButton();
	}

	@AfterClass
	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
	}
}
