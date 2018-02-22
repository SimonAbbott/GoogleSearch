# GoogleSearch

Assumptions  
 - Google chrome is installed on the test machine  
 - The test machine has access to the internet  
	
Acceptance Criteria covered  
- The test must be able to run the test with 2 parameters, a Search Term, and an expected website address.  
 -- These can be set for the when and then steps in the test feature file.  
- The test must report whether the page appears in the first page of results.  
 -- The test report details if a matching result was found on the first page of the results.  
- The test should report the ranking of the pages found. (3rd, 7th, etc…)  
 -- The test report contains the position of every matching result.  
- The report may take whatever form you like, but it must be persistent, not just console output (producing a txt file, log file or a webpage for example)  
 -- A text log is produced for every test.  
- The test should be able to handle the expected page appearing more than once in the search, and report on all instances.  
 -- The test report contains multiple positions if the result matches more than once.  

Acceptance Criteria not covered  
- This script should be able to run against Chrome, Firefox and IE by changing a browser parameter  
 -- This can be done by seting the scenarios to Scenario outlines and passing in a list of browsers as examples in the Given step.  
 -- Code can be written to take this browser input and switch the web driver that is used.  
- The test could search more than the first page of results, but should not take more than 2 minutes to execute.  
 -- The existing code can be reused for this with code added to navigate through the pages.  
