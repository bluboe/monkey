package com.Hack.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Hack.factory.BaseClass;
import com.Hack.pageObjects.Bookshelves;
import com.Hack.pageObjects.HomePage;
import com.Hack.pageObjects.UlCollections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class feature2 {
	WebDriver driver;
	HomePage homePg;
	UlCollections uCollect;
	Bookshelves books;

@Given("I am on the Home")
public void i_am_on_the_home() {
	driver=BaseClass.getDriver();
	homePg=new HomePage(driver);
	uCollect=new UlCollections(driver);
	books=new Bookshelves(driver);
}

@When("I hover on Trending and click Ul Collections")
public void i_hover_on_trending_and_click_ul_collections() throws InterruptedException {
	homePg.hoverTrending();
	homePg.clickULCollections();
}

@And("I click on the Category drop down")
public void i_click_on_the_category_drop_down() throws InterruptedException {
	books.closePopUp();
	uCollect.hoverCategory();
	
}

@Then("I should see and retrieve and print all sub-menu items")
public void i_should_see_and_retrieve_and_print_all_sub_menu_items() throws IOException {
	uCollect.getSubMenu();
}

}
