Feature: Login Scenarios 



Scenario: Verify admin user must able to login into the application 

	Given user reached on login screen 
	When user enters credentials and click on Sign in button 
	Then   user must reached to  landing page validate by title

	
Scenario: Verify MOVR  user must able to login into the application 

	Given MOVR user reached on login screen 
    When MOVR user enters credentials and click on Sign in button 
	Then   user  must reached to  landing page of MOVR application  validate by title


