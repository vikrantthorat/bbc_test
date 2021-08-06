Feature: Create MOVR

Scenario: Verify  user must able to create a MOVR

	Given user login the application in order to create MOVR 
   When on the landing page must tap on User and then select MOVR
    Then  tap on create new MOVR button and fill the form
    And once MOVR record saved successfully
	Then  verify the MOVR data has been added into the application
    
    
    #Scenario: Verify MOVR user must able book a consult

#	Given user login the application in order to create MOVR 
  #  When on the landing page must tap on User and then select MOVR
    #Then  tap on create new MOVR button and fill the form
    #And once MOVR record saved successfully
	#Then  verify the MOVR data has been added into the application
	#And go to detail of the MOVR and tap on Book Consult button
	#Then book a consult for the next day
	#And go to team under the User tab and select a desired sales manager and redirect to the detail screen of it
	#Then go to live tab and select next day and verify the consult is addedd successfully
    