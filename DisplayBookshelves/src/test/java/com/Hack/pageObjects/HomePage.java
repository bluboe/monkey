package com.Hack.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class HomePage {
	
	public WebDriver driver;
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//locators
	@FindBy(id="search")
		WebElement searchBox;
	//@FindBy(xpath="//input[@id='search']") WebElement searchBox;
	@FindBy(id="search_button")
		WebElement searchButton;
	@FindBy(css="li[class='topnav_item trendingunit'] span[class='topnav_itemname']")
		WebElement trendingOpt;
	@FindBy(xpath="//a[normalize-space()='UL Collections']")
		WebElement ulCollections;
	@FindBy(xpath="//*[@id='header']/section/div/ul[2]/li[3]/a")
		WebElement giftCard;
		
	
	
	//Action Methods
	public void enterSearchBox() throws InterruptedException {
		searchBox.sendKeys("Bookshelves");
		System.out.println("Entered 'Bookshelves' in SearchBox");
	}
	
	public void clickSearchButton() {
		searchButton.click();
		System.out.println("Clicked search Button");
	}
	
	public void hoverTrending() throws InterruptedException {
		Actions ac= new Actions(driver);
		ac.moveToElement(trendingOpt).perform();
		Thread.sleep(1500);
	}
	
	public void clickULCollections() {
		ulCollections.click();
	}
	
	public void clickGiftCard() {
		giftCard.click();
		
	}
	
	
	
}
