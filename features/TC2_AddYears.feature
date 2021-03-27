Feature: Add years


Scenario Outline: TC2_Add years from start date
Given I launch browser and base URL
When I enter start data in module 2
When I enter value "<Value>" to get added in years
And Click calculate button to "Add"
Then I see the desired result
Examples:
|Value|
|2|
|1|