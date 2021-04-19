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
import n26.monefy.expense.ExpenseCalculation;
import n26.monefy.homepage.HomePage;

public class TC003_Expense extends TestBase {

	public static final Logger log = Logger.getLogger(TC003_Expense.class.getName());

	public static ExtentTest child;

	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void init() throws IOException {
		driver = Capabilities();
	}

	@Test(priority = 1, enabled = true)
	public void expenseCalculation() throws IOException, InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		child = ExtentTestManager.startTest("Expense calculation", "Expense calculation in monefy");
		child.log(Status.INFO, "Add expense in moneyfy");

		HomePage hoempage = new HomePage(driver);
		hoempage.commonBase();
		
		ExpenseCalculation expenseCalculation = new ExpenseCalculation(driver);
		expenseCalculation.expenseCalculationTab(1, "+", 1);
		
		child.log(Status.INFO, "Expense added successfully in monefy");
		
	}
	
	@AfterMethod
	public void endTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
