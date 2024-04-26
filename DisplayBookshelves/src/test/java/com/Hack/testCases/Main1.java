package com.Hack.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Hack.pageObjects.Bookshelves;
import com.Hack.pageObjects.GiftCards;
import com.Hack.pageObjects.HomePage;
import com.Hack.pageObjects.UlCollections;
import com.Hack.utilities.DriverSetup;

public class Main1 {

	public static WebDriver driver;
	HomePage hp;
	Bookshelves bs;
	UlCollections uc;
	GiftCards gc;
	
	
	
	@BeforeMethod
	void serUp() {
		driver=DriverSetup.invokeBrowser();
		hp=new HomePage(driver);
		bs=new Bookshelves(driver);
		uc=new UlCollections(driver);
		gc=new GiftCards(driver);
	}
	
	
	@Test(priority=1)
	void test1() throws InterruptedException, IOException {
		//Requirement 1	
		System.out.println("\n/****Requirement 1****/");
		
		hp.enterSearchBox();
		hp.clickSearchButton();	
		bs.closePopUp();
		bs.excludeOutOfStock();
		bs.priceFilter();
		bs.printElements();
		bs.homePageButton();
	}

	@Test(priority=2)
	void test2() throws InterruptedException, IOException {
		//Requirement 2
		System.out.println("\n/****Requirement 2****/");
		hp.hoverTrending();
		hp.clickULCollections();
		uc.closePopUp();
		uc.hoverCategory();
		uc.getSubMenu();
		bs.homePageButton();
	}

	@Test(priority=3)
	void test3() throws InterruptedException {
		//Requirement 3
		System.out.println("\n/****Requirement 3****/");
		hp.clickGiftCard();
		gc.bDayAnni();
		gc.customise();
		gc.clickNextButton();
		gc.fillDetails();
		gc.clickConfirm();
		gc.clickPayment();
		gc.catchErrorOnPayment();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	void tearDown() {
		DriverSetup.driverTearDown();
	}

	
}
