package n26.monefy.testCases;

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
import n26.monefy.base.ExtentTestManager;
import n26.monefy.base.TestBase;
import n26.monefy.homepage.HomePage;

public class TC001_Homepage extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_Homepage.class.getName());

	public static ExtentTest child;

	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void init() throws IOException {
		driver = Capabilities();
	}

	@Test(priority = 1, enabled = true)
	public void homePage() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("Open Moneyfy App", "Open Moneyfy App");
		child.log(Status.INFO, "Verify Moneyfy App homepage");
		HomePage hoempage = new HomePage(driver);
		hoempage.commonBase();

		getScreenshot(driver, "homepage");
		child.log(Status.INFO, "Successfully verified monefy homepage");
	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
