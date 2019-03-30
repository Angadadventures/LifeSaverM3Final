#Author: Gurjot Singh
#Description: Registration form Feature File

Feature: Registration 
	this feature helps user to register to the website

	Scenario: user is trying to register using invalid set of details
	
	Given User is accessing the RegistrationPage on browser
	And  Verify the title of the page "welcome to jobsworld"
	
	When user is trying to submit data without entering 'userId'
	Then "User Id should not be empty / length be between 5 to 12" alert message should be displayed
	
	When user is trying to submit request without entering 'password'
	Then "Password should not be empty / length be between 7 to 12" alert message should be displayed
	
	When user is trying to submit request without entering 'name'
	Then "Name should not be empty and must have alphabet characters only" alert message should be displayed
	
	When user is trying to submit request without entering 'address'
	Then "User address must have alphanumeric characters only" alert message should be displayed
	
	When user is trying to submit request without entering 'country'
	Then "Select your country from the list" alert message should be displayed
	
	When user is trying to submit request without entering 'zipCode'
	Then "ZIP code must have numeric characters only" alert message should be displayed
	
	When user is trying to submit request without entering valid 'emailId'
	Then "You have entered an invalid email address!" alert message should be displayed
	
	When user is trying to submit request without entering the 'sex'
	Then "Please Select gender" alert message should be displayed


Scenario: user is trying to register using valid set of details

	Given User is accessing the RegistrationPage on browser
	When User is trying to submit request after entering valid set of information
	Then "Your Registration with JobsWorld.com has successfully done plz check your registred email addres to activate your profile" alert message should be displayed



