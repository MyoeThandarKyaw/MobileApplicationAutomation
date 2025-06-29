package demoapp.SampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuItemPage {
	AndroidDriver driver;
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	public WebElement user_Name;
	
	public MenuItemPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
