Feature: Create Prospect


Scenario: Verify user must able to create prospect

	Given user login the app
    When on the landing page tap on User and select MOVR
	Then tap on create new prospect button and fill the form
	And once record saved successfully
	Then  verify the data has been added into the application
	
	


