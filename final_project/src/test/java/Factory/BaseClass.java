package Factory;
import java.io.FileReader;

import java.io.IOException;

import java.time.Duration;

import java.util.Properties;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
 
public class BaseClass{

	static Properties prop; 

	public static WebDriver driver;

	public static WebDriver initializeBrowser(String browser) throws IOException {


		if(browser.equalsIgnoreCase("Chrome")) 

		{

	        driver=new ChromeDriver();

		}

		else if(browser.equalsIgnoreCase("Edge")) 

		{

	        driver=new EdgeDriver();

		}

		else 

		{

	        System.out.println("No matching browser");

	    }

           driver.manage().window().maximize();	

           driver.manage().deleteAllCookies(); 

           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            return driver;


	}

	public static WebDriver getDriver() {

		return driver;

	}


	public static Properties getProperties() throws IOException {

		  prop = new Properties();

		  FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");

		  prop.load(file);

		  return prop;


	}


}