package automationElements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonMethods {
	
	private RespositoryParser parser;
	WebDriver driver;
	
	
	public commonMethods(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new RespositoryParser("D://Job//automatiomCode//src//test//java//textBox.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectWidgetELement(String widgetElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//div[@class='header-text' and contains(text(), '"+widgetElement+"')]"));
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public void selectElement(String elementName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(elementName)));
		js.executeScript("arguments[0].click();", element);
	}
	public String getTitle(String elementName) {
		String title;
		WebElement element = driver.findElement(By.id(parser.getbjectLocator(elementName)));
		title = element.getText();
		return title;
	}
	
	public void switchToIframe(String frameName) {
		String iframeID = null;
		switch(frameName) {
		  case "Check Box":
		    iframeID = "googletagmanager.com/ns.html";
		    break;
		}
		WebElement element = driver.findElement(By.xpath("//iframe[contains(@src, "+iframeID+")]"));

		driver.switchTo().frame(element);
	}
	
	public void switchToAlert() {
		driver.switchTo( ).alert( );
	}
	
	public void acceptAlert() {
		driver.switchTo( ).alert( ).accept();
	}
	public void dismissAlert() {
		driver.switchTo( ).alert( ).dismiss();
	}
	
	public String getAlertMessage() {
		
		String alertMessage;
		alertMessage = driver.switchTo( ).alert( ).getText();
		return alertMessage;
	}
	
	public void waits(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//TODO
	public void buttonVisible(String buttonId,boolean visiblity) {
		WebElement element = driver.findElement(null);
		
	}
	


}
