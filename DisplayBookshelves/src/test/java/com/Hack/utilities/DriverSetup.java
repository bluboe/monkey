package com.Hack.utilities;


import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetup {
	
	public static WebDriver driver;
	public static String url ="https://www.urbanladder.com/";
	public static String browsertype;
	
	//@BeforeClass
	public static WebDriver invokeBrowser() 
	{
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("ENTER THE BROWSER TYPE: Chrome-1/ Edge-2");
//		int browser = sc.nextInt();
//		sc.close();
//		
//		int browserChoice=browser;
//		
//		switch(browserChoice) 
//			{
//			  case 1:
//				  System.out.println("Opening in CHROME Browser");
//				  driver = new ChromeDriver();
//				  break;
//			  case 2:
//				  System.out.println("Opening in EDGE Browser");
//				  driver = new EdgeDriver();
//				  break;
//			  case 3:
//				  System.out.println("Opening in FIREFOX Browser");
//				  driver = new FirefoxDriver();
//				  break;
//			  default:
//				  System.out.println("UNSUPPORTED BROWSER INPUT");
//			}
		
		
//		browsertype = browser;
//		if (browsertype.equalsIgnoreCase("chrome")) {
//			System.out.println("Opening in CHROME Browser");
//			driver = new ChromeDriver();
//		} else if (browser.equalsIgnoreCase("edge")) {
//			System.out.println("Opening in EDGE Browser");
//			driver = new EdgeDriver();
//		} else if (browser.equalsIgnoreCase("firefox")) {
//			System.out.println("Opening in FIREFOX Browser");
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("UNSUPPORTED BROWSER INPUT");
//		}
	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);		
		return driver;
	}
	//@AfterClass
	public static void driverTearDown() {
		driver.quit();
		System.out.println("Browser is CLOSED!");
	}
}


