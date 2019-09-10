package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	
	public WebDriver driver;
	
	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	By textBox = By.xpath("//input[@class='form-control search input-lg']");
	
	
	public WebElement getTextBox() {
		return driver.findElement(textBox);
		
	}
}
