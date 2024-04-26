package com.Hack.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Hack.factory.BaseClass;
import com.Hack.pageObjects.Bookshelves;
import com.Hack.pageObjects.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class feature1 {
	WebDriver driver;
	HomePage home;
	Bookshelves books;
	

@Given("I am on the homepage")
public void i_am_on_the_homepage() {
	driver=BaseClass.getDriver();
	home=new HomePage(driver);
	books=new Bookshelves(driver);
	
}


@When("I search for Bookshelves")
public void i_search_for_bookshelves() throws InterruptedException {
    home.enterSearchBox();
    home.clickSearchButton();
    
}

@And("I apply price and stock filters")
public void i_apply_price_and_stock_filters() throws InterruptedException {
    books.closePopUp();
    books.excludeOutOfStock();
    books.priceFilter();
}

@Then("I should see and retreive name & price of first three Bookshelves")
public void i_should_see_and_retreive_name_price_of_first_three_bookshelves() throws InterruptedException, IOException {
	books.printElements();
    books.homePageButton();
}

}
