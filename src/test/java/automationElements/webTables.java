package automationElements;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class webTables {
	WebDriver driver;
	private RespositoryParser parser;
	public webTables(WebDriver driver) {
		this.driver = driver;
		try {
			parser = new RespositoryParser("D://Job//automatiomCode//src//test//java//webTables.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getCellValueas(String colName,String colValue,String rowName) {
		
		int rowNumber = getRowNumber(colName,colValue);
		String value = getRowValue(rowNumber,rowName);
		WebElement element = driver.findElement(By.xpath(""));
	}
	
	private int getRowNumber(String colName, String colValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCellValue(String colName,String colValue,String secondColName) {
		int colIndex = -1;
		int rowIndex = -1;
		String columnName;
		String columnValue;
		int columnCount;
		
		String value = null;
		List<WebElement> colElement = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
		columnCount = colElement.size();
		for(int i =0;i<colElement.size();i++) {
			columnName = colElement.get(i).getText();
			if(columnName.equalsIgnoreCase(colName)) {
				colIndex = i + 1;
				break;
			}
		}
		if(colIndex > 0) {
			List<WebElement> rowElement = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"));
			for(int i =0;i<rowElement.size();i++) {
				if(i < columnCount ) {
				columnValue = rowElement.get(i).getText();
				if(columnValue.equalsIgnoreCase(colValue)) {
					rowIndex =+1;
					
					value = getCellValue(colIndex,rowIndex,secondColName);
					break;
				}
				}else {
					i = 0;
				}
			}
		}
		return value;
		
		
	}
	
	private String getCellValue(int colIndex, int rowIndex, String secondColName) {
		WebElement rowElement = driver.findElement(By.xpath("//div[@class='rt-thead -header']//div["+colIndex+"]//ancestor::div[@class='rt-table']//div[@class='rt-td']/..//div["+rowIndex+"]"));
		
		return null;
	}

	public String getRowValue(int rowNumber,String rowValue) {
		int colIndex = -1;
		String columnName = null;
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
		for(int i =0;i<element.size();i++) {
			columnName = element.get(i).getText();
			if(columnName.equalsIgnoreCase(columnName)) {
				colIndex = i + 1;
			}
		}
		return columnName;
		
	}
}
