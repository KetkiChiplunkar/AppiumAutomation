package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class AppiumBase {
	@BeforeSuite
	public void beforeExecution() throws IOException, InterruptedException {
		Runtime run = Runtime.getRuntime();
		// Runtime.getRuntime().exec("cmd /c Start C:\\Users\\ketki.chiplunkar\\workspace\\Appium\\Mobile\\ServerStart.bat");

		System.out.println("Start Running the batch file");
		Process p = run
				.exec(new String[] { "cmd.exe", "/c", "Start",
						"C:\\Users\\ketki.chiplunkar\\workspace\\Appium\\Mobile\\ServerStart.bat" });
		System.out.println("Completed");

		Thread.sleep(7000L);
	}

	public static AndroidDriver<AndroidElement> Capabilities()
			throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo1");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		cap.setCapability("clearSystemFiles", true);
		cap.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "\\src\\ApiDemos-debug.apk");
		System.out.println("**************************************************"
				+ System.getProperty("user.dir"));
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

}
