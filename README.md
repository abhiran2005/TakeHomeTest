# TakeHomeTest

This project contains classes to test Quora login and signup workflows. 
The code is written in Java using Eclipse IDE.
JRE - 17.0.1
TestNG - 7.4.0.202106051955
Selenium - 4.1.2
ChromeDriver - 97.0.4692.71




Packages and classes 
*pages - This package contains page classes corresponding to different pages on the UI.
	*BasePage - This is a parent class for individual page classes and contains generic method implementations used by all 				child classes
	*LoginPage - This page corresponds to the landing page of Quora where user gets options to either Login or signup.
	*SignupPage - This page corresponds to the page which opens when user clicks on Signup link on Login Page 
	*EmailConfirmationPage - This page corresponds to the page which allows user to enter the email confirmation code and 							 proceed with signup workflow.

*testcases - This package contains test classes.
	*BaseTest - This is parent class for individual test cllasses and contians generic methods implementations.
	*LoginTests - This class contains testcases related to login flow.
	*SignupTests - This class contains testcases related to signup flow.
	
*utils - This package contains utility classes.
	*TestHelper - This class contains helper methods which are unrelated to the actual workflow or WebDriver.
	
	
	


