package com.quora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page {
	

	
	public Landing_Page(WebDriver driver){
		this.driver=driver;
	}
	
	WebElement credandhead, livedIn, contentViewsTotal, contentViewsMonth, activeIn, dateJoin, spacesHead, viewMore, spaces, signInButton;
	WebDriver driver;
	
	public void verifyTitle() {
		//Verify the title “Quora” is present or not on the webpage
		String expTitle = "Quora";
		String actTitle = driver.getTitle();
		System.out.println("  || VERIFYING TITLE ||  ");
		
		if (actTitle.contains(expTitle))
		{
			if (actTitle.equals(expTitle))
			{
				System.out.println("Test for Title is PASSED. \nTitle is an exact match. \n");
			}
			else 
			{
			System.out.println("Test for Title is PASSED. \nTitle contains expected values, but is not an exact match. \n");
			}
		}
		else {
			System.out.println("Test for Title FAILED \n");
		}
	}
	
	public void getCredAndHigh() {
		//Print Heading of “Credentials & Highlights” section
		System.out.println("  || CREDENTIAL SECTION || ");
		credandhead = driver.findElement(By.xpath("//div[text()='Credentials & Highlights']"));
		String cred = credandhead.getText();
		System.out.println(cred);
	}
	
	public void getLivedIn() {
		//Print Address deatials in “Credentials & Highlights” section
		livedIn = driver.findElement(By.xpath("//span[contains(text(),'Lived in ')]"));
		String livedin = livedIn.getText();
		System.out.println(" " + livedin);
	}
	
	public void getContentViews() {
		//Print Content Views in the “Credentials & Highlights” section
		// Total views first
		contentViewsTotal= driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span[1]"));
		String contV = contentViewsTotal.getText();
		//System.out.println(" " + contV);
		
		//Monthly views
		contentViewsMonth = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/span[2]"));
		String contVM = contentViewsMonth.getText();
		//System.out.println(" " + contVM);
		System.out.println(" " + contV +" : "  + contVM);
	}
	
	
	public void getActiveIn() {
		//Print Activity in the “Credentials & Highlights” section
		activeIn = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[3]/div[2]/span"));
		String act = activeIn.getText();
		System.out.println(" " + act);
	}
	
	public void getDateJoin() {
		//Print Joining Time in the “Credentials & Highlights” section
		dateJoin = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/span"));
		String dJoin = dateJoin.getText();
		System.out.println(" " + dJoin);
	}
	
	public void getSpaces() {
		//Print Content Views in the “Credentials & Highlights” section
		spacesHead = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[2]/div/div/div"));
		String space = spacesHead.getText();
		System.out.println("\n || PRINT SPACES CONTENT ||");
		System.out.println(space);
	}
	
	public void clickViewMoreButton() throws InterruptedException {
		/*Scroll down and in the section “Spaces” 
		 * and open the Spaces list by click
		 * print all the detail list displayed screen*/
		viewMore = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div/div[6]/div/div/div/div/button"));
		Thread.sleep(500);
		
		int n=1;
		while (n==1)
		{
			try 
				{				
				//Scroll down to 'View More'
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",viewMore); 
				//System.out.println("Scrolled");	//Print scrolled
				Thread.sleep(2000);
				
				//Click 'View More'
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", viewMore);
				Thread.sleep(2000);
				//Print 'Scrolled and Clicked
				System.out.println("   Scrolled And Clicked 'View More'");
				}
			catch(StaleElementReferenceException e) 
				{
				n=2;
				}
		}
		
	}
	
	public void getSpacesElement() {
		/*In the section “Spaces” print all the detail list displayed screen*/
		spaces = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[3]/div/div[2]/div/div[3]/div"));
		String spaceContent = spaces.getText();
		System.out.println(spaceContent);
				
	}
	
	public void clickSignIn() {
		//Click on “sign In” link
		signInButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/div/button/div/div/div"));
		signInButton.click();
		System.out.println("\n" + "Click on “Sign In” link");
	}
	


}
