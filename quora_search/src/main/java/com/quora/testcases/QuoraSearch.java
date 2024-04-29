package com.quora.testcases;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.quora.pages.Landing_Page;
import com.quora.pages.SignUp_page;
import com.quora.utilities.DriverSetup;
import com.quora.utilities.ScreenShot;

public class QuoraSearch extends DriverSetup{
	public static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE BROWSER TYPE: ");
		String browser = sc.nextLine();
		sc.close();
		
		
		driver=DriverSetup.driverInstantiate(browser);
		
		
		Landing_Page page1= new Landing_Page(driver);
		Thread.sleep(2000);
		ScreenShot.takeScreenShot(driver);
//		page1.verifyTitle();
//		page1.getCredAndHigh();
//		page1.getLivedIn();
//		page1.getContentViews();
//		page1.getActiveIn();
//		page1.getDateJoin();
		page1.getSpaces();
		page1.clickViewMoreButton();
		page1.getSpacesElement();
		page1.clickSignIn();
		Thread.sleep(2000);
		ScreenShot.takeScreenShot(driver);
		
		SignUp_page page2= new SignUp_page(driver);
		page2.clickSignUpWithEmail();
		Thread.sleep(2000);
		ScreenShot.takeScreenShot(driver);
		page2.getNextButton();
		page2.getEmailField();
		page2.getErrorMessage();
		Thread.sleep(2000);
		ScreenShot.takeScreenShot(driver);
		
		DriverSetup.driverTearDown();

	}

}
