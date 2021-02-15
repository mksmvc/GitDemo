package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver; 
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test(dataProvider="getData")
	public void signInTest(String Username, String Password, String UserType) throws IOException {
	/*	LandingPage l = new LandingPage(driver);
		l.getSignin().click();*/
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp=l.getSignin();
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(UserType);
		lp.getLoginBtn().click();
		
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("me");
		fp.sendMeInstructions().click();
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qa.com";
		data[0][1]="12345";		
		data[0][2]="Nonrestricted User";
		
		
		//1st row
		data[1][0]="restricteduser@qa.com";
		data[1][1]="54321";		
		data[1][2]="Restricted User";
	
		return data;
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
}
