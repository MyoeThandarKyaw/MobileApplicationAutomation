package demoapp.SampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SwagLabsOnlineShopPage {
	AndroidDriver driver;
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
	public WebElement user_Name;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
	public WebElement user_Password;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	public WebElement loginButton;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"ADD TO CART\"])[1]")
	public WebElement addtoCardButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement clickCardButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
	public WebElement clickCheckOutButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-First Name\"]")
	public WebElement first_Name;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Last Name\"]")
	public WebElement last_Name;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")
	public WebElement zip_Code;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
	public WebElement continueButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
	public WebElement finishButton;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
	public WebElement clickBackHomeButton;

	public SwagLabsOnlineShopPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void setUserName(String userName) {
		user_Name.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		user_Password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	public void clickAddtoCartButton() {
		addtoCardButton.click();
	}
	
	public void clickCardButton() {
		clickCardButton.click();
	}
	public void clickCheckOutButton() {
		clickCheckOutButton.click();
	}
	
	public void setUserInformation(String firstName,String LastName, String zipCode ) {
		first_Name.sendKeys(firstName);
		last_Name.sendKeys(LastName);
		zip_Code.sendKeys(zipCode);
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public void clickFinishButton() {
		scrollToText("FINISH");
		finishButton.click();
	}
	
	@SuppressWarnings("deprecation")
	public void scrollToText(String text) {
	    driver.findElement(MobileBy.AndroidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}
	public void clickBackHomeButton() {
		clickBackHomeButton.click();
	}
}
