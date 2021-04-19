package n26.monefy.Settings;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.testCases.TC005_Settings;

/**
 * The settings tab is used to update categories, accounts, currencies etc.
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-19
 */
public class Settings extends TC005_Settings {

	
	public AndroidDriver<AndroidElement> driver;

	@FindBy(xpath = "//android.widget.TextView")
	WebElement homepageVerification;

	@FindBy(id = "com.monefy.app.lite:id/overflow")
	WebElement overflow;
	
	@FindBy(id = "com.monefy.app.lite:id/categories_textview")
	WebElement categoriesTextview;

	@FindBy(id = "com.monefy.app.lite:id/accounts_textview")
	WebElement accountsTextview;
	
	@FindBy(id = "com.monefy.app.lite:id/currency_textview")
	WebElement currencyTextview;
	
	@FindBy(id = "com.monefy.app.lite:id/settings_textview")
	WebElement settingsTextview;

	@SuppressWarnings("unchecked")
	public Settings(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Open settings tab.
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void settingsTab() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		assertEquals("Monefy", homepageVerification.getText());

		overflow.click();
		
		assertEquals("Categories", categoriesTextview.getText());
		assertEquals("Accounts", accountsTextview.getText());
		
		assertEquals("Currencies", currencyTextview.getText());
		assertEquals("Settings", settingsTextview.getText());
	
		getScreenshot(driver, "settings");
		
	}

}
