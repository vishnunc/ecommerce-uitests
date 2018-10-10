Feature: As a user I should be able to login to application
	
	Scenario Outline: User should be able to login successfully
		Given I am on the login page
		When I enter my "<username>" and "<password>" and sign in
		Then I should be logged in successfully
	Examples:
	|username|password|
	|johnd|password|
	|acme|something|
		
