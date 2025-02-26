package automationCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationElements.checkBoxElement;
import automationElements.commonMethods;
import automationElements.radioElement;
import automationElements.textBoxElement;
import automationElements.webTables;
import utils.commonClass;

public class bookStoreApplication {
	WebDriver driver = new ChromeDriver();
	commonMethods common = new commonMethods(driver);
	commonClass commonClass = new commonClass(driver);
	textBoxElement textBox = new textBoxElement(driver);
	checkBoxElement checkbox = new checkBoxElement(driver);
	radioElement radio = new radioElement(driver);
	webTables webTable = new webTables(driver);
	automationElements.bookStoreApplication bookStore = new automationElements.bookStoreApplication(driver);
	String title;
	@BeforeTest
	public void beforeTest() {

		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
	}
	
	@Test
	public void bookStoreApplication() throws InterruptedException {

		
		String alertMessage;
		String userName;
		String dailogMessage;
		boolean buttonVisible;
		boolean buttonEnabled;
		common.waits(4000);
		bookStore.clickButtonByXpath("Login");
		title = bookStore.getTitle();
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Login", title, "The title should be Login");
		
		bookStore.clickButton("NewUser");
		title = bookStore.getTitle();
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Register", title, "The title should be Register");
		
		bookStore.enterValue("FirstName", "test");
		bookStore.enterValue("LastName", "User");
		bookStore.enterValue("UserName", "testUser");
		bookStore.enterValue("Password", "testUser@123");
		//bookStore.clickRecaptcha();
		bookStore.clickButton("Register");
		common.waits(3000);
		common.switchToAlert();
		alertMessage = common.getAlertMessage();
		System.out.println("The is title value : " + alertMessage);
		Assert.assertEquals("User Register Successfully.", alertMessage, "The title should be User Register Successfully.");
		common.acceptAlert();
		
		common.waits(3000);
		bookStore.clickButton("GoBackToLogin");
		title = bookStore.getTitle();
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Login", title, "The title should be Login");

		bookStore.enterValue("UserName", "testUser");
		bookStore.enterValue("Password", "testUser@123");
		bookStore.clickButton("LoginButton");
		common.waits(6000);
		userName = bookStore.getText("userNameValue");
		System.out.println("The is text value : " + userName);
		Assert.assertEquals("testUser", userName, "The title should be testUser");

		buttonEnabled = bookStore.ButtonEnalbedByIdAndText("Log_out");
		System.out.println("The button is Enabled : " + buttonEnabled);
		Assert.assertEquals(buttonEnabled, true, "The button is Enabled " + buttonEnabled);

		buttonVisible = bookStore.ButtonVisibleByIdAndText("Log_out");
		System.out.println("The button is Visible : " + buttonVisible);
		Assert.assertEquals(buttonVisible, true, "The button is Visible " + buttonVisible);

		bookStore.clickButtonByIdAndText("Log_out");

		bookStore.enterValue("UserName", "testUser");
		bookStore.enterValue("Password", "testUser@123");
		bookStore.clickButton("LoginButton");
		common.waits(6000);
		userName = bookStore.getText("userNameValue");
		System.out.println("The is text value : " + userName);
		Assert.assertEquals("testUser", userName, "The title should be testUser");

		buttonEnabled = bookStore.ButtonEnalbedByIdAndText("Go_To_Book_Store");
		System.out.println("The button is Enabled : " + buttonEnabled);
		Assert.assertEquals(buttonEnabled, true, "The button is Enabled " + buttonEnabled);

		buttonVisible = bookStore.ButtonVisibleByIdAndText("Go_To_Book_Store");
		System.out.println("The button is Visible : " + buttonVisible);
		Assert.assertEquals(buttonVisible, true, "The button is Visible " + buttonVisible);
		
		common.waits(3000);
		bookStore.clickButtonByIdAndText("Go_To_Book_Store");
		
		bookStore.clickButtonByXpath("Profile");
		common.waits(3000);
		buttonEnabled = bookStore.ButtonEnalbedByIdAndText("Delete_All_Books");
		System.out.println("The button is Enabled : " + buttonEnabled);
		Assert.assertEquals(buttonEnabled, true, "The button is Enabled " + buttonEnabled);

		buttonVisible = bookStore.ButtonVisibleByIdAndText("Delete_All_Books");
		System.out.println("The button is Visible : " + buttonVisible);
		Assert.assertEquals(buttonVisible, true, "The button is Visible " + buttonVisible);
		
		common.waits(3000);
		bookStore.clickButtonByIdAndText("Delete_All_Books");

		dailogMessage = bookStore.getDialogMessage();
		System.out.println("The is message value : " + dailogMessage);
		Assert.assertEquals("Do you want to delete all books?", dailogMessage,
				"The message should be Do you want to delete all books?");
		bookStore.dismmDialog("cancel");

		bookStore.clickButtonByIdAndText("Delete_All_Books");

		dailogMessage = bookStore.getDialogMessage();
		System.out.println("The is message value : " + dailogMessage);
		Assert.assertEquals("Do you want to delete all books?", dailogMessage,
				"The message should be Do you want to delete all books?");
		bookStore.acceptDialog("ok");
		common.switchToAlert();
		alertMessage = common.getAlertMessage();
		System.out.println("The is title value : " + alertMessage);
		Assert.assertEquals("No books available in your's collection!", alertMessage, "The title should be No books available in your's collection!");
		common.acceptAlert();
		common.waits(3000);
		bookStore.ButtonEnalbedByIdAndText("Delete_Account");
		bookStore.ButtonVisibleByIdAndText("Delete_Account");
		bookStore.clickButtonByIdAndText("Delete_Account");

		dailogMessage = bookStore.getDialogMessage();
		System.out.println("The is message value : " + dailogMessage);
		Assert.assertEquals("Do you want to delete your account?", dailogMessage,
				"The message should be Do you want to delete your account?");
		bookStore.dismmDialog("cancel");

		bookStore.clickButtonByIdAndText("Delete_Account");
		common.waits(3000);
		dailogMessage = bookStore.getDialogMessage();
		System.out.println("The is message value : " + dailogMessage);
		Assert.assertEquals("Do you want to delete your account?", dailogMessage,
				"The message should be Do you want to delete your account?");
		bookStore.acceptDialog("ok");
		common.waits(3000);
		common.switchToAlert();
		alertMessage = common.getAlertMessage();
		System.out.println("The is title value : " + alertMessage);
		Assert.assertEquals("User Deleted.", alertMessage, "The title should be User Deleted.");
		common.acceptAlert();
	}
	@AfterTest
	public void afterTest() {

		commonClass.takeScreenShot(getClass().getName());
	}
}
