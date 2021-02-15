package Academy.E2EProject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigation extends base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test
	public void navigationValidation() throws IOException {
		LandingPage l = new LandingPage(driver);
		WebElement navigation = l.getNavBar();
		Assert.assertTrue(navigation.isDisplayed());	
		log.info("Navigation bar is displayed");
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
}
