package page_object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utilities.ExcelUtils;
import utilities.excelData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftVouchar {
	WebDriver driver;
	Actions action;
	@FindBy(xpath="//a[@title='https://www.yatra.com']//i[@class='ico-newHeaderLogo']")
	WebElement logo;
	
	
	@FindBy(xpath="//span[text()='+ More']")
	WebElement more1;
	
	@FindBy(xpath=" //li[@class='list-more-tab']//a[@id='booking_engine_gift_voucher']")
	WebElement gift;
	@FindBy(css="input[value='Submit']")
	WebElement submit;
	@FindBy(id="Name")
	WebElement name;
	@FindBy(id="phone")
	WebElement number;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="corporateName")
	WebElement corporate;
	@FindBy(id="query")
	WebElement query;
	@FindBy(css="#profession_title")
	WebElement dropTitle;
	List<String> list=new ArrayList<>();
	
	public GiftVouchar(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action= new Actions(driver);
		
	}
	
	//NAVIGATE BACK TO HOMEPAGE
	public void homepage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
//		action.scrollToElement(logo).build().perform();
//		logo.click();
	}
	
	public void more() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Waited 5 seconds");
		try {
			action.moveToElement(more1).build().perform();
		}catch(Exception e) {
			
		}
		System.out.println("moved over the element");
//		more1.click();
		
	}
	public void gift() throws InterruptedException {
		Thread.sleep(5000);
//		action.moveToElement(gift).build().perform();
		Thread.sleep(3000);
		gift.click();
	}
	public void navigate() throws InterruptedException {
		Thread.sleep(3000);
		for(String Tab:driver.getWindowHandles())
		{
			driver.switchTo().window(Tab);
			System.out.println(driver.getTitle()); 
		}
	}
	public void scroll() {
		action.scrollToElement(submit).perform();
	}
	public void formPhoneNumber() throws InterruptedException {
		
		name.click();
		name.sendKeys("aarushi");
		number.click();
		number.sendKeys("987027177");
		email.click();
		email.sendKeys("aarushi@gmail.com");
		corporate.click();
		corporate.sendKeys("Cognizant");
		query.click();
		query.sendKeys("anything");
		action.moveToElement(dropTitle).perform();
		dropTitle.click();
		Thread.sleep(1000);
		String select="Loyalty Program";
		WebElement dropReq1=driver.findElement(By.xpath("//span[contains(text(),'"+ select +"')]"));
		action.moveToElement(dropReq1).perform();
		Thread.sleep(1000);
		dropReq1.click();
		submit.click();
        String phoneerr = number.getAttribute("data-errormsg");
		System.out.println("Phone number error message : " + phoneerr);
		list.add(phoneerr);
	}
	public void formEmail() throws InterruptedException, IOException {
		action.scrollToElement(submit).perform();
		name.click();
		name.sendKeys("aarushi");
		number.click();
		number.sendKeys("9870271771");
		email.click();
		email.sendKeys("aarushi.gmail.com");
		corporate.click();
		corporate.sendKeys("Cognizant");
		query.click();
		query.sendKeys("anything");
		action.moveToElement(dropTitle).perform();
		dropTitle.click();
		Thread.sleep(1000);
		String select="Loyalty Program";
		WebElement dropReq1=driver.findElement(By.xpath("//span[contains(text(),'"+ select +"')]"));
		action.moveToElement(dropReq1).perform();
		Thread.sleep(1000);
		dropReq1.click();
		submit.click();
		String capturetooltip = email.getAttribute("data-errormsg");
		System.out.println("Email error message : " + capturetooltip);
		list.add(capturetooltip);
		
		List<String>page3=Arrays.asList("Error Message on Gift Vouchers");
		excelData.putData(list, 0, "Error Msgs", page3);
//		ExcelUtils.putData(list,"Error Message");
	}

}
