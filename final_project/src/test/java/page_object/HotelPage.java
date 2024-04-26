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

public class HotelPage {
	WebDriver driver;
	Actions action;
	List<String> act=new ArrayList<>();
	//int i=0;
	@FindBy(xpath="//*[@id=\"mega-filter-open-close-price\"]/div/div/div/div/div[1]/div/ul/li[5]")
	WebElement star;
	@FindBy(xpath="//body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]")
	WebElement elements;
	@FindBy(xpath="//label[@class='filter-label ng-binding']")
	List<WebElement> list1;
	@FindBy(xpath="//span[text()='Amenities']")
	WebElement element;
	@FindBy(xpath="//label[@class='filter-label ng-binding']")
	List<WebElement> list;	
	List<String> hotelName=new ArrayList<String>();
	List<String> hotelPrice=new ArrayList<String>();

	public HotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		
	}
	
	//CLICKING 5 STAR
	public void rating() throws InterruptedException {
		star.click();
		Thread.sleep(2000);
	}
	
	
	public void amenities() throws InterruptedException {
		//WebElement elements=driver.findElement(By.xpath("//body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]"));
		action.moveToElement(elements).perform();
		System.out.println(elements.getText() + "\n");
		Thread.sleep(1500);
		//System.out.println("1");
		/*xpath for elements
		 * for all clickable class-(remove <ul> for enclosing tag-- //body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]
		 * without label, its the same without clicable element-//body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li["+i+"]/label
		 */
		String req1="Free WiFi";
		String req2="Free Breakfast";
		String req3="Laundry facilities";
		String req4="Poolside Bar";
		//System.out.println("2");
		
		//*******by creating list *************/
		//List<WebElement> list1=driver.findElements(By.xpath("//label[@class='filter-label ng-binding']"));
		try {
			for(WebElement click:list1) {
				String actual=click.getText();
				//System.out.println(actual);
				if(actual.contains(req1)) {
					System.out.println(req1+" found");
					click.click();
					
				}
				else if(actual.contains(req2)) {
					System.out.println(req2+" found");
					click.click();	
				}
			}
			
		}catch(Exception e) {
			System.out.println("Exception in Facilities");
		}
		
		
		Thread.sleep(2000);
		//WebElement element=driver.findElement(By.xpath("(//div)[138]"));
		action.moveToElement(element).perform();
		//List<WebElement> list=driver.findElements(By.xpath("//label[@class='filter-label ng-binding']"));
		try {
			for(WebElement click:list) {
				String actual=click.getText();
				//System.out.println(actual);
				if(actual.contains(req3)) {
					System.out.println(req3+" found");
					click.click();
					
				}
				else if(actual.contains(req4)) {
					System.out.println(req4+" found");
					click.click();	
				}
			}
			
		}catch(Exception e) {
			System.out.println("Exception in Aminities");
		}
		
	}
	
	//PRINTING HOTEL DETAILS
	public void printingHotelDetails() throws InterruptedException, IOException {
		Thread.sleep(5000);
		for(int i=0; i<=2; i++) {
			//System.out.println("'for' loop starts \n");
			try 
			{	
				//System.out.println("try starts" +i);			
				WebElement facility=driver.findElement(By.xpath("//div[@id='result"+i+"']//div[@class='result-details-wrapper full']/div[1]/div[1]/h2"));
				System.out.println(facility.getText());
				//act.add(facility.getText());
				//System.out.println(act);
				hotelName.add(facility.getText());
				
				WebElement facilityPrice=driver.findElement(By.xpath("(//div[@id='result"+i+"']//p[@class='hotel-price-value hand'])[2]/span[1]/span[2]"));
				System.out.println(facilityPrice.getText());	
				hotelPrice.add(facilityPrice.getText());
				
			}catch(Exception e) {
				System.out.println("No more Hotels in list");
			}
			List<String>page1=Arrays.asList("Hotel Name", "Price");
			excelData.putData(hotelName, 0, "Hotels", page1);
			excelData.putData(hotelPrice, 1, "Hotels", page1);
			
		}
		
		Thread.sleep(3000);
		//ExcelUtils.putData(act, "Hotel Details");
	}
	
	
}
//*[@id="result3"]/div[1]/div[2]/ul/li[3]/div[2]/p/span/span[2]
//*[@id="result6"]/div[2]/div[2]/ul/li[3]/div[2]/p/span/span[2]
//div[@id='result0']//div[@class='result-details-wrapper full']/div[1]/div[1]/h2
//div[@id='result3']//div[@class='result-details-wrapper full']/div[2]/ul[1]/
//    (//div[@id='result0']//li[@class='full hotel-price tipsy-holder'])[2]
//    (//div[@id='result0']//p[@class='hotel-price-value hand'])[2]/span[1]/span[2]
