package Steps.java;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.Cruise;
import page_object.HomePage;
import page_object.HotelPage;
import utilities.DriverSetUp;

public class StepsForHotelPage {
	WebDriver driver;
	HomePage h;
	HotelPage hp;
	Cruise c;
	
	@Given("User click on Hotel Navbar")
	public void user_click_on_hotel_navbar() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver=BaseClass.getDriver();
		h=new HomePage(driver);
		h.clickingHotel();
	}

	@When("User Enter the Destination")
	public void user_enter_the_destination() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		h.searchForDestination();
	}

	@Then("User pickup the checkin and checkout date after five days from tomorrow's date")
	public void user_pickup_the_checkin_and_checkout_date_after_five_days_from_tomorrow_s_date() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		h.date();
	}

	@Then("User add four People")
	public void user_add_four_people() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		h.guest();
	}

	@Then("User Click on Search buttton")
	public void user_click_on_search_buttton() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		h.search();
	}

	@Then("User Click on the user rating")
	public void user_click_on_the_user_rating() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp=new HotelPage(driver);
		hp.rating();
	}

	@Then("User Click on all amenities")
	public void user_click_on_all_amenities() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		hp.amenities();
	}

	@Then("Display the top {int} hotels from the hotel list")
	public void display_the_top_hotels_from_the_hotel_list(Integer int1) throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		hp.printingHotelDetails();
	}

	@Then("User will go back to the HomePage")
	public void user_will_go_back_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		c=new Cruise(driver);
//		c.homepage();
	}


}
