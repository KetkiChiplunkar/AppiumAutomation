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

public class SwipeAction extends AppiumBase{

	@Test
	public void SwipeAction() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement>  driver =Capabilities();
		TouchAction t = new TouchAction(driver);
		WebElement el = driver
				.findElementByXPath("//android.widget.TextView[@text='Views']");
		t.tap(tapOptions().withElement(element(el))).perform();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		Thread.sleep(5000);
	//	driver.findElementByTagName("content-desc(\"2\")").click();
		driver.findElementByXPath("//*[@content-desc='3']").click();
		Thread.sleep(3000);
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(Duration.ofSeconds(2))).moveTo(element(second)).release().perform();
	}

}
