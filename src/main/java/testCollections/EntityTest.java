package testCollections;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EntityTest {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
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

		WebElement validate = driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']"));
		String a = validate.getText();

		if (a.equals("amruthaa")) {
			System.out.println("You are on the Fits homepage now ...");
		} else {
			System.out.println("Sorry something went wrong ...");
		}

		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));

		for (WebElement e : allElement) {

			// System.out.println(String.format("Value is: %s",
			// e.getAttribute("text")));
			String vaLue = "wavefit12";
			if (e.getAttribute("text").equals(vaLue)) {
				System.out.println("Pass");

			}
		}
	}
}
