package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	//method to invoke browser webdriver -> better test maintenance
	//one method to cover ALL browsers - chrome,IE,firefox,etc
public WebDriver driver;
public Properties prop;

public WebDriver initializeDriver() throws IOException {
	 prop = new Properties();
	 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
	 prop.load(fis);
	 
	 //mvn test -Dbrowser=chrome
	 //String browserName = System.getProperty("browser");
	 
	 String browserName = prop.getProperty("browser");
	 System.out.println(browserName);
	 
	 if(browserName.contains("chrome")) {
		 //execute chrome driver
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions();
		 if(browserName.contains("headless")) {
		 options.addArguments("headless");
		 }
		 driver = new ChromeDriver(options);
		 
	 } else if (browserName.equalsIgnoreCase("firefox")) {
	
		 System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		  driver = new FirefoxDriver();
	 } else if(browserName.equalsIgnoreCase("edge")){
	
		 System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
		  driver = new EdgeDriver();
	 } 
	 
//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 new WebDriverWait(driver, Duration.ofSeconds(10));
	 return driver;
	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
