package GoogleSearchMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	WebDriver browser;
	WebDriverWait wait;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
		browser = new ChromeDriver();
		browser.navigate().to("http://www.google.co.uk");
	}
	
	public void googleSearchForTerm(String searchString) {
		wait = new WebDriverWait(this.browser, 5);
		WebElement searchInput = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Search')]")));
		searchInput.sendKeys(searchString);
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void closeBrowser() {
		this.browser.close();
	}
}
