package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static WebDriver OpenBrowser(WebDriver driver, String browserName, String URL) throws InterruptedException {
		
		if(browserName.toUpperCase().equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			Thread.sleep(5000);
			return driver;
		}
		else {
			return null;
		}
	}
	
	
}
