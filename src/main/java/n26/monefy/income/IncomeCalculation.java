package n26.monefy.income;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import n26.monefy.base.ConfigFileReader;
import n26.monefy.testCases.TC002_Income;

public class IncomeCalculation extends TC002_Income {

	public AndroidDriver<AndroidElement> driver;
	ConfigFileReader readValue;

	@FindBy(id = "com.monefy.app.lite:id/income_button_title")
	public WebElement incomeButton;
	
	@FindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
	public WebElement chooseCategoryButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Salary']")
	public WebElement incomeType;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewNote")
	public WebElement textViewNote;
	
	@FindBy(id = "com.monefy.app.lite:id/balance_amount")
	public WebElement finalBalanceAmount;
	
	@SuppressWarnings("unchecked")
	public IncomeCalculation(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Add new income in Monefy
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException
	 */
	public void incomeCalculationTab(int firstNumber, String operator, int secondNumber)
			throws InterruptedException, IOException, AWTException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		incomeButton.click();
		
		String firstNumberValue = "//*[@package='com.monefy.app.lite'][@class='android.widget.Button'][@text='"
				+ firstNumber + "']";
		driver.findElement(By.xpath(firstNumberValue)).click();

		String operatorValue = "//*[@package='com.monefy.app.lite'][@class='android.widget.Button'][@text='" + operator
				+ "']";
		driver.findElement(By.xpath(operatorValue)).click();

		String secondNumberValue = "//*[@package='com.monefy.app.lite'][@class='android.widget.Button'][@text='"
				+ secondNumber + "']";
		driver.findElement(By.xpath(secondNumberValue)).click();

		String resultOperator = "//*[@package='com.monefy.app.lite'][@class='android.widget.Button'][@text='" + "="
				+ "']";
		driver.findElement(By.xpath(resultOperator)).click();
		
		Thread.sleep(5000);

		textViewNote.sendKeys("This is from salary");
		
		chooseCategoryButton.click();
		
		incomeType.click();

		System.out.println(finalBalanceAmount.getText());
	}

}