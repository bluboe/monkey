package linear_code;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class sample_class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		Actions action=new Actions(driver);
		
		//OPENING URL
		driver.get("https://www.yatra.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//CLICKING HOTELS
		driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2)")).click();
		Thread.sleep(3000);
		
		
		//SEARCHING FOR A DESTINATION
		WebElement search=driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']"));
		search.click();
		Thread.sleep(1000);
		search.sendKeys("Goa");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
//		System.out.println("done");
		
		
		//ADD THE DESIRED DATE
		driver.findElement(By.id("BE_hotel_checkin_date")).click();
		Thread.sleep(2000);
		LocalDate checkindate=LocalDate.now().plusDays(1);
		String Formatter1=checkindate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		WebElement startdate=driver.findElement(By.id(Formatter1));
		Thread.sleep(1000);
		action.moveToElement(startdate).click().perform();
		Thread.sleep(1000);
		LocalDate checkoutdate=LocalDate.now().plusDays(5);
		String Formatter2=checkoutdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		WebElement enddate=driver.findElement(By.id(Formatter2));
		Thread.sleep(1000);
		action.moveToElement(enddate).click().perform();
	
		
		//ADD NO OF GUESTS
		driver.findElement(By.xpath("//*[@id=\"BE_Hotel_pax_info\"]/i")).click();
		WebElement guests=driver.findElement(By.xpath("(//span[@class='ddSpinnerPlus'])[1]"));
		Thread.sleep(800);
		action.doubleClick(guests).perform();
//		System.out.println("done");
		
		//CLICK ONTO SEARCH
		driver.findElement(By.id("BE_hotel_htsearch_btn")).click();
		Thread.sleep(10000);
		
        
		//CLICKING 5 STAR
				driver.findElement(By.xpath("//*[@id=\"mega-filter-open-close-price\"]/div/div/div/div/div[1]/div/ul/li[5]")).click();
				Thread.sleep(2000);
				
				//CHOOSING AMENITIES
				WebElement elements=driver.findElement(By.xpath("//body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]"));
				action.moveToElement(elements).perform();
				System.out.println(elements.getText() + "\n");
				Thread.sleep(1500);
				
				/*xpath for elements
				 * for all clicable class-(remove <ul> for enclosing tag-- //body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]
				 * without label, its the same without clicable element-//body[1]/div[2]/section[1]/div[1]/div[1]/aside[2]/div[1]/div[2]/div[9]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li["+i+"]/label
				 */
				String req1="Free WiFi";
				String req2="Free Breakfast";
				String req3="Laundry facilities";
				String req4="Poolside Bar";
				//*******by creating list *************/
				List<WebElement> list1=driver.findElements(By.xpath("//label[@class='filter-label ng-binding']"));
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
				Thread.sleep(2000);
				WebElement element=driver.findElement(By.xpath("(//div)[138]"));
				action.moveToElement(element).perform();
				List<WebElement> list=driver.findElements(By.xpath("//label[@class='filter-label ng-binding']"));
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

				
				//PRINTING HOTEL DETAILS
				for(int i=0; i<=2; i++) {
					//System.out.println("'for' loop starts \n");
					try 
					{	
						//System.out.println("try starts" +i);
						WebElement facility=driver.findElement(By.xpath("//*[@id='result"+i+"']/div[1]/div[1]/div[1]/h2/a"));
						String act=facility.getText();
						//text for .getText() is inside label, for enable status get inside 'span'
						
						System.out.println(act);
									
						
					}catch(Exception e) {
						System.out.println("No element");
					}
				}
				
				Thread.sleep(3000);
				
				
				//COMING BACK TO THE STARTING PAGE
				driver.findElement(By.xpath("//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']")).click();
				
				
				//CLICKING ON CRUISE
				Thread.sleep(2000);
				WebElement more=driver.findElement(By.xpath("//span[text()='+ More']"));
				action.moveToElement(more).perform();
				WebElement cruise=driver.findElement(By.xpath("//span[@class='demo-icon icon-cruise']"));
				cruise.click();
				driver.findElement(By.xpath("//*[@id=\"booking_engine_modues\"]/div/ul/li[1]/a")).click();
				Thread.sleep(2000);
				WebElement inclusion=driver.findElement(By.xpath("(//span)[49]"));
				action.scrollToElement(inclusion).perform();
				System.out.println(inclusion.getText());
				
				//NAVIGATE BACK TO HOMEPAGE
				Thread.sleep(2000);
				WebElement logo=driver.findElement(By.cssSelector(".logo"));
				action.scrollToElement(logo).perform();
				logo.click();
				
				//CLICKING ON VOUCHAR
				Thread.sleep(3000);
				WebElement more1=driver.findElement(By.xpath("//span[text()='+ More']"));
				action.moveToElement(more1).perform();
				WebElement gift=driver.findElement(By.xpath("//span[normalize-space()='Gift Voucher']"));
				gift.click();
				for(String Tab:driver.getWindowHandles())
				{
					driver.switchTo().window(Tab);
					System.out.println(driver.getTitle()); 
				}
				WebElement submit=driver.findElement(By.cssSelector("input[value='Submit']"));
				action.scrollToElement(submit).perform();
				WebElement name=driver.findElement(By.id("Name"));
				name.click();
				name.sendKeys("aarushi");
				WebElement number=driver.findElement(By.id("phone"));
				number.click();
				number.sendKeys("987027177");
				WebElement email=driver.findElement(By.id("email"));
				email.click();
				email.sendKeys("aarushi.gmail.com");
				WebElement corporate=driver.findElement(By.id("corporateName"));
				corporate.click();
				corporate.sendKeys("Cognizant");
				WebElement query=driver.findElement(By.id("query"));
				query.click();
				query.sendKeys("anything");
//				WebElement gifting=driver.findElement(By.id("profession_title"));
//				action.moveToElement(gifting).click().perform();
//				Thread.sleep(1000);
//				WebElement other=driver.findElement(By.xpath("///li[@class='enabled _msddli_ hover selected']//span[@class='ddlabel'][normalize-space()='Employee Rewards & Recognition']"));
//				Select dropdown= new Select(other);
//				dropdown.selectByValue("Employee Rewards & Recognition");
//				//action.moveToElement(other).click().perform();
				WebElement dropTitle=driver.findElement(By.cssSelector("#profession_title"));
				action.moveToElement(dropTitle).perform();
				dropTitle.click();
				Thread.sleep(1000);
				String select="Loyalty Program";
				WebElement dropReq1=driver.findElement(By.xpath("//span[contains(text(),'"+ select +"')]"));
				action.moveToElement(dropReq1).perform();
				Thread.sleep(1000);
				dropReq1.click();
				submit.click();
  
  
			}
		
	}


