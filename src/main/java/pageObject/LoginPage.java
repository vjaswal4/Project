package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By emailAddress = By.cssSelector("input[autofocus='autofocus']");

	By password = By.cssSelector("input[type='password']");

	By loginBtn = By.cssSelector("input[value='Log In']");

	public WebElement getEmailAddress() {
		return driver.findElement(emailAddress);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);

	}
}
