Feature: As a user I should be select a product and Add it to the Basket

Scenario Outline: Add To Basket when not logged in
	Given I am on the product home page
	When I select a "<product>"
	Then I should see the "<product>" detail page
	When I add product to Basket
	Then I should see the login page
Examples:
	|product|
	|The Bone Bed|
