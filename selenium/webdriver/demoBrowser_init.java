package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demoBrowser_init {
	// Test commit push Slack
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String OS_Name = System.getProperty("os.name");



	@Test
	public void TC_01_Edge_Browsers() {
		if (OS_Name.startsWith("Mac")) {
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		} else {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");	
		}
		driver  = new EdgeDriver(); 
		driver.get("https://vnexpress.net");
		
		driver.quit();
	}

	@Test
	public void TC_02_Chrome_Browsers() {
		if (OS_Name.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");	
		}
		driver  = new ChromeDriver(); 
		driver.get("https://vnexpress.net");
		
		driver.quit();
	}

	@Test
	public void TC_03_Firefox_Browsers() {
		if (OS_Name.startsWith("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");	
		}
		driver  = new FirefoxDriver(); 
		driver.get("https://vnexpress.net");
		
		driver.quit();
	}
	@Test
	public void TC_04_Safari_Browsers() {
		String Error_Mes_Safari = "Windows is not supported";
		if (OS_Name.startsWith("Mac")) {
			driver  = new SafariDriver(); 
		driver.get("https://vnexpress.net");
		
		driver.quit();
		} else {
			System.out.println(Error_Mes_Safari);	
		}
		
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