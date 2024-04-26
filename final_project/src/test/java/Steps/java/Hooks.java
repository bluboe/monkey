package Steps.java;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetUp;

public class Hooks {
	WebDriver driver;
	 Properties prop;
    
	@Before
   public void setup() throws IOException
   {
		prop= BaseClass.getProperties();
		driver= BaseClass.initializeBrowser(prop.getProperty("Browser"));
		driver.get(prop.getProperty("url"));
	}
		
   
   @After
   public void tearDown(Scenario scenario) {
       		
      driver.quit();
      
   }
   

   @AfterStep
   public void addScreenshot(Scenario scenario) {
       
	   TakesScreenshot ts = (TakesScreenshot) driver;
       byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

       // Get the step name
       String stepName = scenario.getName();
       stepName = stepName.replaceAll("[^a-zA-Z0-9]", "");

       // Save the screenshot with the step name
       if (scenario.isFailed()) {
           scenario.attach(screenshot, "image/png", stepName + "_Failure");
       } else {
           scenario.attach(screenshot,"image/png", stepName + "_Success");
       }
     
   }

}
