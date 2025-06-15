package demoapp.SampleProject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SortingPricePage {
	AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	public WebElement user_Name;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	public WebElement user_Password;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	public WebElement loginButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	public WebElement filterButton;

    public SortingPricePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅ important
    }

    public void setUserName(String username) {
    	user_Name.sendKeys(username); 
    }
    public void setPassword(String password) {
		user_Password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickFilterButton() {
		filterButton.click();
	}
}
