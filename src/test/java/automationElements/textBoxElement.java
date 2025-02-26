package automationElements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class textBoxElement {
	private RespositoryParser parser;
	WebDriver driver;
	
	
	public textBoxElement(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new RespositoryParser("D://Job//automatiomCode//src//test//java//textBox.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enterFieldValue(String fieldName,String fieldValue) {
		Reporter.log("Entered the Method of enterFieldValue");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		element.clear();
		element.sendKeys(fieldValue);
		Reporter.log("exited the Method of enterFieldValue");
	}
	public void clickButton(String buttonName) {
		Reporter.log("Entered the Method of clickButton");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(buttonName)));
		element.click();
		Reporter.log("exited the Method of clickButton");
	}
}
