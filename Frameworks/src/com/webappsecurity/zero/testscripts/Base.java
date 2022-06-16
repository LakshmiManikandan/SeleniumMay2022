package com.webappsecurity.zero.testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
WebDriver driver;
	
	@BeforeClass
	public void openApplication() {
			
		System.setProperty("webdriver.chromedriver", "chromedriver,exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}	
	
	@AfterClass
	public void closeApplication() {
		driver.quit();
	}

}
