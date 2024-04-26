#Display Bookshelves
***
***

###Problem Statement : Display Bookshelves

- **Display the name, price of Bookshelves**

>
1. below Rs. 15000 
2. Including out of stock
3. Take first 3 study chair details with highest recommendation. If more than one item with same price displayed, include that details as well.

 _(Suggested site: urbanladder.com  however you are free to use any other legitimate site)_

###Detailed Description: Hackath Ideas

- 1. Display the name & price of first 3 Bookshelves below Rs. 15000,
 with Storage type as open & exclude out of stock
 
- 2. From Collections(UL Collections), retrieve
 all sub-menu items under Category Drop Down and store in a List;
 Display the same
 
- 3. Gift cards - choose "Birthday/Anniversay";
 fill customize the gift card; fill from with details with any 
one input invalid (example: email); Capture & display the error message

-(Suggested site: urbanladder.com  however you are free 
to use any other legitimate site)

###Key Automation Scope

>
- Handling alert, drag & drop, search option
- Extract menu items & store in collections
- Navigating back to home page
- Scrolling down in web page
- Filling form (in different objects in web -page)
- Capture warning message

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

```

##Output
***
***

- [RemoteTestNG] detected TestNG version 7.9.0

**Scenario: Display the name & price of first three Bookshelves below Rs.15K # FeatureFiles/feature1.feature:3**
***
-  Given I am on the homepage                                               # com.Hack.stepDefinitions.feature1.i_am_on_the_homepage()

-  _Embedding DisplaythenamepriceoffirstthreeBookshelvesbelowRs15K_Success [image/png 389325 bytes]_

>
- Entered 'Bookshelves' in SearchBox
- Clicked search Button

 - When I search for Bookshelves                                            # -com.Hack.stepDefinitions.feature1.i_search_for_bookshelves()

-   _ Embedding DisplaythenamepriceoffirstthreeBookshelvesbelowRs15K_Success [image/png 961725 bytes]_

>
- popup closed
- out of stock clicked
- selected
- right scrolled

-  And I apply price and stock filters                                      # com.Hack.stepDefinitions.feature1.i_apply_price_and_stock_filters()

-   _ Embedding DisplaythenamepriceoffirstthreeBookshelvesbelowRs15K_Success [image/png 425118 bytes]_

>
-Product 1
- Product Name: Aaron Engineered Wood Bookshelf In Wenge Finish
- Price: ₹805

>
-Product 2
 - Product Name: Vector Solid Wood Bookshelf In White Finish
 - Price: ₹6,754

>
-Product 3
- Product Name: Kassel Solid Wood Bookshelf In Lacquered Finish
- Price: ₹10,141

-  Then I should see and retreive name & price of first three Bookshelves   # com.Hack.stepDefinitions.feature1.i_should_see_and_retreive_name_price_of_first_three_bookshelves()

-   _ Embedding DisplaythenamepriceoffirstthreeBookshelvesbelowRs15K_Success [image/png 1539245 bytes]_


**Scenario: Retrieve all sub-menu items under -Category Drop Down # FeatureFiles/feature2.feature:3**
***
-  Given I am on the Home                                       # com.Hack.stepDefinitions.feature2.i_am_on_the_home()

-   _ Embedding RetrieveallsubmenuitemsunderCategoryDropDown_Success [image/png 1539257 bytes]_


 - When I hover on Trending and click Ul Collections            # com.Hack.stepDefinitions.feature2.i_hover_on_trending_and_click_ul_collections()

-   _ Embedding RetrieveallsubmenuitemsunderCategoryDropDown_Success [image/png 737676 bytes]_

>- popup closed

-  And I click on the Category drop down                        # com.Hack.stepDefinitions.feature2.i_click_on_the_category_drop_down()

-    _Embedding RetrieveallsubmenuitemsunderCategoryDropDown_Success [image/png 702726 bytes]_

>-/******Printing Categories sub-menu******/
- Beds with Storage
- Accent Chairs
- Bar Cabinets
- Beds without Storage
- Recliners
- Sofa cum Bed
- Bedside Tables
- Crockery Units
- Bookshelves
- Coffee Tables
- Console Table
- Cribs
- Cupboards
- Lounge Chairs
- Balcony Chairs
- Benches
- Chest of Drawers
- Dining Benches
- Dining Chairs
- Loveseats
- Ottomans & Stools
- Single Beds
- Study Chair
- Study Tables
- Wall Shelves

-  Then I should see and retrieve and print all sub-menu items  # com.Hack.stepDefinitions.feature2.i_should_see_and_retrieve_and_print_all_sub_menu_items()

-    _Embedding RetrieveallsubmenuitemsunderCategoryDropDown_Success [image/png 702726 bytes]_


**Scenario: Customize the gift card with invalid email input    # FeatureFiles/feature3.feature:3**
***
-  Given I am on the HomePage1                                 # com.Hack.stepDefinitions.feature3.i_am_on_the_home_page1()

-    _Embedding Customizethegiftcardwithinvalidemailinput_Success [image/png 1539257 bytes]_


-  When I click on Gift Cards                                  # com.Hack.stepDefinitions.feature3.i_click_on_gift_cards()

-    _Embedding Customizethegiftcardwithinvalidemailinput_Success [image/png 1115096 bytes]_


>- /****Amount Entered ****/
>- /****Month and Date selected ****/
>- /**** Next Button Clicked****/

-  And I select Birthday/Anniversary                           # com.Hack.stepDefinitions.feature3.i_select_birthday_anniversary()

-    _Embedding Customizethegiftcardwithinvalidemailinput_Success [image/png 369828 bytes]_

>
- /**** Details Filled****/
- 'Confirm' Button is clickable
- /****Clicked 'Confirm' Button ****/

-  And I fill in the details with one invalid inputs           # com.Hack.stepDefinitions.feature3.i_fill_in_the_details_with_one_invalid_inputs()

-    _Embedding Customizethegiftcardwithinvalidemailinput_Success [image/png 1247570 bytes]_

>
- Error Message 1: Customer email is invalid
- Error Message 2: Recipient email is invalid

-  Then I should capture and print the error message displayed # com.Hack.stepDefinitions.feature3.i_should_capture_and_print_the_error_message_displayed()

-    _Embedding Customizethegiftcardwithinvalidemailinput_Success [image/png 1247570 bytes]_

***
***
- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Retrieve all sub-menu items under Category Drop Down", "Print Collections submenu")
- _Runs Cucumber Scenarios_

- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Display the name & price of first three Bookshelves below Rs.15K", "Print filtered products")
- _Runs Cucumber Scenarios_

- **PASSED:** io.cucumber.testng.AbstractTestNGCucumberTests.runScenario("Customize the gift card with invalid email input", "Capture error with invalid input")
- _Runs Cucumber Scenarios_

***

=============================================

>
-    **Default test**
-    Tests run: 1, Failures: 0, Skips: 0

=============================================


=============================================

>
- **Default suite**
- Total tests run: 3, Passes: 3, Failures: 0, Skips: 0

=============================================
