package flipkart_sample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class flipkart_sample {
static int i=1;
	public static void main(String[] args) throws InterruptedException, IOException {
		//Online Shopping Automation**********************
				EdgeDriver driver=new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

				

				//Launch the browser 
				//Open the online shopping website URL e.g. https://www.flipkart.com/
				driver.get("https://www.flipkart.com/");
				driver.manage().window().maximize();
				
				
				//Check if the home page of the application is loaded.
				try{
					WebElement logo=driver.findElement(By.xpath("//img[@title='Flipkart']"));
					boolean present=logo.isDisplayed();
					if(present==true) {
						System.out.println("Website loaded");
					}
					else {
						System.out.println("Website not loaded");
					}
				}
				catch(NoSuchElementException e) {
					System.out.println("Website not loaded");
				}
				
				
				//In the search box enter the search criteria “Home appliances”.
				WebElement search=driver.findElement(By.name("q"));
				search.clear();
				search.sendKeys("Home appliances");
				driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']//*[name()='svg']")).click();
				System.out.println("HOME APPLIANCES SEARCHED");
				
				
				//Click on the first product and add to the cart.
				driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")).click();
				String win_title=" ";
				System.out.println("CLICKING ON THE FIRST PRODUCT");
				for(String CTab:driver.getWindowHandles()) {
	            	driver.switchTo().window(CTab);
	                win_title=driver.getTitle();
	            	System.out.println("CHANGING TABS");
	            	System.out.println(driver.getTitle());
	            	System.out.println(win_title);

	            }
				String Product_1=driver.findElement(By.cssSelector("div._30jeq3._16Jk6d")).getText();
				System.out.println(Product_1);
				JavascriptExecutor js=driver;
				WebElement addtocart=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
				js.executeScript("arguments[0].scrollIntoView();", addtocart);
                addtocart.click();
				System.out.println("ADDED TO CART");
//				TakesScreenshot ts=driver;
//				File src=ts.getScreenshotAs(OutputType.FILE);
//				File trg=new File("C:\\Users\\2327170\\eclipse-workspace\\flipkart_sample\\screenshots");
//				FileUtils.copyFile(src, trg);

								
				//Display the order amount in console.
				WebElement order_amount=driver.findElement(By.className("z4Ha90"));
				System.out.println("THE ORDER AMOUNT IS: "+order_amount.getText());
				
				
				
				//Close the new tab and go back to Home appliances page again.
				Thread.sleep(5000);
				for(String Tab:driver.getWindowHandles()) {
					driver.switchTo().window(Tab);
					System.out.println("CHANGING TABS");
	            	System.out.println(driver.getTitle());
	            	if(driver.getTitle().equals("Shopping Cart | Flipkart.com")) {
	            		driver.close();
	            	}
				}
				
				
				
				//Add one more item to the cart.
				System.out.println("BACK TO HOME APPLIANCES PAGE");
				for(String Tab:driver.getWindowHandles()) {
					driver.switchTo().window(Tab);
					System.out.println("CHANGING TABS");
            	    System.out.println(driver.getTitle());
			}
				driver.findElement(By.xpath("//body/div[@id='container']/div/div[@class='_36fx1h _6t1WkM _3HqJxg']/div[@class='_1YokD2 _2GoDe3']/div[@class='_1YokD2 _3Mn1Gg']/div[2]/div[1]/div[2]/div[1]/a[2]")).click();
				System.out.println("SECOND PRODUCT CLICKED");
				for(String Tab:driver.getWindowHandles()) {
					driver.switchTo().window(Tab);
					System.out.println("CHANGING TABS");
            	    System.out.println(driver.getTitle());
			}
				String Product_2=driver.findElement(By.cssSelector("div._30jeq3._16Jk6d")).getText();
				System.out.println(Product_2);
				JavascriptExecutor jis=driver;
				WebElement add_tocart=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
				jis.executeScript("arguments[0].scrollIntoView()", add_tocart);
				add_tocart.click();
//				TakesScreenshot ts2=driver;
//				File src2=ts2.getScreenshotAs(OutputType.FILE);
//				File trg2=new File("C:\\Users\\2327170\\eclipse-workspace\\flipkart_sample\\screenshots\\steps"+i+".jpeg");
//				i++;
//				FileUtils.copyFile(src2, trg2);
				
				
				//Display the revised Total order amount in the console.
				String amount=driver.findElement(By.cssSelector("div[class='Ob17DV _3X7Jj1'] span")).getText();
				System.out.println("AMOUNT AFTER ADDING SECOND PRODUCT IS: "+amount);
				
				
				
				//Validate if the amount is properly calculated.
				try {
					String[] array_1=Product_1.split("₹");
					String[] array_2=Product_2.split("₹");
					String[] array_3=array_1[1].split(",");
					String[] array_4=array_2[1].split(",");
					String p1=array_3[0]+array_3[1];
					String p2=array_4[0]+array_4[1];
					int Final_amount_product_1=Integer.parseInt(p1);
					int Final_amount_product_2=Integer.parseInt(p2);
					int Total_Expected_Amount=Final_amount_product_1+Final_amount_product_2;
					
					String[] array_5=amount.split("₹");
					String[] array_6=array_5[1].split(",");
					String p3=array_6[0]+array_6[1];
					int Total_Amount=Integer.parseInt(p3);
					if(Total_Expected_Amount==Total_Amount)
						{
							System.out.println("THE AMOUNT CALCULATION IS CORRECT");
						}
						else {
							System.out.println("THE AMOUNT CALCULATION IS INCORRECT");
	
						}
					
				}
				catch(ArrayIndexOutOfBoundsException e) {
					e.getMessage();
					
				}
						
				
				
				
				//Close the browser
				Thread.sleep(3000);
				driver.quit();
				System.out.println("BROWSER CLOSED");
				
			

	}

}
