package demoapp.SampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckHamburgerMenuPage {
	AndroidDriver driver;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement hamburgerMenu;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-GEO LOCATION\"]")
	public WebElement geoLocationItem;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Latitude:\"]")
	public WebElement latitude;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Longitude:\"]")
	public WebElement longitude;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-DRAWING\"]")
	public WebElement drawingItem;
	
	@AndroidFindBy(xpath = "//android.widget.Image")
	public WebElement drawingCanvas;

	public CheckHamburgerMenuPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅ important
	}

	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}
	
	public void clickGeoLocationItem() {
		geoLocationItem.click();
	}
	
	public String getLatitudeLabel() {
		return latitude.getText();
	}
	
	public String getLongitudeLabel() {
		return longitude.getText();
	}
	
	public void clickDrawingItem() {
		drawingItem.click();
	}

}
