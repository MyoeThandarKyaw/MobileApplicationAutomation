package demoapp.SampleProject;

import java.time.Duration;
import java.util.Arrays;
//import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

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
	
	@AndroidFindBy(xpath = "//android.webkit.WebView")
	public WebElement drawingCanvas;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-SAVE\"]")
	public WebElement saveImage;

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
	
	public void drawImage() {
//		 Set<String> contexts = driver.getContextHandles();
//	        for (String context : contexts) {
//	            System.out.println("Context: " + context);
//	            if (context.contains("WEBVIEW")) {
//	                driver.context(context);
//	                break;
//	            }
//	        }
	        
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence drawLine = new Sequence(finger, 1);

		drawLine.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 100, 200));
		drawLine.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		drawLine.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), 300, 200));
		drawLine.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(drawLine));
	}
	
	public void saveImage() {
		saveImage.click();
	}

}
