Feature: Print filtered products

  Scenario: Display the name & price of first three Bookshelves below Rs.15K
    Given I am on the homepage
    When I search for Bookshelves
    And I apply price and stock filters
    Then I should see and retreive name & price of first three Bookshelves