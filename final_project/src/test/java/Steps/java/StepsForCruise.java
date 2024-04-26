package Steps.java;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.Cruise;
import page_object.GiftVouchar;
import utilities.DriverSetUp;

public class StepsForCruise {
	WebDriver driver;
	Cruise c;
	GiftVouchar gv;
	
	@Given("User mouse over on the +more in the navbar menu")
	public void user_mouse_over_on_the_more_in_the_navbar_menu() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver=BaseClass.getDriver();
		c=new Cruise(driver);
		c.more();
	}

	@When("User select the curise on the list")
	public void user_select_the_curise_on_the_list() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		c.cruise();
	}

	@And("User Click on the one Cruise Line")
	public void user_click_on_the_one_cruise_line() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		c.cruiseLine();
	}

	@Then("Display the all Inclusion Point of the cruise")
	public void display_the_all_inclusion_point_of_the_cruise() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		c.cruiseDetails();
	}

	@Then("The User Goes back to the HomePage")
	public void the_user_goes_back_to_the_home_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		gv=new GiftVouchar(driver);
		gv.homepage();
	}

}
