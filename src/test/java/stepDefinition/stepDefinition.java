package stepDefinition;

//import org.junit.Assert;
import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
//import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

	@Given("^Initialise the browser with chrome$")
	public void initialise_the_browser_with_chrome () throws Throwable{
		driver = initializeDriver();
}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_ite(String url) throws Throwable {
		driver.get(url);
}
	@Given("^Click on Login link in the homepage to land on sign in Page$")
	public void click_on_login_link_in_the_homepage_to_land_on_sign_in_page() throws Throwable{
		LandingPage l = new LandingPage(driver);
		l.getSignin();
}
	

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_credentials_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp= new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginBtn().click();
	}
	
	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		PortalHomePage php = new PortalHomePage(driver);
		Assert.assertTrue(php.getQuery().isDisplayed());	
		System.out.println("User is logged in");
}
	 @And("^Close browser$")
	    public void close_browser() throws Throwable {
	        driver.quit();
	    }
}

