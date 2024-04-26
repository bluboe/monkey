package com.Hack.pageObjects;


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

import com.Hack.utilities.excelData;

public class Bookshelves {
	
	public WebDriver driver;
	
	//constructor
	public Bookshelves(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//locators
	@FindBy(xpath="//a[normalize-space()='Close']")
		WebElement closePopUp;
	@FindBy(xpath="//*[@id='filters-form']/div[2]/div/label")
		WebElement excOutOfStock;
	@FindBy(xpath="//*[@id='filters-form']/div[1]/div/div/ul/li[2]")
		WebElement priceFilter;
	@FindBy(xpath="//*[@id='filters-form']/div[2]/div/label")
		WebElement excOutofStock;
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
		WebElement priceScrollRight;
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
		WebElement priceScrollLeft;
	@FindBy(xpath="(//div[@class='product-title product-title-sofa-mattresses'])[1]")
		WebElement p1Name;
	@FindBy(xpath="(//div[@class='product-title product-title-sofa-mattresses'])[2]")
		WebElement p2Name;
	@FindBy(xpath="(//div[@class='product-title product-title-sofa-mattresses'])[3]")
		WebElement p3Name;
	@FindBy(xpath="(//div[@class='price-number'])[1]")
		WebElement p1Price;
	@FindBy(xpath="(//div[@class='price-number'])[2]")
		WebElement p2Price;
	@FindBy(xpath="(//div[@class='price-number'])[3]")
		WebElement p3Price;
	@FindBy(xpath="//a[@href='/']")
		WebElement homeButton;
	List<String> productList = new ArrayList<String>();
	List<String> priceList= new ArrayList<String>();
	
	//Action Methods
	public void closePopUp() throws InterruptedException {
		try {
			Thread.sleep(4000);
			closePopUp.click();
			System.out.println("popup closed");			
		}catch(Exception e) {}
	}
	
	public void excludeOutOfStock() throws InterruptedException {
		Thread.sleep(3000);
		excOutofStock.click();
		System.out.println("out of stock clicked");
		if(excOutofStock.isSelected()==false) {
			System.out.println("selected");
		}
		Thread.sleep(1000);
	}
	
	public void priceFilter() throws InterruptedException {
		Actions ac= new Actions(driver);
		ac.moveToElement(priceFilter).perform();
		Thread.sleep(1500);
		//scroll right slider to 15000 (211pixels)

		ac.dragAndDropBy(priceScrollRight, -211, 0).perform();
		System.out.println("right scrolled");
		WebElement empty=driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
		ac.moveToElement(empty).perform();
		Thread.sleep(1000);
	}
	
	public List<String> printElements() throws InterruptedException, IOException {
		
		int i=3;
		for (int n=1; n<=3; n++) {
			Thread.sleep(1000);
			System.out.println("\nProduct "+ n);
			WebElement pname=driver.findElement(By.xpath("(//div[contains(@class,'product-title')])["+n+"]/span"));
			WebElement pPrice=driver.findElement(By.xpath("(//div[@class='price-number'])["+n+"]/span"));
			productList.add(pname.getText());
			priceList.add(pPrice.getText());
			
			List<String>page1= Arrays.asList("Product Name","Price");
			excelData.putData(productList, 0,"Bookshelves", page1);
			excelData.putData(priceList, 1,"Bookshelves", page1);
			
			System.out.println(" Product Name: "+pname.getText());
			System.out.println("  Price: "+pPrice.getText());
			//System.out.println(productList);
		}	
		return productList;
		
	}
	
	
	
	public void homePageButton() throws InterruptedException {
		Actions ac= new Actions(driver);
		ac.moveToElement(homeButton).perform();		
		homeButton.click();
	}
	
	
	
	
}
