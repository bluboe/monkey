package page_object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtils;
import utilities.excelData;

public class Cruise {
	WebDriver driver;
	Actions action;
	@FindBy(xpath="//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']")
	WebElement yatra;
	@FindBy(xpath="//span[text()='+ More']")
	WebElement more;
	@FindBy(xpath="//span[@class='demo-icon icon-cruise']")
	WebElement cruise;
	@FindBy(xpath="(//span)[49]")
	WebElement inclusion;
	@FindBy(xpath="(//ul)[15]/li")
	List<WebElement> inclusions;
	@FindBy(xpath="//*[@id=\"booking_engine_modues\"]/div/ul/li[1]/a")
	WebElement clickable;
	List<String>list=new ArrayList<>();
	
	
	public Cruise(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action= new Actions(driver);
		
	}
	
	
	//COMING BACK TO THE STARTING PAGE
    public void homepage() {
		yatra.click();
	}
    
    
  //CLICKING ON MORE
    public void more() throws InterruptedException {
    	Thread.sleep(2000);
		action.moveToElement(more).perform();
    }
    public void cruise() throws InterruptedException {
    	Thread.sleep(2000);
    	cruise.click();
    }
    public void cruiseLine() throws InterruptedException {
    	Thread.sleep(2000);
    	clickable.click();
    }
    
    public void cruiseDetails() throws InterruptedException, IOException {
    	Thread.sleep(2000);
		action.scrollToElement(inclusion).perform();
		
		System.out.println("\nINCLUSIONS");
		for(int i=1; i<=inclusions.size(); i++) {
			WebElement incItem=driver.findElement(By.xpath("(//ul)[15]/li["+i+"]"));
			list.add(incItem.getText());
			System.out.println(incItem.getText());
		}
		List<String>page2=Arrays.asList("Inclusions :");
		excelData.putData(list, 0, "Cruise", page2);
    }

}
