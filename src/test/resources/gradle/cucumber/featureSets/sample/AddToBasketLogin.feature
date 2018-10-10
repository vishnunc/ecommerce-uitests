@login
Feature: Add to basket when logged in to application
Scenario Outline: Add To Basket when logged in
	Given I am logged in
	And I am on the product home page
	When I select a "<product>"
	Then I should see the "<product>" detail page
	When I add product to Basket
	Then "<product>" should be added to my basket
Examples:
	|product|
	|The Bone Bed|
