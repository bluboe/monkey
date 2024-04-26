package com.Hack.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Hack.utilities.excelData;

public class GiftCards {

	public WebDriver driver;
	
	//constructor
	public GiftCards(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//locators
	@FindBy(xpath="//li[@class='_11b4v'][3]")
		WebElement bDay;
	@FindBy(xpath="//input[@id='ip_2251506436']")
		WebElement amount;
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")
		WebElement month;
	@FindBy(xpath="(//select[@class='Upz18 _1hLiD UJU2v'])[2]")
		WebElement date;
	@FindBy(css="button[class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")
		WebElement nextButton;
	@FindBy(css="#ip_4036288348")
		WebElement recName;
	@FindBy(css="#ip_137656023")
		WebElement recEmail;
	@FindBy(css="#ip_3177473671")
		WebElement recMobile;
	@FindBy(css="#ip_1082986083")
		WebElement yourName;
	@FindBy(css="#ip_4081352456")
		WebElement yourEmail;
	@FindBy(css="#ip_2121573464")
		WebElement yourMobile;
	@FindBy(css="#ip_2194351474")
		WebElement addressField;
	@FindBy(css="#ip_567727260")
		WebElement pincodeField;
	@FindBy(xpath="//*[@id='app-container']/div/main/section/section[3]/form/button")
		WebElement confirmButton;
	@FindBy(xpath="//button[@class='_3NxK9 _1fVSi action-button _1gIUf _1XfDi']")
		WebElement paymentButton;
	List<String> errors = new ArrayList<String>();
	
	
	//Action Methods
	public void bDayAnni() throws InterruptedException {
		Actions ac= new Actions(driver);
		ac.moveToElement(bDay).perform();
		Thread.sleep(500);
		bDay.click();
	}
	
	public void customise() {
		//Enter amount
		amount.sendKeys("3000");
		System.out.println("/****Amount Entered ****/");
		
		//select Month
//		Actions ac=new Actions(driver);
//		ac.moveToElement(month).click().perform();
		
		Select select=new Select(month);
		select.selectByValue("5/2024");
		
		
		//select date
		Select select1=new Select(date);
		select1.selectByValue("19");
		System.out.println("/****Month and Date selected ****/");
	}
	
	public void clickNextButton() {
		nextButton.click();
		System.out.println("/**** Next Button Clicked****/");
	}
	
	public void fillDetails() throws InterruptedException {
		recName.sendKeys("Aarushi");
		recEmail.sendKeys("ra@gm");
		recMobile.sendKeys("9909090909");
		yourName.sendKeys("Ravi");
		yourEmail.sendKeys("dakd@g");
		yourMobile.sendKeys("9909393939");
		addressField.sendKeys("home");
		pincodeField.sendKeys("110001");
		System.out.println("/**** Details Filled****/");
		Thread.sleep(2000);

	}
	
	public void clickConfirm() {
		if(confirmButton.isEnabled()) {
			System.out.println("'Confirm' Button is clickable");
			confirmButton.click();
			System.out.println("/****Clicked 'Confirm' Button ****/");
		}
		else {
			System.out.println("\n'Confirm' Button is NOT clickable");
		}
	}
	
	public void clickPayment() throws InterruptedException {
		Thread.sleep(2000);
		paymentButton.click();
		//System.out.println("clicked on Payment");
		//catchErrorOnPayment();	
		Thread.sleep(1500);
	}
	
	public void catchErrorOnPayment() {
		for(int n=1; n<3; n++) {
			try {
				WebElement errMsg=driver.findElement(By.cssSelector("section[class='_14QEd _1QpDs'] li:nth-child("+n+")"));
				String errorMessage=errMsg.getText();
				errors.add(errorMessage);
				
				List<String>page3 = Arrays.asList("Error Messages");
				excelData.putData(errors, 0,"Error Message", page3);
				System.out.println("Error Message "+n+": "+ errMsg.getText());
			}
			catch(Exception e){
				System.out.println("\n/****All Error Messages Captured****/");
				break;
			}
		}
		
	}

	
}







