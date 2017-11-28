package testCollections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {
public static void main(String[] args) throws InterruptedException {
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
        By.xpath("//span[@class='mr-sm ng-binding']"));
String a = validate.getText();

if(a.equals("amruthaa")){
    System.out.println("Test Case passed ...");
}else{
    System.out.println("Test Case Failed ...");
}

WebElement profile = driver.findElement(
		By.xpath("//em[@class='fa fa-caret-down']"));
profile.click();


WebElement logout = driver.findElement(
		By.xpath("//button[@class='btn btn-labeled btn-primary btn-sm']"));
logout.click();

WebElement assertion = driver.findElement(
		By.xpath("//p[text()='SIGN IN TO CONTINUE.']"));
String b= assertion.getText();

if(b.equals("SIGN IN TO CONTINUE.")){
	System.out.println("Test Case passed ...");
}else{
	System.out.println("Test Case Failed ...");
}



driver.quit();
}

}
