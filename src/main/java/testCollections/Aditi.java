package testCollections;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Aditi {
	 public String baseUrl = "http://fits.qauber.com/#/page/login";
	    String driverPath =  "/Users/aditisale/Downloads/chromedriver";
	    public WebDriver driver ; 
	    
	    @BeforeTest
	      public void Setup() {
	          System.out.println("launching Chrome browser"); 
	          System.setProperty("webdriver.chrome.driver", driverPath);
	          driver = new ChromeDriver();
	          driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	          driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	          driver.get(baseUrl);
	    }
	    
	    @Test(priority =0,enabled = true,description= "User should be able to login into the FITS with valid email id and password")
	    public void Test1() throws InterruptedException{
	    	
	        WebElement emailTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
	        emailTextBox.sendKeys("reshmaaher@gmail.com");
	        
	        
	        WebElement passwordTextBox = driver.findElement(By.xpath(".//*[@id='exampleInputPassword1']"));
	        passwordTextBox.sendKeys("Iltarget3");
	        
	        
	        Thread.sleep(5000);
	     
	        WebElement loginButton = driver.findElement( By.xpath("//button[text()='Login']"));
	        loginButton.click();
 }
	    
	    @Test(priority=1,enabled = true, description="User should be able to login into the FITS with valid email id and password")
	    public void test2(){
	    	  WebElement TextBox = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
	    	  String d = TextBox.getText();
	    	  Assert.assertEquals("AditiCafe", d);
	    	
	    	
	    }
	    
	    @Test(groups= {"Invite Users"},description="SA should invite Regular User with valid  email id")
	    public void test6() {
	    		WebElement user = driver.findElement(By.xpath("//span[text()='Users']")); 
	    		user.click();
	    		System.out.println("Clicked Users list");
	    		WebElement inviteuser = driver.findElement(By.xpath("//button[@class='pull-right btn btn-info btn-sm']")); 
	    		inviteuser.click();
	    		 WebElement emailInvite = driver.findElement(By.xpath("//input[@name='email']")); 
	             emailInvite.sendKeys("pqr@mailinator.com");
	             
	             WebElement sendInvite = driver.findElement(By.xpath("//button[@class='btn btn-primary mr']"));
	             sendInvite.click();
	             
	    }

		    
		    
		    
		    @AfterTest
		      public void logOut(){
		         // driver.close();
//		    	WebElement logOutButton  = driver.findElement(By.xpath("//button[@class='btn btn-labeled btn-primary btn-sm' ]"));
//		    	logOutButton.click();
	}
		    }