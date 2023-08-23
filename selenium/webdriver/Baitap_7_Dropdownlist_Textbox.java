package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Baitap_7_Dropdownlist_Textbox {
	// Test commit push Slack
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String OS_Name = System.getProperty("os.name");
	
	
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
		 int randomPositiveNum = generateRandomPositiveNumber();
		 
		String firstName = "John";
		String lastName = "William";
		String emailAddress = "test" + randomPositiveNum + "@yopmail.com";
		String password = "";
		String confirmPassword = password;
		
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
		 int randomPositiveNum = generateRandomPositiveNumber();
		 
			String firstName = "John";
			String lastName = "William";
			String emailAddress = "test" + randomPositiveNum + "@yopmail.com";
			String password = "123456789";
			String confirmPassword = password;
			
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
			System.out.println(driver.findElement(By.xpath("//div[@class='box-content']/p")).getText());
			System.out.println(firstName + " " + lastName + "/br" + emailAddress + "/br" + "Change Password");
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box-content']/p")).getText() , firstName + " " + lastName + "/br" + emailAddress + "/br" + "Change Password" );
			
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