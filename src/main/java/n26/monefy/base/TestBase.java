package n26.monefy.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	/**
	 * Android Device config
	 * @throws IOException 
	 * 
	 *
	 */
	public static AndroidDriver<AndroidElement> Capabilities() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\n26\\monefy\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		File file = new File(prop.getProperty("MonefyApp"));
		DesiredCapabilities cap = new DesiredCapabilities();
		//NayanTest
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.15.1");
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return driver;
	}
	
	/**
	 * Generate screenshot
	 * 
	 * @param WebDriver and image name
	 */
	public String getScreenshot(WebDriver driver, String imageName) throws IOException {

		if (imageName.equals("")) {
			imageName = "_blank";
		}

		Calendar calander = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ "/src/main/java/illumnus/application/screenshot/";

		String actualImageName = reportDirectory + imageName + "_" + format.format(calander.getTime()) + ".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);

		Reporter.log("<a href= '" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
				+ "' height='100' width ='100'/></a>");

		return actualImageName;

	}
	
	/**
	 * Method to Check if element is clickable or not
	 * 
	 */
	public static boolean isClickable(WebElement el, AndroidDriver<AndroidElement> driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.elementToBeClickable(el));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
