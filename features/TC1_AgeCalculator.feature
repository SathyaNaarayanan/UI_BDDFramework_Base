Feature: Caluclate Age

@demoTest
Scenario: TC1_Calculate age
Given I launch browser and base URL
When I enter start data
When I enter end date
And Click calculate button
Then I see the desired result