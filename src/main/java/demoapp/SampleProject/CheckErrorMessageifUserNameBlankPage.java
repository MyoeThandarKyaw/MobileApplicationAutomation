package demoapp.SampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckErrorMessageifUserNameBlankPage {
	AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
	public WebElement changeViewIcon;

	public CheckErrorMessageifUserNameBlankPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅ important
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"+\"])[1]")
	public WebElement firstItem;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement checkOut;

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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"First Name is required\"]")
	public WebElement errorMessage;

	public void clickChangeViewIcon() {
		changeViewIcon.click();
	}

	public void clickFirstItem() {
		firstItem.click();
	}

	public void clickCheckOuticon() {
		checkOut.click();
	}
	
	public void clickCheckOutButton() {
		scrollToText("CHECKOUT");
		clickCheckOutButton.click();
	}

	public void setUserInformation(String firstName, String LastName, String zipCode) {
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
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}

	public void clickBackHomeButton() {
		clickBackHomeButton.click();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
