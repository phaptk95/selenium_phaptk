package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Baitap_7_Dropdownlist_Textbox {
	// Test commit push Slack
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String OS_Name = System.getProperty("os.name");
	
	
	 int randomPositiveNum = generateRandomPositiveNumber();
	 
		String firstName = "John";
		String lastName = "William";
		String emailAddress = "test" + randomPositiveNum + "@yopmail.com";
		String password = "Teq@1234567";
		String confirmPassword = password;
		String nickName = "J.D.Willy"+randomPositiveNum;
		
	
	 public static int generateRandomPositiveNumber() {
	        Random rand = new Random();
	        return rand.nextInt(Integer.MAX_VALUE) + 1; // Tạo số nguyên dương trong khoảng từ 1 đến Integer.MAX_VALUE
	    }

	@BeforeClass
	public void beforeClass() {
		// Update lai template mau
		if (OS_Name.startsWith("Mac")) {
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		} else {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");	
		}
		driver  = new EdgeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}

	@Test
	public void TC_01_Create_Account_miss_password() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class=\"account-cart-wrapper\"]/a")).click();
		driver.findElement(By.xpath("//div[@class=\"skip-content skip-active\"]//li[@class='first']")).click();
//		sleepInSecond(1);
		driver.findElement(By.xpath("//div[@class='buttons-set']/a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//div[@class='field name-firstname']//div/input")).sendKeys(firstName);
		driver.findElement(By.xpath("//div[@class='field name-lastname']//div/input")).sendKeys(lastName);
		driver.findElement(By.xpath("//div[@class='input-box']/input[@id='email_address']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//div[@class='input-box']/input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='input-box']/input[@id='confirmation']")).sendKeys(confirmPassword);
		driver.findElement(By.xpath("//div[@class='buttons-set']/button")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-password']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-password']")).getText(), "This is a required field.");
		
		
		
		
		
	}

	@Test
	public void TC_02_CreateSuccess() {

			
			driver.get("http://live.techpanda.org/");
			driver.findElement(By.xpath("//div[@class=\"account-cart-wrapper\"]/a")).click();
			driver.findElement(By.xpath("//div[@class=\"skip-content skip-active\"]//li[@class='first']")).click();
//			sleepInSecond(1);
			driver.findElement(By.xpath("//div[@class='buttons-set']/a[@title='Create an Account']")).click();
			driver.findElement(By.xpath("//div[@class='field name-firstname']//div/input")).sendKeys(firstName);
			driver.findElement(By.xpath("//div[@class='field name-lastname']//div/input")).sendKeys(lastName);
			driver.findElement(By.xpath("//div[@class='input-box']/input[@id='email_address']")).sendKeys(emailAddress);
			driver.findElement(By.xpath("//div[@class='input-box']/input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//div[@class='input-box']/input[@id='confirmation']")).sendKeys(confirmPassword);
			driver.findElement(By.xpath("//div[@class='buttons-set']/button")).click();
			
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='success-msg']")).isDisplayed());
			Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).getText(), "Thank you for registering with Main Website Store.");
			
//			System.out.println(driver.findElement(By.xpath("//div[@class='box-content']/p")).getText());
//			System.out.println(firstName + " " + lastName + "/br" + emailAddress + "/br" + "Change Password");
//			System.out.println(driver.findElement(By.xpath("//div[@class='box-content']/p")).getText().contains(firstName));
	
			
		 	String[] words = driver.findElement(By.xpath("//div[@class='box-content']/p")).getText().split("\n");
		 	
		 	
			Assert.assertEquals( words[0] , firstName + " " + lastName  );
			Assert.assertEquals( words[1] , emailAddress  );
			driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text() = \"Account\"]")).click();
			driver.findElement(By.xpath("//div[@id='header-account']//li[@class=' last']")).click();
			
			Assert.assertEquals( driver.findElement(By.xpath("//div[@class='page-title']")).getText() , "YOU ARE NOW LOGGED OUT"  );
			
			
			
	}

	@Test
	public void TC_baitap_03(){
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
		driver.findElement(By.xpath("//button[text() = ' Add ']")).click();
		
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		String EmpID = driver.findElement(By.xpath("//div[label[text()='Employee Id']]/following-sibling::div/input")).getAttribute("value");
		
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();		
		driver.findElement(By.xpath("//div[label[text()='Username']]/following-sibling::div/input")).sendKeys(nickName);
		driver.findElement(By.xpath("//div[label[text()='Password']]/following-sibling::div/input")).sendKeys(password);
		driver.findElement(By.xpath("//div[label[text()='Confirm Password']]/following-sibling::div/input")).sendKeys(confirmPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("OK" + EmpID);
		
		// Verify Text
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		sleepInSecond(10);

		
		// driver.findElement(By.xpath("//input[@name='firstName']")).getText();
			
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value") , firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id' and @class='oxd-label']/following::input[1]")).getAttribute("value"), EmpID);
		
		driver.findElement(By.xpath("//a[@class='orangehrm-tabs-item' and text()='Immigration']")).click();
		driver.findElement(By.xpath("//div/h6[text()='Assigned Immigration Records']/following-sibling::button[text() = ' Add ']")).click();
		
		
		
		
	}


	@AfterClass
	public void afterClass() {
//		 driver.quit();
	}
	
	public void  sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}