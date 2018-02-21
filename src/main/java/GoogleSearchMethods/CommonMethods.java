package GoogleSearchMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
	WebDriver browser;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
		browser = new ChromeDriver();
		browser.navigate().to("http://www.google.co.uk");
	}
	
	public void closeBrowser() {
		this.browser.close();
	}
}
