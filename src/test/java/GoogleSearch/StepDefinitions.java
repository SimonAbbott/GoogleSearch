package GoogleSearch;

import static org.junit.Assert.assertTrue;

import GoogleSearchMethods.CommonMethods;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	public CommonMethods commonMethods = new CommonMethods();
	
	@Given ("^I navigate to google.co.uk in the Google Chrome browser$")
	public void iNavigateToTheWebsiteInTheBrowser() {
		commonMethods.launchBrowser();
	}
	
	@When ("^I Google search for the term (.*)$")
	public void iGoogleSearchForTheTerm(String searchTerm) {
		commonMethods.searchTerm = searchTerm;
		commonMethods.googleSearchForTerm();
    }
	
	@Then ("^The website (.*) is displayed in the search results$")
	public void theWebsiteIsDisplayedInTheSeachResults(String expectedValue) {
		assertTrue(commonMethods.isExpectedValueInResults(expectedValue));
	}
	
	@After()
	public void afterScenario() { 
		commonMethods.closeBrowser();
	}
}
