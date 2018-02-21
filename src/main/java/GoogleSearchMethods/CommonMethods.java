package GoogleSearchMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	public Logger log;
	
	public String searchTerm;
	
	public CommonMethods() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
		browser = new ChromeDriver();
		wait = new WebDriverWait(this.browser, 5);
		log = new Logger("src/test/resources/Logs/" + new SimpleDateFormat("yyyyMMdd HHmmss ").format(Calendar.getInstance().getTime()) + "TestLog.txt");
	}
	
	public void launchBrowser() throws IOException {
		browser.navigate().to("http://www.google.co.uk");
		log.logToFile("Chrome Browser Launched");
	}
	
	public void googleSearchForTerm() throws IOException {
		WebElement searchInput = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Search')]")));
		searchInput.sendKeys(searchTerm);
		searchInput.sendKeys(Keys.ENTER);
		log.logToFile("Google Search for term " + searchTerm);
	}
	
	public WebElement getSearchResults() {
		return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-async-context, 'query:" + searchTerm + "')]")));
	}
	
	public Boolean isExpectedValueInResults(String expectedValue) throws IOException {
		boolean result = getSearchResults().findElements(By.xpath("//*[contains(text(), '" + expectedValue +"')]")).size() > 0 ? true: false;
		if (result)
			log.logToFile("Google Search returned the expected value of " + expectedValue + " on the first page");
		else 
			log.logToFile("Google Search did not return the expected value of " + expectedValue + " on the first page");
		return result;
	}
	
	public void closeBrowser() {
		this.browser.close();
	}
}
