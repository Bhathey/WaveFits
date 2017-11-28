package testCollections;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterStep1 {
	public static void main(String[] args) throws InterruptedException, AWTException {

	System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	driver.get("http://fits.qauber.com/#/page/login");
	
	Thread.sleep(5000);

	driver.findElement(
			By.xpath("//a[text()='Register Now']")).click();
	
	Thread.sleep(5000);

	driver.findElement(
			By.xpath("//input[@name='account_name']")).sendKeys("Reya");
	driver.findElement(
			By.xpath("//input[@name='account_email']")).sendKeys("reya@gmail.com");
	driver.findElement(
			By.xpath(".//*[@id='id-password']")).sendKeys("automation");
	driver.findElement(
			By.xpath("//input[@name='account_password_confirm']")).sendKeys("automation");
	driver.findElement(
			By.xpath("//button[text()='Continue registration']")).click();
	WebElement validate = driver.findElement(
			By.xpath("//h4[text()='Company registration']"));
	String a = validate.getText();
	Assert.assertEquals("Company registration", a);
	System.out.println("Succesfully done Resgistration step1");
}
}