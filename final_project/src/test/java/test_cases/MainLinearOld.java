package test_cases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import page_object.Cruise;
import page_object.GiftVouchar;
import page_object.HomePage;
import page_object.HotelPage;
import utilities.DriverSetUp;
import utilities.ExcelUtils;
import utilities.ScreenShot;



public class MainLinearOld extends DriverSetUp{
	static List<String>list1=new ArrayList<>();
	static List<String>list2=new ArrayList<>();
	static String browser="Chrome";

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your desired browser");
		String Browser=sc.nextLine();
		driver=DriverSetUp.driverInstantiate("Chrome");
		HomePage hp=new HomePage(driver);
		HotelPage htp=new HotelPage(driver);
		GiftVouchar gv=new GiftVouchar(driver);
		Cruise c=new Cruise(driver);
		ExcelUtils e=new ExcelUtils();
		hp.clickingHotel();
		hp.searchForDestination();
		hp.date();
		hp.guest();
		hp.search();
		htp.rating();
		htp.amenities();
		htp.printingHotelDetails();
		ScreenShot.takeScreenShot(driver);
		c.homepage();
		c.cruiseDetails();
		ScreenShot.takeScreenShot(driver);
		gv.homepage();
		gv.gift();
		ScreenShot.takeScreenShot(driver);
		//e.putData(list1,list2);
		
	}


}
