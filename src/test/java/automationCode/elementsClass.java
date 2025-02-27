package automationCode;

import org.testng.annotations.Test;

import automationElements.checkBoxElement;
import automationElements.commonMethods;
import automationElements.radioElement;
import automationElements.textBoxElement;
import automationElements.webTables;
import utils.commonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class elementsClass {

	WebDriver driver = new ChromeDriver();
	commonMethods common = new commonMethods(driver);
	textBoxElement textBox = new textBoxElement(driver);
	checkBoxElement checkbox = new checkBoxElement(driver);
	radioElement radio = new radioElement(driver);
	commonClass commonClass = new commonClass(driver);
	webTables webTable = new webTables(driver);
	automationElements.bookStoreApplication bookStore = new automationElements.bookStoreApplication(driver);
	String title;

	@BeforeTest
	public void beforeTest() {

		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void verifyTitleValue() {
		Reporter.log("Entered the verifyTitleValue Method");
		common.waits(4000);
		common.selectElement("Text_Box");
		title = common.getTitle("Text_Box");
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Text Box", title, "The title should be Text Box");
		Reporter.log("Exited the verifyTitleValue method");
	}

	@Test(priority = 1)
	public void enterFieldValues() {
		Reporter.log("Entered the enterFieldValues Method");
		textBox.enterFieldValue("FullName", "XYZ");
		textBox.enterFieldValue("Email", "abc@gmail.com");
		textBox.enterFieldValue("Current_Address", "XYZ Apartment");
		textBox.enterFieldValue("Permanent_Address", "XYZ Apartment");
		textBox.clickButton("submit");
		Reporter.log("Exited the enterFieldValues Method");
	}

	@Test(priority = 2)
	public void verifyCheckBoxTitle() {
		Reporter.log("Entered the verifyCheckBoxTitle Method");
		common.waits(4000);
		common.selectElement("Check_Box");
		title = common.getTitle("Check_Box");
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Check Box", title, "The title should be Check Box");

		Reporter.log("Exited the verifyCheckBoxTitle Method");
	}
	@Test(priority = 3)
	public void selectCheckBoxs() {
		Reporter.log("Entered the selectCheckBoxs Method");
		common.switchToIframe("Check Box");
		checkbox.clickArrowByJS("Home");
		Reporter.log("Exited the selectCheckBoxs Method");
	}

	@Test(priority = 4)
	public void verifyRadioValue() {
		Reporter.log("Entered the verifyRadioValue Method");
		common.selectElement("Radio_Button");
		title = common.getTitle("Radio_Button");
		System.out.println("The is title value : " + title);
		Assert.assertEquals("Radio Button", title, "The title should be Radio Button");
		Reporter.log("Exited the verifyRadioValue method");
	}

	@Test(priority = 5)
	public void selectRadioButton() {

		boolean isRadioSelected;
		boolean isRadioDisplayed;
		boolean isRadioEnabled;
		Reporter.log("Entered the selectRadioButton Method");
		radio.selectRadioButton("yes");
		isRadioSelected = radio.verifyRadioSelected("yes");
		Assert.assertEquals(true, isRadioSelected, "The value should be true");

		// isRadioDisplayed = radio.verifyRadioDisplayed("yes");
		// Assert.assertEquals(true, isRadioDisplayed,"The value should be true");

		isRadioEnabled = radio.verifyRadioEnabled("yes");
		Assert.assertEquals(true, isRadioEnabled, "The value should be true");

		radio.selectRadioButton("impressiveRadio");
		isRadioSelected = radio.verifyRadioSelected("impressiveRadio");
		Assert.assertEquals(true, isRadioSelected, "The value should be true");

		// isRadioDisplayed = radio.verifyRadioDisplayed("impressiveRadio");
		// Assert.assertEquals(true, isRadioDisplayed,"The value should be true");

		isRadioEnabled = radio.verifyRadioEnabled("impressiveRadio");
		Assert.assertEquals(true, isRadioEnabled, "The value should be true");

		// isRadioDisplayed = radio.verifyRadioDisplayed("no");
		// Assert.assertEquals(true, isRadioDisplayed,"The value should be true");

		isRadioEnabled = radio.verifyRadioEnabled("no");
		Assert.assertEquals(false, isRadioEnabled, "The value should be true");

		Reporter.log("Exited the selectRadioButton method");
	}

	@Test(priority = 7)
	public void bookStoreApplication() throws InterruptedException {

		String alertMessage;
		String userName;
		String dailogMessage;
		boolean buttonVisible;
		boolean buttonEnabled;
		common.waits(4000);
	//	common.selectWidgetELement("Elements");
		common.selectWidgetELement("Book Store Application");
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
//	@Test(priority = 6)
//	public void verifyWebTables() {
//		common.waits(4000);
//		common.selectElement("Web_Tables");
//
//		webTable.getCellValue("Email", "cierra@example.com", "Age");
//		title = common.getTitle("Web_Tables");
//		System.out.println("The is title value : " + title);
//		Assert.assertEquals("Web Tables", title, "The title should be Web Tables");
//	}
	@AfterTest
	public void afterTest() {

		commonClass.takeScreenShot(getClass().getName());
	}

	//writing this comment to check the git hub is working.

}
