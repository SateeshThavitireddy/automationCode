package automationElements;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkBoxElement {
	WebDriver driver;
	private RespositoryParser parser;
	public checkBoxElement(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new RespositoryParser("D://Job//automatiomCode//src//test//java//textBox.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickArrowButton(String textValue) {
		WebElement element = driver.findElement(By.xpath("//input[@id="+parser.getbjectLocator(textValue)+"]/ancestor::label/preceding-sibling::button[@type='button']"));
		element.click();
	}
	
	public String verifyText(String textValue) {
	
		String value = null;//input[@id='tree-node-home']/ancestor::label/preceding-sibling::button[@type='button']
		WebElement element = driver.findElement(By.xpath("//input[@id="+parser.getbjectLocator(textValue)+"]/../span[@class='rct-title']"));
		value = element.getText();
		
		return value;
		
	}
	
	
	public void clickArrowByJS(String elementName) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //String xpath = "//input[@id='" + parser.getbjectLocator(elementName) + "']/ancestor::label/preceding-sibling::button[@type='button']";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tree-node-home']/..")));

	    //element.click(); // Try normal click first

	    js.executeScript("arguments[0].click();", element);
	}

}
