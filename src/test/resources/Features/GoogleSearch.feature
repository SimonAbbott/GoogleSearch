Feature: 
As a SEO Analyst
I want to be able to search google.co.uk using the Google Chrome browser with any given search term
So that I can determine if a given website is in the first page of search results


Scenario: The given website is in the first page of the search results
    Given I navigate to google.co.uk in the Google Chrome browser
    When I Google search for the term testing
    Then The website https://en.wikipedia.org/wiki/Software_testing is displayed in the search results
    
Scenario: The given website is not in the first page of the search results
    Given I navigate to google.co.uk in the Google Chrome browser
    When I Google search for the term testing
    Then The website https://www.bbc.com is not displayed in the search results
    
Scenario: The given website is in the first page of the search results more than once
    Given I navigate to google.co.uk in the Google Chrome browser
    When I Google search for the term bbc
    Then The website bbc.com is displayed in the search results