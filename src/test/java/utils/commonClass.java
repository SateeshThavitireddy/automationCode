package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class commonClass {
	WebDriver driver = null;

	public commonClass(WebDriver driver) {
		this.driver = driver;
	}
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
	String formattedDateTime = now.format(dateTime);
	private static  Logger logger;

    // Setup the logger to write to a file

	@Parameters({ "className" })
	public void start(String className) {
		logger = Logger.getLogger(className);
	        try {
	            // FileHandler to write logs to a file
	        	String filePath = "D://Job//AutomtionLogs//" + className + ".java_Date_" + formattedDateTime
	    				+ ".txt"; // Added ".png"

	            FileHandler fileHandler = new FileHandler(filePath, true);  // 'true' for append mode
	            fileHandler.setLevel(Level.ALL);  // Set the logging level to ALL to capture all logs
	            logger.addHandler(fileHandler);

	            // Optionally, also log to the console
	            ConsoleHandler consoleHandler = new ConsoleHandler();
	            consoleHandler.setLevel(Level.ALL);  // You can adjust logging level for console output as well
	            logger.addHandler(consoleHandler);
	        } catch (IOException e) {
	            logger.severe("Failed to initialize file handler for logging: " + e.getMessage());
	        }
		try {
			Class<?> clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void takeScreenShot(String className) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = "D://Job//AutomtionLogs//" + className + ".java_Date_" + formattedDateTime
				+ ".png"; // Added ".png"

		try {

			FileUtils.copyFile(screenshotFile, new File(filePath));
			System.out.println("Screenshot saved at: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}