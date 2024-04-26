package com.Hack.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Hack.utilities.excelData;

public class UlCollections {

	
	public WebDriver driver;
	
	//constructor
	public UlCollections(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//locators
	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement closePopUp;
	@FindBy(xpath="//li[@data-group='category']")
	WebElement category;
	@FindBy(xpath="//ul[@class='clearfix options']/li")
	List<WebElement> subMenu;
	List<String> UCList = new ArrayList<String>();
	
	
	
	//Action Methods
	public void closePopUp() throws InterruptedException {
		try {
			Thread.sleep(3000);
			closePopUp.click();
			System.out.println("Popup closed");			
		}catch(Exception e) {}
	}
	public void hoverCategory() throws InterruptedException {
		//System.out.println("hover method entered");
		Actions ac= new Actions(driver);
		ac.moveToElement(category).perform();
		//System.out.println("performed hover");
		Thread.sleep(1500);
	}
	
	public void getSubMenu() throws IOException {
		System.out.println("\n/******Printing Categories sub-menu******/");
		for(int i =0;i<subMenu.size();i++) {
			
		String submenu= subMenu.get(i).getText();
		
		UCList.add(submenu);
		
		List<String> page2=Arrays.asList("Categories");
		excelData.putData(UCList, 0, "UCCategories", page2);
		System.out.println(submenu);
	}
	
	}

}
