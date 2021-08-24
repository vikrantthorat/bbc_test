Feature: Add Staff Memeber 

#	Scenario: Admin must able to create a new staff member
#	Given user login the application in order to add staff 
#	And go to the user tab and select Team and tap on add new staff member 
#	Then fill add staff member form and click on create staff member 
#	And search the newly added member and tap on the detail 
#	Then on the info tab, add title ,select DOB, and add contact number 
#	And go to public tab select years of training
#	Then enable the featured toggle button and verify the success message
#	And click add spcialities include title and private personal training
#	Then add social media information
#	Then tap on parternership add data inside the parternership
#	And tap on photos tab and add photos
#	And Enter Rates
#	

#	Scenario Outline: verify user is able to set timings in availibility management
#	Given user login the application in order to add staff
#	And user navigates to availibility managment page
#	And user selects staff "<staff_name>" and able to select date range and able to set hours
#	Then user can save hours verify confirmation message
#	And verify after refresh the page data is still intact for the staff "<staff_name>"
#	Examples:
#	|staff_name|
#	|Aron black|

Scenario Outline: verify user is able to set timings in location availibility management
	Given user login the application in order to add staff
	And user navigates to location availibility managment page
	And user selects location "<location_mgmt>" and able to select date range and able to set hours
	Then user can save hours and verify confirmation message
	And verify after refresh the page data is still intact for the location "<location_mgmt>"
	Examples:
	|location_mgmt|
	|WRKOUT|

#Scenario Outline: verify user can verify data on product and services page
#	Given user login the application in order to add staff
#	And user navigates to product and services page
#	And user can navigate to services tab and search for "<product_type>"
#	And user select searched service text and clear sell rate per hour text box for "<product_type>"
#	And verify servces item list is displayed correctly
#	
#	Examples:
#	|product_type|
#	|Private Personal Training|
	