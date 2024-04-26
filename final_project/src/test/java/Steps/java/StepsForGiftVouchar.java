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

public class StepsForGiftVouchar {
	WebDriver driver;
	GiftVouchar gv;
	Cruise c;
	
	
	@Given("User mouse over on the +more icon in the NavBar")
	public void user_mouse_over_on_the_more_icon_in_the_nav_bar() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver=BaseClass.getDriver();
		gv=new GiftVouchar(driver);
	}

	@When("User is click on the Gift Voucher")
	public void user_is_click_on_the_gift_voucher() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		c=new Cruise(driver);
		c.more();
		gv.gift();
	}

	@And("User navigate to the Gift Voucher page")
	public void user_navigate_to_the_gift_voucher_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		gv.navigate();
	}

	@And("User Scroll to corporate queries")
	public void user_scroll_to_corporate_queries() {
	    // Write code here that turns the phrase above into concrete actions
		gv.scroll();
	}

	@And("User fill the Deatils")
	public void user_fill_the_deatils() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		gv.formPhoneNumber();
	}

	@Then("Display the Error Message")
	public void display_the_error_message() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		gv.formEmail();
	}

}
