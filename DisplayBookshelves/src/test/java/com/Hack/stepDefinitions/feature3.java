package com.Hack.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.Hack.factory.BaseClass;
import com.Hack.pageObjects.GiftCards;
import com.Hack.pageObjects.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class feature3 {
	WebDriver driver;
	HomePage home;
	GiftCards gift;

@Given("I am on the HomePage1")
public void i_am_on_the_home_page1() {
	driver=BaseClass.getDriver();
	home=new HomePage(driver);
	gift=new GiftCards(driver);
}

@When("I click on Gift Cards")
public void i_click_on_gift_cards() {
	home.clickGiftCard();
}

@When("I select Birthday\\/Anniversary")
public void i_select_birthday_anniversary() throws InterruptedException {
	gift.bDayAnni();
	gift.customise();
	gift.clickNextButton();

}

@And("I fill in the details with one invalid inputs")
public void i_fill_in_the_details_with_one_invalid_inputs() throws InterruptedException {
	gift.fillDetails();
	gift.clickConfirm();
	gift.clickPayment();
}


@Then("I should capture and print the error message displayed")
public void i_should_capture_and_print_the_error_message_displayed() {
	gift.catchErrorOnPayment();
}
}
