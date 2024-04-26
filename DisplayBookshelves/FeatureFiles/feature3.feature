Feature: Capture error with invalid input

  Scenario: Customize the gift card with invalid email input
    Given I am on the HomePage1
    When I click on Gift Cards
    And I select Birthday/Anniversary
    And I fill in the details with one invalid inputs
    Then I should capture and print the error message displayed
