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
import n26.monefy.base.ExtentTestManager;
import n26.monefy.base.TestBase;
import n26.monefy.homepage.HomePage;
import n26.monefy.newTransfer.NewTransfer;

public class TC006_NewTransfer extends TestBase {

	public static final Logger log = Logger.getLogger(TC006_NewTransfer.class.getName());

	public static ExtentTest child;

	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void init() throws IOException {
		driver = Capabilities();
	}

	@Test(priority = 1, enabled = true)
	public void newTransfer() throws IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("New Transfer", "New transfer amount");
		child.log(Status.INFO, "Verify new transfer section");

		HomePage hoempage = new HomePage(driver);
		hoempage.commonBase();
		
		NewTransfer newTransfer = new NewTransfer(driver);
		newTransfer.newTransferTab();
		
		child.log(Status.INFO, "Amount transfered from cash to card");
		
	}
	
	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
