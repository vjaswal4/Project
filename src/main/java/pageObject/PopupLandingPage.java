package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupLandingPage {
	
	public WebDriver driver;
	
	public PopupLandingPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By noThanksButton = By.xpath("//div[@class='sumome-react-wysiwyg-popup-animation-group']/span/div/div[6]");
	
	public WebElement getNoThanksButton() {
		
		
		return driver.findElement(noThanksButton);
	}

}
