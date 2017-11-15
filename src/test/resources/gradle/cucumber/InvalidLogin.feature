Feature: Try login with invalid user
Scenario Outline: Unauthorized access to application is not allowed
		Given I am on the login page
		When I enter my "<username>" and "<password>" and sign in
		Then I should remain on the login page
	Examples:
	|username|password|
	|some|some|
