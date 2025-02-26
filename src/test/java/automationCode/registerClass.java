package automationCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationElements.commonMethods;
import automationElements.formElements;
import utils.commonClass;
import utils.excelFileReader;

public class registerClass {

	WebDriver driver = new ChromeDriver();
	commonClass common = new commonClass(driver);
	formElements form = new formElements(driver);
	@BeforeTest
	public void initialize() {
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
	}

	@DataProvider(name="registerData")
	public Object[][] dataProvider() {
		Object[][] testData = null;
		try {
			testData = excelFileReader.getTableArray("Sheet1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (testData);
	}

	@Test(dataProvider = "registerData")
	public void Main(String[] data) {
		
		System.out.println("data"+data);
		String firstName = data[0];
		String lastName = data[1];
		String address= data[2];
        String email= data[3];
        String phone= data[4];
        String gender= data[5];
        String hobbies= data[6];
        String languages= data[7];
        String skills= data[8];
        String year= data[9];
        String month= data[10];
        String day= data[11];
        String password= data[12];
        String confirmPassword= data[13];
        
        
		Reporter.log("The Name is :"+firstName);
		form.enterValueByXpath("FirstName",firstName);
		form.enterValueByXpath("LastName",lastName);
		form.enterValueByXpath("Adress",address);
		form.enterValueByXpath("EmailAdress",email);
		form.enterValueByXpath("Phone",phone);
		form.enterValueByXpath("EmailAdress","");
		form.enterFieldValue("Languages",languages);
		form.selectDropValue("Skills",skills);
		form.enterFieldValue(hobbies,hobbies);
		form.enterFieldValue("year",year);
		form.enterValueByXpath("monthbox",month);
		form.enterFieldValue("day",day);
		form.enterFieldValue("Password",password);
		form.enterFieldValue("confirmPassword",confirmPassword);
		form.clickButton("submitButton");
	}

	@AfterTest
	public void quit() {
		common.takeScreenShot(getClass().getName());
	}
}