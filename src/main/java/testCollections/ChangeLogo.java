package testCollections;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeLogo {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get("http://fits.qauber.com/#/page/login");

		By x = By.xpath(".//*[@id='exampleInputEmail1']");
		WebElement emailTextBox = driver.findElement(x);
		emailTextBox.sendKeys("amruthaa.bkk@gmail.com");

		By y = By.xpath(".//*[@id='exampleInputPassword1']");
		WebElement passTextBox = driver.findElement(y);
		passTextBox.sendKeys("Amruthaa");

		Thread.sleep(5000);

		By z = By.xpath("//button[text()='Login']");
		WebElement login = driver.findElement(z);
		login.click();


	WebElement validate = driver.findElement(
	        By.xpath("//span[text()='amruthaa']"));
	String a = validate.getText();

	if(a.equals("amruthaa")){
	    System.out.println("Test Case passed ...");
	}else{
	    System.out.println("Test Case Failed ...");
	}
	WebElement entity = driver.findElement(
			By.xpath("//span[text()='Entities']"));
	entity.click();

	WebElement addentity = driver.findElement(
			By.xpath("//button[text()='Add Entity']"));
	addentity.click();
	
	driver.findElement(
			By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
	String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

	StringSelection filepath = new StringSelection(fileLocation);

	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

	Robot robot = new Robot();

			try{
				
			robot.delay(500);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
	
			Thread.sleep(5000);
			
		    WebElement change = driver.findElement(
		    		By.xpath("//span[text()='Change']"));
		    String validate1 = change.getText();
		    if(validate1.equals("Change")) {
		    	driver.findElement(
		    			By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		    	String fileLocation1 = "C:\\Users\\user\\Desktop\\company.png";

		    	StringSelection filepath1 = new StringSelection(fileLocation1);

		    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath1, null);

		    	Robot robot1 = new Robot();

		    			try{
		    				
		    			robot.delay(500);
		    			
		    			robot.keyPress(KeyEvent.VK_CONTROL);
		    			
		    			robot.keyPress(KeyEvent.VK_V);
		    			
		    			robot.keyRelease(KeyEvent.VK_V);
		    			
		    			robot.keyRelease(KeyEvent.VK_CONTROL);

		    			robot.keyPress(KeyEvent.VK_ENTER);

		    			robot.keyRelease(KeyEvent.VK_ENTER);

		    			} catch (Exception e1) {
		    				
		    				e1.printStackTrace();
		    				
		    			}
		    			Thread.sleep(5000);

		    			
		    			boolean image = driver.findElement(
		    					By.xpath("//div[text()='5.8 kB | company.png']")).isDisplayed();
		    			
		    			if(image == true) {
		    				System.out.println("Image displayed");
		    			}else {
		    				System.out.println("Image not displayed");
		    			}

		    }
}
}
