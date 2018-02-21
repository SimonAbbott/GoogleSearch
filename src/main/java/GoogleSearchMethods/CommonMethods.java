package GoogleSearchMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	public WebDriver browser;
	public WebDriverWait wait;
	
	public String searchTerm;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
		browser = new ChromeDriver();
		browser.navigate().to("http://www.google.co.uk");
		
		wait = new WebDriverWait(this.browser, 5);
	}
	
	public void googleSearchForTerm() {
		WebElement searchInput = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Search')]")));
		searchInput.sendKeys(searchTerm);
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public WebElement getSearchResults() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-async-context, 'query:" + searchTerm + "')]")));
	}
	
	public Boolean isExpectedValueInResults(String expectedValue) {
		return getSearchResults().findElements(By.xpath("//*[contains(text(), '" + expectedValue +"')]")).size() > 0 ? true: false;
	}
	
	public void closeBrowser() {
		this.browser.close();
	}
}
