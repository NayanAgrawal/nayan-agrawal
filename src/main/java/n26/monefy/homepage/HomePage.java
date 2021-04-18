package n26.monefy.homepage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.base.ConfigFileReader;
import n26.monefy.testCases.TC001_Homepage;

public class HomePage extends TC001_Homepage {

	public AndroidDriver<AndroidElement> driver;
	ConfigFileReader readValue;

	@FindBy(xpath = "//android.widget.TextView")
	WebElement homepageVerification;

	

	@SuppressWarnings("unchecked")
	public HomePage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void incomeTab() throws IOException, InterruptedException {

		readValue = new ConfigFileReader();
		commonBase();

	}

	public void commonBase() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		assertEquals("Monefy", homepageVerification.getText());

		Thread.sleep(5000);

	}
}
