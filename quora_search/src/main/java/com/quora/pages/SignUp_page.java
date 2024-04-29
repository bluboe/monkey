package com.quora.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp_page {
	
	public SignUp_page(WebDriver driver){
		this.driver=driver;
	}
	
	WebElement signUpWithEmail, email, nextButton, errorMsg;
	WebDriver driver;

	public void clickSignUpWithEmail() {
		//Click on “Sign up with email” link, on 'Sign Up' page/popup
		signUpWithEmail = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/div[2]/div/span/span[4]/div"));
		signUpWithEmail.click();
		System.out.println("\n" + "Clicked on “Sign up with email” link");
	}
	
	public void getNextButton() {
		//Verify if the “Next” button is disabled.

		System.out.println("  || Verifying 'Next' Button || ");
			//Get button name
		String nxtButton = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button/div/div/div")).getText();
		
			//Find button
		nextButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button"));
			
		  //Verify button status
		boolean chNextButton = nextButton.isEnabled();
		if (chNextButton == true) 
			{
				System.out.println(nxtButton + " button is enabled.");
			}else
			{
				System.out.println(nxtButton +" button is disabled.");
			}
	}
	
	public void getEmailField() {
		//Enter an invalid mail in Email field (ex: abc@abc)
		System.out.println("\n" + "Entered an invalid mail in Email field (ex: abc@abc)");
		email = driver.findElement(By.xpath("//*[@id='email']"));
		email.sendKeys("abc@abc");
	}
	
	public void getErrorMessage() {
		//Capture the respective error message shown.
		errorMsg = driver.findElement(By.xpath("//*[@id='form-field-error:19\']/div"));

		String errorMessageText = errorMsg.getText();
		System.out.println("Error message: " + errorMessageText);
	}
}
