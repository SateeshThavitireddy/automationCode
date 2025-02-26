package automationCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationElements.commonMethods;
import utils.commonClass;

public class widgetClass {
	WebDriver driver = new ChromeDriver();
	commonMethods common = new commonMethods(driver);
	commonClass commonClass = new commonClass(driver);
	automationElements.bookStoreApplication bookStore = new automationElements.bookStoreApplication(driver);
	@BeforeTest
	public void beforeTest() {

		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
	}

	@Test
	public void widgets() {
		String tooltip;
		bookStore.clickButtonByXpath("Tabs");
		bookStore.clickButton("What");
		common.waits(4000);
		bookStore.clickButton("origin");
		bookStore.clickButton("use");
		bookStore.clickButton("more");
		
		bookStore.clickButtonByXpath("Tool_Tips");
		tooltip = bookStore.getToolTipText("toolTip");
		//System.out.println("The is title value : " + tooltip);
		//Assert.assertEquals("Register", tooltip, "The title should be Register");
		
		bookStore.clickButtonByXpath("Select_Menu");
	}
	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
