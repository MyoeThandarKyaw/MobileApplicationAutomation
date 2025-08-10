package demoapp.SampleProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckRemoveProductfromDetailScreenPage {
	AndroidDriver driver;

	public CheckRemoveProductfromDetailScreenPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); // ✅ important
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
	public WebElement changeViewIcon;	

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"+\"])[1]")
	public WebElement firstItem;
	
	public void clickChangeViewIcon() {
		changeViewIcon.click();
	}

	public void clickFirstItem() {
		firstItem.click();
	}

}
