@Smoke @Regression
Feature: This is to test Amazon.in Login functionality 

#without 'Scenario-Outline' and 'Examples' keywords
Scenario: Login to Amazon.in scenario test 
	Given Load Browser 
	Then Click to Login Area 
	Then Give Username as "sssendas@gmail.com" 
	And Click on Continue button 
	Then Enter Password as "S@25658861" 
	And Check keep me signed in checkbox 
	And Click on Login button 
	Then Close the browser 
