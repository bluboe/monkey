package com.quora.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class DriverSetup {
	public static WebDriver driver;
	public static String url ="https://www.quora.com/profile/Quora";
	public static String browsertype;
	
	public static WebDriver driverInstantiate(String browser) 
	{
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			System.out.println("Opening in CHROME Browser");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Opening in EDGE Browser");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Opening in FIREFOX Browser");
			driver = new FirefoxDriver();
		} else {
			System.out.println("UNSUPPORTED BROWSER INPUT");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);		
		return driver;
	}
	
	public static void driverTearDown() {
		driver.quit();
		System.out.println("Browser is CLOSED!");
	}
}
