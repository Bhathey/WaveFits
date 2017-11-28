package testCollections;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popups {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.globalrph.com/davescripts/popup.htm");
	
	WebElement element = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[7]/td/div/table/tbody/tr/td[2]/div[1]/form/table/tbody/tr[4]/td[2]/p/input"));
	element.click();
	
	Set<String> handles = driver.getWindowHandles();
//	for(String s : handles){
//		System.out.println(s);
//	}
	
	Iterator<String> it = handles.iterator();
	
	String mainWin = it.next();
	String popupWin = it.next();
	
	driver.switchTo().window(popupWin);
	
	WebElement label = driver.findElement(By.xpath("/html/body/h2"));
	String text = label.getText();
	System.out.println(text);
}
}