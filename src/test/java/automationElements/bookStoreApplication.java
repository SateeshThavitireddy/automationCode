package automationElements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class bookStoreApplication {
	private RespositoryParser parser;
	WebDriver driver;

	public bookStoreApplication(WebDriver driver) {

		this.driver = driver;
		try {
			parser = new RespositoryParser(
					"D://Job//automatiomCode//src//test//java//bookStoreApplication.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTitle() {

		String titleValue;
		WebElement element = driver.findElement(By.xpath("//h1[@class='text-center']"));
		titleValue = element.getText();
		return titleValue;
	}

	public String getText(String ID) {
		String id;
		String textValue;
		id = parser.getbjectLocator(ID);
		WebElement element = driver.findElement(By.id(id));
		textValue = element.getText();
		return textValue;
	}

	public void enterValue(String fieldName, String fieldValue) {

		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		element.clear();
		element.sendKeys(fieldValue);
	}

	public void clickButton(String fieldName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(fieldName)));
		js.executeScript("arguments[0].click();", element);
	}

	public void clickButtonByXpath(String fieldName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = fieldName.replace("_", " ");  
		String id = parser.getbjectLocator(fieldName);
		WebElement element = driver
				.findElement(By.xpath("//li[@id='" + id + "']//*[contains(text(), '" + value + "')]/.."));
		js.executeScript("arguments[0].click();", element);
	}

	public void clickRecaptcha() {

		WebElement element = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
		element.click();
	}

	public void clickButtonByIdAndText(String fieldName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String id = parser.getbjectLocator(fieldName);
		String value = fieldName.replace("_", " ");  
		WebElement element = driver
				.findElement(By.xpath("//button[@id='" + id + "']/..//button[contains(text(),'" + value + "')]"));
		js.executeScript("arguments[0].click();", element);
	}

	public boolean ButtonVisibleByIdAndText(String fieldName) {
		boolean visible = false;
		String value = fieldName.replace("_", " ");  
		String id = parser.getbjectLocator(fieldName);
		WebElement element = driver
				.findElement(By.xpath("//button[@id='" + id + "']/..//button[contains(text(),'" + value + "')]"));
		visible = element.isEnabled();

		return visible;

	}

	public boolean ButtonEnalbedByIdAndText(String fieldName) {
		boolean enabled = false;
		String value = fieldName.replace("_", " ");  
		String id = parser.getbjectLocator(fieldName);
		WebElement element = driver
				.findElement(By.xpath("//button[@id='" + id + "']/..//button[contains(text(),'" + value + "')]"));
		enabled = element.isEnabled();

		return enabled;

	}
	
	public void closeDialog() {
		WebElement element = driver.findElement(By.xpath("//button[@class='close']"));
		element.click();
	}
	
	public String getDialogMessage() {
		String dialogMessage;
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-body']"));
		dialogMessage = element.getText();
		return dialogMessage;
	}
	public void acceptDialog(String buttonName) {
		String id = parser.getbjectLocator(buttonName);
		WebElement element = driver.findElement(By.id(id));
		element.click();
	}
	
public void dismmDialog(String buttonName) {
	String id = parser.getbjectLocator(buttonName);
	WebElement element = driver.findElement(By.id(id));
	element.click();
	}

@SuppressWarnings("deprecation")
public String getToolTipText(String tooltip) {
	String toolTipText;
	WebElement element = driver.findElement(By.id(parser.getbjectLocator(tooltip)));
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	toolTipText = element.getAttribute("title");
	return toolTipText;
}
}
