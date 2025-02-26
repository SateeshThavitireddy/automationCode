package automationCode;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automationElements.commonMethods;
import automationElements.formElements;
import utils.commonClass;

public class formClass {
	WebDriver driver = new ChromeDriver();
	commonMethods common = new commonMethods(driver);
	commonClass commonClass = new commonClass(driver);
	formElements formElement = new formElements(driver);
	@BeforeTest
	public void beforeTest() {

		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	}
	
	@Test
	public void form() throws AWTException {
		common.selectWidgetELement("Forms");
		formElement.clickButtonByXpath("Practice_Form");
		
		formElement.enterFieldValue("firstName", "Test");
		formElement.enterFieldValue("lastName", "User");
		formElement.enterFieldValue("userEmail", "TestUser@gmail.com");
		formElement.selectRadioButton("male");
		formElement.enterFieldValue("number", "1234567890");
		formElement.enterFieldValue("dateOfbirth", "");
		formElement.selectValue("subject", "English");
		formElement.selectCheckBox("Sports");
		//formElement.uploadFileByRobot("Picture", "Pramod");
		formElement.enterFieldValue("CurrentAddress", "CurrentAddress");
		formElement.selectValue("state", "Haryana");
		formElement.selectValue("city", "Karnal");
		formElement.clickButton("submit");
	}
	@AfterTest
	public void afterTest() {
		commonClass.takeScreenShot(getClass().getName());
	}
}
