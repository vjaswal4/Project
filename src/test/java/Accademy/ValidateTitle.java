package Accademy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PopupLandingPage;
import resource.Base;

public class ValidateTitle extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(url);

		log.info("Driver is initialised");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PopupLandingPage plp = new PopupLandingPage(driver);

		plp.getNoThanksButton().click();
	}

	@Test
	public void basePageNavigation() throws IOException {

		System.out.println("Inside basePageNavigation");

		LandingPage lp = new LandingPage(driver);

		String actualText = lp.getTitle().getText();

		log.info("Actual Title : " + actualText);

		String expectedText = "FEATURED COURSES";

		Assert.assertEquals(actualText, expectedText);

		log.info("Successfuly validated");

	}

	@AfterTest
	public void closing() {
		driver.close();
		driver = null;
		System.out.println("Closing Browser");
	}
}
