package page_object;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Actions action;
	@FindBy(css="body > div:nth-child(2) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2)")
	WebElement hotel;
	@FindBy(xpath="//input[@id='BE_hotel_destination_city']")
	WebElement searchDestination;
	@FindBy(id="BE_hotel_checkin_date")
	WebElement checkin;
	@FindBy(xpath="//*[@id=\"BE_Hotel_pax_info\"]/i")
	WebElement arrowGuest;
	@FindBy(xpath="(//span[@class='ddSpinnerPlus'])[1]")
	WebElement guests;
	@FindBy(id="BE_hotel_htsearch_btn")
	WebElement searchHotel;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		
	}
	
	
	//CLICKING HOTELS
	public void clickingHotel() throws InterruptedException {
		hotel.click();
		Thread.sleep(3000);
	}
	
	//SEARCHING FOR A DESTINATION
	public void searchForDestination() throws InterruptedException {
		//WebElement search=driver.findElement(By.xpath("//input[@id='BE_hotel_destination_city']"));
		searchDestination.click();
		Thread.sleep(1000);
		searchDestination.sendKeys("Delhi");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	
	//ADD THE DESIRED DATE
	public void date() throws InterruptedException {
		checkin.click();
		Thread.sleep(2000);
		LocalDate checkindate=LocalDate.now().plusDays(1);
		String Formatter1=checkindate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(Formatter1);
		WebElement startdate=driver.findElement(By.id(Formatter1));
		Thread.sleep(1000);
		action.moveToElement(startdate).click().perform();
		Thread.sleep(1000);
		LocalDate checkoutdate=LocalDate.now().plusDays(5);
		String Formatter2=checkoutdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(Formatter2);
		WebElement enddate=driver.findElement(By.id(Formatter2));
		Thread.sleep(1000);
		action.moveToElement(enddate).click().perform();
	}
	
	
	//ADD NO OF GUESTS
	public void guest() throws InterruptedException {
		arrowGuest.click();
		//WebElement guests=driver.findElement(By.xpath("(//span[@class='ddSpinnerPlus'])[1]"));
		Thread.sleep(800);
		action.doubleClick(guests).perform();
	}
	
	
	//CLICK ONTO SEARCH
	public void search() throws InterruptedException {
		searchHotel.click();
		Thread.sleep(10000);
	}

}
