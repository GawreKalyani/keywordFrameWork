package operations;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class UIOperations {
	WebDriver driver;
	public static String text=null;
	public UIOperations(WebDriver driver){
		this.driver = driver;
	}
	
	
	public String perform(Properties p,String operation,String objectName,String objectType,String value)throws Exception {
		
		switch (operation.toUpperCase()) {
		
	case "CHECKSTRINGTEXT":	
		//check the text visible on web pg
		 text =driver.findElement(this.getObject(p, objectName, objectType)).getText();
		
		break;
		
	case "CLICK":
		//Perform click
		driver.findElement(this.getObject(p,objectName,objectType)).click();
		break;
		
	case "ENTERTEXT":
		//Set text on control
		driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
		break;
		
	case "GOTOURL":
		//Get url of application
		driver.get(p.getProperty(value));
		break;
		
	case "READTABLE":
		List<WebElement>rows =driver.findElements(this.getObject(p, objectName, objectType));
		for(WebElement row :rows) {
			System.out.println(row.getText());
		}
		break;
	}
		return text;
	}
	
	private By getObject(Properties p,String objectName,String objectType) throws Exception{
		//Find by xpath
		if(objectType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(p.getProperty(objectName));
		}
		//Find by patialLinkText
		 if(objectType.equalsIgnoreCase("PARTIALLINKTEXT")){
					
					return By.partialLinkText(p.getProperty(objectName));
				}
		//Find by TagName
		if(objectType.equalsIgnoreCase("TAGNAME")){
			
			return By.tagName(p.getProperty(objectName));
		}
		//find by class
		else if(objectType.equalsIgnoreCase("ID")){
			
			return By.id(p.getProperty(objectName));
			
		}
	else
	{
		throw new Exception("Wrong object type");
	}
}
}
