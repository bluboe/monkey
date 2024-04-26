#Calculate Trip Cost
##Problem Statement : Calculate Trip Cost

Display total amount and charges per night for  3 holiday homes:
1. For 4 people in Nairobi from 15th Dec-2019 to 20th Dec-2019
2. Sort the list with highest traveler rating on top.
3.  Holiday home should have elevator/ List  access.

(Suggested Site: tripadvisor.in however  you are free to choose any other legitimate  site)+B6

###Detailed Description: Hackath Ideas

- 1. Display Hotel name, total amount for first 3 hotels for 4 people in any location for 5 days of stay from tomorrow's date; Should have sorted the list with highest User rating, show hotels with free Wifi, free breakfast and amenities with laundry and swimming pool. 
- 2 Pick any one cruise line  
                a. Retrieve all the Inclusion points and Display the same 

- 3.Go to gift voucher and scroll to corporate queries and fill it with invalid email and phone number.  
                a. capture error message and display the same. 
- (Suggested Site: www.yatra.com however  you are free to choose any other legitimate  site) 

### Key Automation Scope

- Handling different browser windows, search option
- Validation of date controls
- Capture warning message
- Extract list items & store in collections
- Navigating back to home page
- Scrolling down in web page

###Dependencies
```

<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.13.0</version>
<configuration>
<source>17</source>
<target>17</target>
</configuration>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.2.5</version>
<configuration>
<suiteXmlFiles>
<suiteXmlFile>testng_Cucumber.xml</suiteXmlFile>
</suiteXmlFiles>
</configuration>
</plugin>
</plugins>
</build>
<dependencies>
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
<groupId>commons-io</groupId>
<artifactId>commons-io</artifactId>
<version>2.15.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.18.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>7.9.0</version>
<scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
<groupId>org.apache.poi</groupId>
<artifactId>poi</artifactId>
<version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
<groupId>org.apache.poi</groupId>
<artifactId>poi-ooxml</artifactId>
<version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
<groupId>com.aventstack</groupId>
<artifactId>extentreports</artifactId>
<version>5.1.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-api</artifactId>
<version>3.0.0-beta2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-core</artifactId>
<version>3.0.0-beta2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-java</artifactId>
<version>7.16.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-junit</artifactId>
<version>7.16.1</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-testng</artifactId>
<version>7.16.1</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-lang3</artifactId>
<version>3.12.0</version>
</dependency>
 
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter -->
<dependency>
<groupId>tech.grasshopper</groupId>
<artifactId>extentreports-cucumber7-adapter</artifactId>
<version>1.14.0</version>
</dependency>
</dependencies>
 
</project>


```

###Output

- [RemoteTestNG] detected TestNG version 7.9.0

-**@regression**

***Scenario: Pick one Cruise Line                          # FeatureFile/Cruise.feature:4
***
- Given User mouse over on the +more in the navbar menu # Steps.java.StepsForCruise.user_mouse_over_on_the_more_in_the_navbar_menu()
- When User select the curise on the list               # Steps.java.StepsForCruise.user_select_the_curise_on_the_list()
- And User Click on the one Cruise Line                 # Steps.java.StepsForCruise.user_click_on_the_one_cruise_line()

>
- INCLUSIONS
- 2 Nights Cruise Accommodation
- Meals (as specified in the itinerary)
- Onboard Entertainment & Activities.(Some onboard activities and entertainment are chargeable)
 
-  Then Display the all Inclusion Point of the cruise    # Steps.java.StepsForCruise.display_the_all_inclusion_point_of_the_cruise()
-  And The User Goes back to the HomePage                # Steps.java.StepsForCruise.the_user_goes_back_to_the_home_page()

-**@regression**

***Scenario: Capture the Error Message and Display         # FeatureFile/GiftVouchar.feature:4
***  

-  Given User mouse over on the +more icon in the NavBar # Steps.java.StepsForGiftVouchar.user_mouse_over_on_the_more_icon_in_the_nav_bar()
-  When User is click on the Gift Voucher                # Steps.java.StepsForGiftVouchar.user_is_click_on_the_gift_voucher()
Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com
Yatra Gift Cards - Buy Yatra Gift Vouchers Online, Gift Vouchers
-  And User navigate to the Gift Voucher page            # Steps.java.StepsForGiftVouchar.user_navigate_to_the_gift_voucher_page()
-  And User Scroll to corporate queries                  # Steps.java.StepsForGiftVouchar.user_scroll_to_corporate_queries()

>
 - Phone number error message : Please enter mobile number

-  And User fill the Deatils                             # Steps.java.StepsForGiftVouchar.user_fill_the_deatils()

>
 - Email error message : Please enter your valid email id

-  Then Display the Error Message                        # Steps.java.StepsForGiftVouchar.display_the_error_message()

-**@smoke @regression**

***Scenario: Display Hotels Name                                                         # FeatureFile/HotelPage.feature:4
***
  
- Given User click on Hotel Navbar                                                    # Steps.java.StepsForHotelPage.user_click_on_hotel_navbar()
- When User Enter the Destination                                                     # Steps.java.StepsForHotelPage.user_enter_the_destination()

>
- 21/04/2024
- 25/04/2024

-  Then User pickup the checkin and checkout date after five days from tomorrow's date # Steps.java.StepsForHotelPage.user_pickup_the_checkin_and_checkout_date_after_five_days_from_tomorrow_s_date()
-  And User add four People                                                            # Steps.java.StepsForHotelPage.user_add_four_people()
-  And User Click on Search buttton                                                    # Steps.java.StepsForHotelPage.user_click_on_search_buttton()
-  Then User Click on the user rating                                                  # Steps.java.StepsForHotelPage.user_click_on_the_user_rating()

>
- Free Cancellation 5
- Free Breakfast 2
- Free WiFi 6
- Couple Friendly 2
- Longstay Hotels 1
- Women Friendly 3

>
- Free Breakfast found
- Free WiFi found
- Laundry facilities found
- Poolside Bar found

-  And User Click on all amenities                                                     # Steps.java.StepsForHotelPage.user_click_on_all_amenities()

>
- The Westin Goa
 - 82,125
- The LaLiT Golf & Spa Resort Goa
 - 4,72,804
- No more Hotels in list

-  Then Display the top 3 hotels from the hotel list                                   # Steps.java.StepsForHotelPage.display_the_top_hotels_from_the_hotel_list(java.lang.Integer)
-  And User will go back to the HomePage                                               # Steps.java.StepsForHotelPage.user_will_go_back_to_the_home_page()

***
***

- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Display Hotels Name", "Display Hotels Name")
        Runs Cucumber Scenarios
        
- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Capture the Error Message and Display", "Verify the Email id and phone Number")
        Runs Cucumber Scenarios
- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Pick one Cruise Line", "Pick one Cruise line and Retrieve all the Inclusion points")
        Runs Cucumber Scenarios

===============================================

 -   Default test
 -   Tests run: 1, Failures: 0, Skips: 0
    
===============================================

===============================================

- Default suite
- Total tests run: 3, Passes: 3, Failures: 0, Skips: 0

===============================================

