Feature: Print Collections submenu

  Scenario: Retrieve all sub-menu items under Category Drop Down
    Given I am on the Home
    When I hover on Trending and click Ul Collections
    And I click on the Category drop down
    Then I should see and retrieve and print all sub-menu items
