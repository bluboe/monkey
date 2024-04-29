package flipkart_mini_project;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class flipkart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Opening the website==
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("https://www.flipkart.com/")) {
                System.out.println("Home Page Loaded");
            }else {
            	System.out.println("Home Page Not Loaded");
            }
            // Search for "Home appliances"
            driver.findElement(By.name("q")).sendKeys("Home appliances");
            driver.findElement(By.className("_2iLD__")).click();
            System.out.println("Searched for 'Home appliances'");
            // Click on the first product
            driver.findElement(By.xpath("(//div[@class='_4ddWXP'])[1]")).click();
            for(String CTab:driver.getWindowHandles()) {
            	driver.switchTo().window(CTab);
            }
            //Thread.sleep(2000);
            System.out.println("Clicked on the first product");    
            // Scrolling the page till the element is found
            WebElement Element = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));   		
            js.executeScript("arguments[0].scrollIntoView();", Element);          
            // Add to cart  
            driver.findElement(By.xpath("(//button[normalize-space()='Add to cart'])")).click();
            System.out.println("Added the product to cart");            
            // Display the order amount
            String FirstProductAmount = driver.findElement(By.xpath("(//div[@class='_1dqRvU'])")).getText();
            System.out.println("First Order amount: "+ FirstProductAmount );
            TakesScreenshot ts1=(TakesScreenshot)driver;
            File src1=ts1.getScreenshotAs(OutputType.FILE);
            File target1=new File("C:\\Users\\2327122\\OneDrive - Cognizant\\java programming\\newpro\\src\\newpro\\screenshot\\Product1.png");
            FileUtils.copyFile(src1,target1);
            driver.close();           
            // Go back to Home appliances page  
            System.out.println("Went back to Home appliances page");
            for(String CTab:driver.getWindowHandles()) {
            driver.switchTo().window(CTab);
            }
            //Clicking the second product
            driver.findElement(By.xpath("(//div[@class='_4ddWXP'])[2]")).click();
            for(String CTab:driver.getWindowHandles()) {
            	driver.switchTo().window(CTab);
            }
            System.out.println("Clicked on the second product");
            String SecondProductAmount=driver.findElement(By.xpath("(//div[@class='_30jeq3 _16Jk6d'])[1]")).getText();           
            WebElement SecondElement = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
            // Scrolling down the page till the element is found		
            js.executeScript("arguments[0].scrollIntoView();", SecondElement);
            // Add one more item to the cart
            driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
            System.out.println("Second Product Added to Cart");
            // Display the revised total order amount
            String TotalAmount = driver.findElement(By.xpath("(//div[@class='_1dqRvU'])")).getText();
            System.out.println("Total Order amount: "+ TotalAmount );
            TakesScreenshot ts2=(TakesScreenshot)driver;
            File src2=ts2.getScreenshotAs(OutputType.FILE);
            File target2=new File("C:\\Users\\2327122\\OneDrive - Cognizant\\java programming\\newpro\\src\\newpro\\screenshot\\Product2.png");
            FileUtils.copyFile(src2,target2);
            String[] arr1=FirstProductAmount.split("₹");
            String[] arr2=SecondProductAmount.split("₹");
            String[] arr3=arr1[1].split(",");
            String[] arr4=arr2[1].split(",");
            String FirstProduct=(arr3[0]+arr3[1]);
            String SecondProduct=arr4[0]+arr4[1];        
            int FirstPrice=Integer.parseInt(FirstProduct);
            int SecondPrice=Integer.parseInt(SecondProduct);
            int ExpectedTotalAmount= FirstPrice + SecondPrice;
            String[] arr5=TotalAmount.split("₹");
            String[] arr6=arr5[1].split(",");
            String TotalProductPrice=(arr6[0]+arr6[1]);
            int TotalPrice=Integer.parseInt(TotalProductPrice);
            if(ExpectedTotalAmount==TotalPrice){
            	System.out.println("Total Order Amount is Valid");
            }else {
            	System.out.println("Total Order Amount is invalid");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
       } finally {
            driver.quit();
            System.out.println("Closed the browser");
        }
    }
    }