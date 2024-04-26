package utilities;
 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class DriverSetUp {
	public static WebDriver driver;	
	// Url to go for is stored in a string
	public static String url = "https://www.yatra.com/";
	public static String browsertype;
	public static String filepath = ".\\Test_Results\\";
	public String captureScreen(String tname) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+filepath + tname +".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
 
	}
	public static WebDriver driverInstantiate(String browser) throws InterruptedException {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		System.out.println("Browser is started successfully.");
		//Maximizing the Browser.
		driver.manage().window().maximize();	
		//Implicitly Wait is initiated.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Thread.sleep(20000);
		return driver;
	}
	// Driver Quit method is defined to quit the browser.
	public static void driverClose() {
		driver.quit();
		System.out.println("Browser Closed.");
	}
 
 
}