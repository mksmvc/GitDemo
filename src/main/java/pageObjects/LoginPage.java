package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email =By.name("email");
	private By password = By.id("user_password");
	private By loginBtn = By.cssSelector("[type='submit']");
	private By forgotPassword = By.cssSelector("[href*='password/new']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}
	
	
	
	

