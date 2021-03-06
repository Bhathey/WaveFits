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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEntityTestNG {
	WebDriver driver;

	@BeforeTest()
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//user//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
		driver.get("http://fits.qauber.com/#/page/login");
	}

	@Test(groups = { "Login" }, priority = 0)
	public void login() throws InterruptedException {
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
	}

	@Test
	public void step1_addEntity() throws InterruptedException, AWTException {
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefits12");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

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

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("4084534567");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("amruthaa@gmail.com");

		WebElement notes = driver
				.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"));
		notes.sendKeys("Adding entity to the organization");

		Thread.sleep(5000);

		WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();
	}
	@Test(enabled=false)
	public void step2_addEntity() throws InterruptedException{
		WebElement regularUserEmailId = driver.findElement(By.xpath("//div[@class='bootstrap-tagsinput']/input"));
		regularUserEmailId.sendKeys(" selenium@mailinator.com ");
		Thread.sleep(5000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		next1.click();
		Thread.sleep(5000);

		WebElement confirm = driver.findElement(By.xpath("//button[text()='Done']"));
		confirm.click();
	}

	@Test(enabled=false)
	public void step3_addEntity() throws InterruptedException{
		WebElement adminUserEmailId = driver.findElement(By.xpath("//div[@class='form-group']/div/input"));
		adminUserEmailId.sendKeys(" selenium1@mailinator.com ");

		Thread.sleep(5000);

		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement confirmAd = driver.findElement(By.xpath("//button[text()='Done']"));
		confirmAd.click();

	}
	
	@Test(enabled=false)
	public void paypal(){
		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	
	@Test(groups = { "functional" }, priority = 1, description = "Adding Entity", enabled = false)
	public void addEntity() throws InterruptedException, AWTException {
		WebElement entity = driver.findElement(By.xpath("//span[text()='Entities']"));
		entity.click();

		WebElement addentity = driver.findElement(By.xpath("//button[text()='Add Entity']"));
		addentity.click();

		WebElement eName = driver.findElement(By.xpath("//input[@name='name']"));
		eName.sendKeys("wavefit17");

		driver.findElement(By.xpath("//button[@class='upload btn btn-labeled btn-primary']")).click();
		String fileLocation = "C:\\Users\\user\\Desktop\\IMG_5400.JPG";

		StringSelection filepath = new StringSelection(fileLocation);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		Robot robot = new Robot();

		try {

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

		WebElement country = driver.findElement(By.xpath("//select[@name='country']/option[text()='United States']"));
		country.click();

		WebElement address1 = driver.findElement(By.xpath("//input[@name='address1']"));
		address1.sendKeys("2905,stenderway");

		WebElement address2 = driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.address2']"));
		address2.sendKeys("Suite 21");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Santa clara");

		Select drstate = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		// drstate.selectByVisibleText("Texas");
		drstate.selectByIndex(10);

		WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
		zip.sendKeys("94089");

		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		phone.sendKeys("4084534567");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("amruthaa@gmail.com");

		WebElement notes = driver
				.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"));
		notes.sendKeys("Adding entity to the organization");

		Thread.sleep(5000);

		WebElement next = driver.findElement(By.xpath("//button[@ class='btn btn-info btn-labeled'][2]"));

		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		if (cp.getBrowserName().equals("chrome")) {
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
			} catch (Exception e) {

			}
		}

		next.click();

		WebElement regularUserEmailId = driver.findElement(By.xpath("//div[@class='bootstrap-tagsinput']/input"));
		regularUserEmailId.sendKeys(" selenium@mailinator.com ");

		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		next1.click();

		Thread.sleep(5000);

		WebElement confirm = driver.findElement(By.xpath("//button[text()='Done']"));
		confirm.click();

		WebElement adminUserEmailId = driver.findElement(By.xpath("//div[@class='form-group']/div/input"));
		adminUserEmailId.sendKeys(" selenium1@mailinator.com ");

		Thread.sleep(5000);

		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement confirmAd = driver.findElement(By.xpath("//button[text()='Done']"));
		confirmAd.click();

		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();

		Thread.sleep(5000);

		List<WebElement> allElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//a"));

		for (WebElement e : allElement) {
			// System.out.println(String.format("Value is: %s",
			// e.getAttribute("text")));
			String value = "wavefit11";

			if (e.getAttribute("text").equals(value)) {
				System.out.println("SAU could added the entity");

			}
		}

	}

	@Test(dependsOnMethods = { "step1_addEntity" },enabled=false)
	public void withutRegUserAdminUser() throws InterruptedException {
		Thread.sleep(5000);
		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		next1.click();
		Thread.sleep(5000);
		
		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	@Test(dependsOnMethods = { "step1_addEntity" })
	public void withoutAdminUser() throws InterruptedException{
		WebElement regularUserEmailId = driver.findElement(By.xpath("//div[@class='bootstrap-tagsinput']/input"));
		regularUserEmailId.sendKeys(" selenium@mailinator.com ");

		WebElement next1 = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		next1.click();

		Thread.sleep(5000);

		WebElement confirm = driver.findElement(By.xpath("//button[text()='Done']"));
		confirm.click();
		Thread.sleep(5000);
		WebElement nextAdmin = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));

		nextAdmin.click();

		Thread.sleep(5000);

		WebElement finishSubs = driver.findElement(By.xpath("//button[@class='btn btn-info btn-labeled'][2]"));
		finishSubs.click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='rightarrow']")).click();

		WebElement paypalemai = driver.findElement(By.xpath(".//*[@id='login_email']"));
		paypalemai.sendKeys("mss.bharati-1@gmail.com");

		WebElement paypalPass = driver.findElement(By.xpath(".//*[@id='login_password']"));
		paypalPass.sendKeys("hisandbox");

		driver.findElement(By.xpath(".//*[@id='submitLogin']")).click();

		driver.findElement(By.xpath(".//*[@id='continue']")).click();
	}
	@AfterTest(description = "Application logged out successfully")
	public void logout() throws InterruptedException {
		WebElement profile = driver.findElement(By.xpath("//em[@class='fa fa-caret-down']"));
		profile.click();

		Thread.sleep(5000);
		WebElement logout = driver.findElement(By.xpath("//button[@class='btn btn-labeled btn-primary btn-sm']"));
		logout.click();

		WebElement assertion = driver.findElement(By.xpath("//p[text()='SIGN IN TO CONTINUE.']"));
		String b = assertion.getText();

		if (b.equals("SIGN IN TO CONTINUE.")) {
			System.out.println("Test Case passed ...");
		} else {
			System.out.println("Test Case Failed ...");
		}

		driver.quit();
	}
}
