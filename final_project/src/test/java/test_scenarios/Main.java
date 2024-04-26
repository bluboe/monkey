package test_scenarios;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_object.Cruise;
import page_object.GiftVouchar;
import page_object.HomePage;
import page_object.HotelPage;
import utilities.DriverSetUp;

public class Main {
	WebDriver driver;
	HotelPage hp;
	HomePage h;
	Cruise c;
	GiftVouchar gv;
	Properties p;
	
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException {
		driver=DriverSetUp.driverInstantiate("Chrome");
    	hp=new HotelPage(driver);
    	h=new HomePage(driver);
    	c=new Cruise(driver);
    	gv=new GiftVouchar(driver);
	}
	
	@Test(priority=1)
	void homepage() throws InterruptedException, IOException {
		h.clickingHotel();
		h.searchForDestination();
		h.date();
		h.guest();
		h.search();
		hp.rating();
		hp.amenities();
		hp.printingHotelDetails();
		//c.homepage();
	}
	
	@Test(priority=2)
	void hotelpage() throws InterruptedException, IOException {
		c.more();
		c.cruise();
		c.cruiseLine();
		c.cruiseDetails();
		//gv.homepage();
	}
	
	@Test(priority=3)
	void cruise() throws InterruptedException, IOException {
		gv.more();
		gv.gift();
		gv.navigate();
		gv.scroll();
		gv.formPhoneNumber();
		gv.formEmail();
		
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
