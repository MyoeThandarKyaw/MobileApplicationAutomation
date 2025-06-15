package demoapp.SampleProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class AddTwoNumber {
	SwagLabsOnlineShopPage twoNumberPage;
	AndroidDriver driver;
	
	@BeforeClass
    public void setUp() {
		twoNumberPage = new SwagLabsOnlineShopPage(null);
       
    }

    @Test
    public void testSampleApp() {
    	twoNumberPage.setUserName("standard_user");
    	twoNumberPage.setPassword("secret_sauce");
       
    }

    @AfterClass
    public void tearDown() {
    	 if (driver != null) {
             driver.quit();
         }
    }

}
