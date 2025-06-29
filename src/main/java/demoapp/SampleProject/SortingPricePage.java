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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
	public WebElement choosePriceLowtoHigh;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]")
	public WebElement beforeSortingPrice;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$7.99\"]")
	public WebElement afterSortingPrice;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (high to low)\"]")
	public WebElement choosePriceHightoLow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$49.99\"]")
	public WebElement afterSortingPriceHightoLow;

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

	public void choosePriceLowtoHigh() {
		choosePriceLowtoHigh.click();
	}

	public String getBeforeSortingPrice() {
		return beforeSortingPrice.getText();
	}

	public String getAfterSortingPrice() {
		return afterSortingPrice.getText();
	}

	public void choosePriceHightoLow() {
		choosePriceHightoLow.click();
	}

	public String getAfterSortingPriceHightoLow() {
		return afterSortingPriceHightoLow.getText();
	}
}
