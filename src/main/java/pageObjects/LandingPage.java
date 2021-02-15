package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By signIn = By.cssSelector("a[href='https://rahulshettyacademy.com/sign_in/']");
	private By title=By.cssSelector(".text-center>h2");
	private By navBar = By.cssSelector("ul[class*='nav']");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	public LoginPage getSignin() {
		 driver.findElement(signIn).click();
		 LoginPage lp = new LoginPage(driver);
		 return lp;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);		
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);		
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
