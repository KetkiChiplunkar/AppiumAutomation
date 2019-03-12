package Base;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollingDemo extends AppiumBase {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	@Test
	public void testScrolling() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']")
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath(
				"//android.widget.TextView[@text='Drag and Drop']").click();
		WebElement first = driver.findElementsByClassName("android.view.View")
				.get(0);
		WebElement second = driver.findElementsByClassName("android.view.View")
				.get(1);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(first)))
				.moveTo(element(second)).release().perform();
	}

}
