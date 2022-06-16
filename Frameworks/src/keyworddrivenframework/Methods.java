package keyworddrivenframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	
	
	public void navigateToApp(String url) {
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.setProperty(url, url);
	}
	
	public void enterInTextBox(String locValue, String testData) {
		
		driver.findElement(By.id(locValue)).sendKeys(testData);
		
	}
public void clickButton(String loc, String locValue) {
	if(loc.equals("name")) {
	driver.findElement(By.name(locValue)).click();
	}
	else if (loc.equals("xpath")) {
		driver.findElement(By.xpath(locValue)).click();

	}
}
public String getErrorMessage(String loc,String locValue) {
	String msg="";
	if(loc.equals("cssSelector")){
	msg = driver.findElement(By.cssSelector(locValue)).getText();
	
}
	else if (loc.equals("id")) {
	msg = driver.findElement(By.id(locValue)).getText();
		}
	return msg;

}
public void closeApp () {
	driver.quit();
}
}
