package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PopupLandingPage;
import pageObject.PortalHomePage;
import resource.Base;

public class StepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		driver = initializeDriver();

	}

	@Given("^Navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_site(String arg1) throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^Click on login link on home page to land on secure login page$")
	public void click_on_login_link_on_home_page_to_land_on_secure_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		PopupLandingPage plp = new PopupLandingPage(driver);

		plp.getNoThanksButton().click();

		LandingPage lp = new LandingPage(driver);

		lp.getLogin().click();

		LoginPage logPage = new LoginPage(driver);

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		LoginPage logPage = new LoginPage(driver);

		logPage.getEmailAddress().sendKeys(arg1);
		logPage.getPassword().sendKeys(arg2);

		// log.info("User is " + arg1);

		logPage.getLoginBtn().click();

	}

	@Then("^Verify User is successfuly logged in$")
	public void verify_User_is_successfuly_logged_in() throws Throwable {
		
		
		// Write code here that turns the phrase above into concrete actions
		
		PortalHomePage php = new PortalHomePage(driver);
		
		boolean boxDisplayed  = php.getTextBox().isDisplayed();
        
		Assert.assertTrue(boxDisplayed);
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in1(String username, String password) throws Throwable {
		LoginPage logPage = new LoginPage(driver);

		logPage.getEmailAddress().sendKeys(username);
		logPage.getPassword().sendKeys(password);

		// log.info("User is " + arg1);

		logPage.getLoginBtn().click();
	
	}
	
	@And("^Close Browsers$")
    public void close_browsers() throws Throwable {
        
		driver.quit();
    }
}
