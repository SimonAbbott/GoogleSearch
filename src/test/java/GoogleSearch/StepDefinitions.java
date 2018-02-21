package GoogleSearch;

import GoogleSearchMethods.CommonMethods;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	CommonMethods commonMethods = new CommonMethods();
	
	@Given ("^I navigate to google.co.uk in the Google Chrome browser$")
	public void iNavigateToTheWebsiteInTheBrowser() {
		commonMethods.launchBrowser();
	}
	
	@When ("^I Google search for the term testing$")
	public void iGoogleSearchForTheTerm() {
		commonMethods.googleSearchForTerm("Testing");
    }
	
	@Then ("^The website https://en.wikipedia.org/wiki/Software_testing is displayed in the search results$")
	public void theWebsiteIsDisplayedInTheSeachResults() {
	}
	
	@After()
	public void afterScenario() { 
		commonMethods.closeBrowser();
	}
}
