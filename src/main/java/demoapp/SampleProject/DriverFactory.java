package demoapp.SampleProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	protected AndroidDriver driver;

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

		URL appiumServerUrl = null;
		try {
			appiumServerUrl = URI.create("http://127.0.0.1:4723").toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver(appiumServerUrl, caps);
	}
//	@AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
