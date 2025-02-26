package automationElements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class radioElement {

	WebDriver driver;
	private RespositoryParser parser;
	public radioElement(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new RespositoryParser("D://Job//automatiomCode//src//test//java//textBox.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void unselectRadioButton(String radioName) {
		Reporter.log("Entered the Method of unselectRadioButton");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		//to-do try to implement this. but, while element is trying to select it is intercepted 
		//element.click();
	    js.executeScript("arguments[0].click();", element);
		Reporter.log("exited the Method of unselectRadioButton");
	}
	
	public boolean verifyRadioSelected(String radioName) {
		boolean isRadioButtonSelected = false;
		Reporter.log("Entered the Method of isRadioButtonselected");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonSelected = element.isSelected();
		Reporter.log("exited the Method of isRadioButtonselected");
		return isRadioButtonSelected;
	}
	public boolean verifyRadioDisplayed(String radioName) {
		boolean isRadioButtonDisplayed = false;
		Reporter.log("Entered the Method of isRadioButtonDisplayed");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonDisplayed = element.isDisplayed();
		Reporter.log("exited the Method of isRadioButtonDisplayed");
		return isRadioButtonDisplayed;
	}
	public boolean verifyRadioEnabled(String radioName) {
		boolean isRadioButtonEnabled = false;
		Reporter.log("Entered the Method of verifyRadioEnabled");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonEnabled = element.isEnabled();
		Reporter.log("exited the Method of verifyRadioEnabled");
		return isRadioButtonEnabled;
	}
	
	public boolean verifyRadioUnSelected(String radioName) {
		boolean isRadioButtonUnSelected = true;
		Reporter.log("Entered the Method of verifyRadioUnSelected");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonUnSelected = element.isSelected();
		Reporter.log("exited the Method of verifyRadioUnSelected");
		return isRadioButtonUnSelected;
	}
	public boolean verifyRadioNotDisplayed(String radioName) {
		boolean isRadioButtonNotDisplayed = true;
		Reporter.log("Entered the Method of verifyRadioNotDisplayed");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonNotDisplayed = element.isDisplayed();
		Reporter.log("exited the Method of verifyRadioNotDisplayed");
		return isRadioButtonNotDisplayed;
	}
	public boolean verifyRadioNotEnabled(String radioName) {
		boolean isRadioButtonNotEnabled = true;
		Reporter.log("Entered the Method of isRadioButtonNotEnabled");
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(radioName)));
		isRadioButtonNotEnabled = element.isEnabled();
		Reporter.log("exited the Method of isRadioButtonNotEnabled");
		return isRadioButtonNotEnabled;
	}
}
