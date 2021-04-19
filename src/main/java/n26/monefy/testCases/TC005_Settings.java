package n26.monefy.testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.Settings.Settings;
import n26.monefy.base.ExtentTestManager;
import n26.monefy.base.TestBase;
import n26.monefy.homepage.HomePage;

public class TC005_Settings extends TestBase {

	public static final Logger log = Logger.getLogger(TC005_Settings.class.getName());

	public static ExtentTest child;

	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void init() throws IOException {
		driver = Capabilities();
	}

	@Test(priority = 1, enabled = true)
	public void verifySettings() throws IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("Setting", "Verify setting tab buttons");
		child.log(Status.INFO, "Verify setting tab buttons");

		HomePage hoempage = new HomePage(driver);
		hoempage.commonBase();
		
		Settings settings = new Settings(driver);
		settings.settingsTab();
		
		child.log(Status.INFO, "Setting tab verified successfully");
		
	}
	
	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
