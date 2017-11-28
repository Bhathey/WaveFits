package testCollections;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testlogin {

	 public static void main(String[] args) {
	        String baseUrl = "https://jqueryui.com/slider/";
	        System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver2");
	        WebDriver driver = new ChromeDriver();
	        driver.get(baseUrl);
	        WebElement containerFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
	        driver.switchTo().frame(containerFrame);
	        WebElement sliderBar = driver.findElement(By.cssSelector("div[id='slider']"));
	        Dimension sliderBarDemsion = sliderBar.getSize();
	        int widthSliderBar = sliderBarDemsion.width;


	        WebElement slider = driver.findElement(By.cssSelector("div[id='slider']>span"));
	        Actions sliderAction = new Actions(driver);
	        sliderAction.clickAndHold(slider);
	        int x = getPixels(widthSliderBar,60);
	        sliderAction.moveByOffset(x, 0).perform();

	    }

	    public static int getPixels(int totalWidth,int percentage){
	        return (int)((totalWidth*percentage)/100);
	    }
	}