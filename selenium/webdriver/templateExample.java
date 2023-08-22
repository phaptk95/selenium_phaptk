package webdriver;

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

public class templateExample {
	// Test commit push Slack
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String OS_Name = System.getProperty("os.name");

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
	public void TC_01_() {
		driver.get("https://google.com");
	}

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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