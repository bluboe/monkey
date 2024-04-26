Feature: Verify the Email id and phone Number

  @regression
  Scenario: Capture the Error Message and Display
    Given User mouse over on the +more icon in the NavBar
    When User is click on the Gift Voucher
    And User navigate to the Gift Voucher page
    And User Scroll to corporate queries
    And User fill the Deatils
    Then Display the Error Message