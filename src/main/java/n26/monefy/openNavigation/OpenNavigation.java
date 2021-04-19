package n26.monefy.openNavigation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.testCases.TC004_OpenNavigation;

/**
 * The open navigation tab is used check balance according to time period.
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-19
 */
public class OpenNavigation extends TC004_OpenNavigation {

	public AndroidDriver<AndroidElement> driver;

	@FindBy(xpath = "//android.widget.TextView")
	WebElement homepageVerification;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation\"]")
	WebElement openNavigation;
	
	@FindBy(id = "com.monefy.app.lite:id/title")
	WebElement allAccount;

	@FindBy(id = "com.monefy.app.lite:id/day_period_button")
	WebElement dayPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/week_period_button")
	WebElement weekPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/month_period_button")
	WebElement monthPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/year_period_button")
	WebElement yearPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/all_period_button")
	WebElement allPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/custom_period_button")
	WebElement customPeriodButton;
	
	@FindBy(id = "com.monefy.app.lite:id/show_datepicker_button")
	WebElement showDatepickerButton;
	
	@SuppressWarnings("unchecked")
	public OpenNavigation(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Open navigation tab.
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void openNavigationTab() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		assertEquals("Monefy", homepageVerification.getText());

		openNavigation.click();
		
		assertEquals("All accounts", allAccount.getText());
		assertEquals("Day", dayPeriodButton.getText());
		
		assertEquals("Week", weekPeriodButton.getText());
		assertEquals("Month", monthPeriodButton.getText());
		assertEquals("Year", yearPeriodButton.getText());
		assertEquals("All", allPeriodButton.getText());
		assertEquals("Interval", customPeriodButton.getText());
		assertEquals("Choose date", showDatepickerButton.getText());
		
		getScreenshot(driver, "openNavigation");
		
	
	}

}
