package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

	public static WebDriver driver;

	public String url;

	public Properties prop;

	public WebDriver initializeDriver() throws IOException

	{

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\17786\\Project\\src\\main\\java\\resource\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		url = prop.getProperty("url");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\17786\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firfox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\17786\\geckodriver-v0.24.0-win64\\gekodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "C:\\Users\\17786\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\17786\\Screenshots\\" + result + "screenshot.png"));
	}
}
