Feature: As a user I should be to view the list of items in home page
	
	Scenario: Unauthorized user should be able to view list of items
		Given I am on the home page
		Then I should be able to view list of items
	
	Scenario Outline: Authorized user should be able to view list of items
		Given I am logged in
		Then I am on the home page
		And I should be able to view list of items
	Examples:
	|username|password|
	|johnd|password|