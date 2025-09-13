package demoapp.SampleProject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckRemoveProductfromDetailScreenPage {
	AndroidDriver driver;
	private Properties strings;

	public CheckRemoveProductfromDetailScreenPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅

		strings = new Properties();
		try {
			strings.load(getClass().getResourceAsStream("/test-strings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
	public WebElement changeViewIcon;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"+\"])[1]")
	public WebElement firstItem;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")
	public WebElement clickProductDetail;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]")
	public WebElement productNameFromDetailView;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
	public WebElement removeButton;

	public void clickChangeViewIcon() {
		changeViewIcon.click();
	}

	public void clickFirstItem() {
		firstItem.click();
	}

	public void clickProductDetailButton() {
		clickProductDetail.click();
	}

	public String getProductNameBeforeDetailScreen() {
		return clickProductDetail.getText();
	}

	public String getProductNamefromDetailScreen() {
		return productNameFromDetailView.getText();
	}

	public boolean isDisplayRemoveButton() {
		scrollToText(strings.getProperty("remove"));
		return removeButton.isDisplayed();
	}

	@SuppressWarnings("deprecation")
	public void scrollToText(String text) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}

}
