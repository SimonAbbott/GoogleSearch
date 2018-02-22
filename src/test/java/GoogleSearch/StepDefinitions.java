package GoogleSearch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import GoogleSearchMethods.CommonMethods;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	public CommonMethods commonMethods;
	
	public StepDefinitions() {
		commonMethods = new CommonMethods();
	}
	
	@Given ("^I navigate to google.co.uk in the Google Chrome browser$")
	public void iNavigateToTheWebsiteInTheBrowser() throws IOException {
		commonMethods.launchBrowser();
	}
	
	@When ("^I Google search for the term (.*)$")
	public void iGoogleSearchForTheTerm(String searchTerm) throws IOException {
		commonMethods.searchTerm = searchTerm;
		commonMethods.googleSearchForTerm();
    }
	
	@Then ("^The website (.*) is displayed in the search results$")
	public void theWebsiteIsDisplayedInTheSeachResults(String expectedValue) throws IOException {
		assertTrue(commonMethods.isExpectedValueInResults(expectedValue));
	}
	
	@Then ("^The website (.*) is not displayed in the search results$")
	public void theWebsiteIsNotDisplayedInTheSeachResults(String expectedValue) throws IOException {
		assertFalse(commonMethods.isExpectedValueInResults(expectedValue));
	}
	
	@After()
	public void afterScenario() { 
		commonMethods.closeBrowser();
	}
}
