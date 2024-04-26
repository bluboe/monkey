Feature: Display Hotels Name

  @smoke @regression
  Scenario: Display Hotels Name
    Given User click on Hotel Navbar
    When User Enter the Destination
    Then User pickup the checkin and checkout date after five days from tomorrow's date
    And User add four People
    And User Click on Search buttton
    Then User Click on the user rating
    And User Click on all amenities
    Then Display the top 3 hotels from the hotel list
    And User will go back to the HomePage
