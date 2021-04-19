package n26.monefy.newTransfer;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.testCases.TC006_NewTransfer;

/**
 * Verify new transfer amount in Monefy
 *
 * @author Nayan Agrawal
 * @version 1.0
 * @since 2021-04-19
 */
public class NewTransfer extends TC006_NewTransfer {

	public AndroidDriver<AndroidElement> driver;

	@FindBy(xpath = "//android.widget.TextView")
	WebElement homepageVerification;

	@FindBy(id = "com.monefy.app.lite:id/transfer_menu_item")
	WebElement transferMenuItem;
	
	@FindBy(id = "com.monefy.app.lite:id/amount_text")
	WebElement amountText;
	
	@FindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
	WebElement keyboardActionButton;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewDate")
	WebElement textViewDate;
	
	
	@SuppressWarnings("unchecked")
	public NewTransfer(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify new transfer.
	 *
	 * @throws IOException
	 */
	public void newTransferTab() throws IOException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		assertEquals("Monefy", homepageVerification.getText());

		transferMenuItem.click();
		
		String pattern = "EEEEE, dd MMMMM";
		SimpleDateFormat simpleDateFormat =
		        new SimpleDateFormat(pattern, new Locale("en", "US"));

		String date = simpleDateFormat.format(new Date());
		
		assertEquals(date, textViewDate.getText());
				
		getScreenshot(driver, "NewTransfer");
		
	
	}

}
