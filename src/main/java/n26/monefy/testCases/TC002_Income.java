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
import n26.monefy.income.IncomeCalculation;

public class TC002_Income extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_Income.class.getName());

	public static ExtentTest child;

	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void init() throws IOException {
		driver = Capabilities();
	}

	@Test(priority = 1, enabled = true)
	public void incomeCalculation() throws IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("Income Calculation", "Income Calculation in Monefy");
		child.log(Status.INFO, "Add income in monefy");
		HomePage login = new HomePage(driver);
		login.commonBase();

		IncomeCalculation incomeCalculation = new IncomeCalculation(driver);
		incomeCalculation.incomeCalculationTab(2, "+", 3);

		child.log(Status.INFO, "Income added successfully in monefy");
	}

	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
