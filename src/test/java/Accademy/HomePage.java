package Accademy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PopupLandingPage;
import resource.Base;

public class HomePage extends Base {

	
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public LoginPage logPage;
	public LandingPage lp;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PopupLandingPage plp = new PopupLandingPage(driver);

		plp.getNoThanksButton().click();

		lp = new LandingPage(driver);

		lp.getLogin().click();

		LoginPage logPage = new LoginPage(driver);

	}

	@Test(dataProvider = "getData")
	public void homePageNavigation(String userName, String password, String text) throws IOException {

		logPage.getEmailAddress().sendKeys(userName);
		logPage.getPassword().sendKeys(password);

		log.info("User is " + text);

		logPage.getLoginBtn().click();
	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different data types a test should run.
		// Column stands for how many values per each tests
		Object data[][] = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non Restricted User";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "123456";
		data[1][2] = "Restricted User";

		return data;
	}

	@AfterTest
	public void closing() {
		driver.close();
		driver = null;
	}
}
