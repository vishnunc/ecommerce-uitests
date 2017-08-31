Feature: As a user once I add items to cart I should be able to continue shopping
	
	Scenario Outline: Authorized user should be able to continue shopping
		Given I am logged in
		Given I am on the product home page
		When I select a "<product>"
		Then I should see the "<product>" detail page
		When I add product to Basket
		Then I should see the continue shopping button
		When I continue shopping
		Then I should be able to view list of items
	
	Examples:
	|product|
	|The Bone Bed|