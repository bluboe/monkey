package com.Hack.utilities;

import java.io.File;
import java.io.IOException; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
 
public class ScreenShot {
	static WebDriver driver;
	static int i=1;
 
 
	public static void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile;
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File(System.getProperty("user.dir") + "\\Screenshot\\Snap"+i+".png"));
		System.out.println("SCREENSHOT CAPTURED! Snap" + i + "\n");
		i++;
	}
 
}
