package Academy.E2EProject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;
	
	@Test
	public void titleValidation() throws IOException {
		l = new LandingPage(driver);
		String naslov = l.getTitle().getText();
		Assert.assertEquals("Featured courses",naslov);
		log.info("Title is displayed");
	}
	
	@Test
	public void headerValidation() throws IOException {
		l = new LandingPage(driver);
		Assert.assertEquals("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING",l.getHeader().getText());
		log.info("Header is displayed");
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();	
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("URL is opened");
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
}
