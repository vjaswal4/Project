package Accademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resource.Base;

public class ValidateNavigationBar extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(url);

	}

	@Test
	public void validateNavigationBarPresence() throws IOException {

		LandingPage lp = new LandingPage(driver);

		boolean navigationBarStatus = lp.getNavigationBar().isDisplayed();

		Assert.assertTrue(navigationBarStatus);

		log.info("Navigation Bar Verified.... ");

	}

	@AfterTest
	public void closing() {
		driver.close();
		driver = null;
	}
}
