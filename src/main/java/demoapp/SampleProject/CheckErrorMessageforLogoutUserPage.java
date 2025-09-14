package demoapp.SampleProject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckErrorMessageforLogoutUserPage {
	AndroidDriver driver;
	private Properties strings;
	
	public CheckErrorMessageforLogoutUserPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅ important
		
		strings = new Properties();
		try {
			strings.load(getClass().getResourceAsStream("/test-strings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")
	public WebElement errorMessage;
	
	public String getErrorMessageForLoggedOutUser() {
		return errorMessage.getText();
	}

}
