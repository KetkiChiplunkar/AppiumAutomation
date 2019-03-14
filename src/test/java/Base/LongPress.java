package Base;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjects.AppiumBase;

public class LongPress extends AppiumBase {

	@Test
	public void TapAction() throws InterruptedException, MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		Thread.sleep(5000);
		TouchAction t = new TouchAction(driver);
		WebElement el = driver
				.findElementByXPath("//android.widget.TextView[@text='Views']");
		t.tap(tapOptions().withElement(element(el))).perform();
		Thread.sleep(5000);
		driver.findElementByXPath(
				"//android.widget.TextView[@text='Expandable Lists']").click();
		Thread.sleep(5000);
		WebElement el1 = driver
				.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
		t.tap(tapOptions().withElement(element(el1))).perform();
		Thread.sleep(5000);
		WebElement el2 = driver
				.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(el2)).withDuration(Duration.ofSeconds(3))).release().perform();
		Thread.sleep(5000);
		
	}
}
