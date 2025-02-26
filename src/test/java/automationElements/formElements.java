package automationElements;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class formElements {
	
	private static String filePath = "D:\\Job\\Files\\";
	private RespositoryParser parser;
	WebDriver driver;

	public formElements(WebDriver driver) {

		this.driver = driver;
		try {
			parser = new RespositoryParser(
					"D://Job//automatiomCode//src//test//java//formElements.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickButtonByXpath(String fieldName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = fieldName.replace("_", " ");  
		String id = parser.getbjectLocator(fieldName);
		WebElement element = driver
				.findElement(By.xpath("//li[@id='" + id + "']//*[contains(text(), '" + value + "')]/.."));
		js.executeScript("arguments[0].click();", element);
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
	public void selectRadioButton(String radioName) {
		Reporter.log("Entered the Method of selectRadioButton");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		//to-do try to implement this. but, while element is trying to select it is intercepted 
		//element.click();
		js.executeScript("arguments[0].click();", element);
		Reporter.log("exited the Method of selectRadioButton");
	}
	
	public void selectCheckBox(String radioName) {
		Reporter.log("Entered the Method of selectRadioButton");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		//to-do try to implement this. but, while element is trying to select it is intercepted 
		//element.click();
		js.executeScript("arguments[0].click();", element);
		Reporter.log("exited the Method of selectRadioButton");
	}
	
	public void selectValue(String fieldName,String dropDownValues) {
		String[] values = dropDownValues.split(","); 
		WebElement element = null;
		
		for(String value : values ) {
			element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
			element.sendKeys(value);
			element.sendKeys(Keys.TAB);
		}
		
	}
	public void selectDropDownByID(String fieldName,String dropDownValues) {
		String[] values = dropDownValues.split(","); 
		WebElement element = null;
		
		for(String value : values ) {
			element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		Select select  = new Select(element);
		select.selectByValue(value);
		}
		
	}
	
	public void uploadFile(String fieldName,String fileName) {
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		element.sendKeys(filePath + fileName);
	}
	
	public void uploadFileByRobot(String fieldName,String fileName) throws AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		js.executeScript("arguments[0].click();", element);
		
		Robot robot = new Robot();
		//Code to Enter D1.txt 
		//Press Shify key 
		robot.keyPress(KeyEvent.VK_SHIFT);
		//Press d , it gets typed as upper case D as Shift key is pressed
		robot.keyPress(KeyEvent.VK_D);
		//Release SHIFT key to release upper case effect
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_X);
		robot.keyPress(KeyEvent.VK_T);
		
		//Press ENTER to close the popup
        robot.keyPress(KeyEvent.VK_ENTER);  
	}
	public void enterValueByXpath(String fieldName,String fieldValue) {
		WebElement element = driver.findElement(By.xpath("//input[@ng-model='"+fieldName+"']"));
		element.clear();
		element.sendKeys(fieldValue);
	}
	
	public void selectDropValue(String fieldName,String fieldValue) {
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldValue)));
		
		Select select = new Select(element);
		select.selectByValue(fieldValue);
	}
	
	public void multiSelectValues(String language) {
		WebElement element = driver.findElement(By.xpath("//div[@id='msdd']//..//div//ul/li//a[contains(text(),'"+language+"')]"));
		Select select = new Select(element);
		
		select.selectByContainsVisibleText(language);
	}
	
}
