package test_cases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import page_object.Cruise;
import page_object.GiftVouchar;
import page_object.HomePage;
import page_object.HotelPage;
import utilities.DriverSetUp;
import utilities.ScreenShot;

public class Main_pom {
	static WebDriver driver;
	static String browser="Chrome";

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		HotelPage hp;
		HomePage h;
		Cruise c;
		GiftVouchar gv;
		driver=DriverSetUp.driverInstantiate("Chrome");
    	hp=new HotelPage(driver);
    	h=new HomePage(driver);
    	c=new Cruise(driver);
    	gv=new GiftVouchar(driver);
    	h.clickingHotel();
		h.searchForDestination();
		h.date();
		h.guest();
		h.search();
		hp.rating();
		hp.amenities();
		hp.printingHotelDetails();
		//ScreenShot.takeScreenShot(driver);
		c.homepage();
		c.more();
		c.cruise();
		c.cruiseLine();
		c.cruiseDetails();
		//ScreenShot.takeScreenShot(driver);
		gv.homepage();
		gv.more();
		gv.gift();
		gv.navigate();
		gv.scroll();
		gv.formPhoneNumber();
		//ScreenShot.takeScreenShot(driver);
		gv.formEmail();
		//ScreenShot.takeScreenShot(driver);
		
		

	}

}
