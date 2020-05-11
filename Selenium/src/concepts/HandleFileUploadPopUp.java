package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		//Alert alert = driver.switchTo().alert();
	//	alert.dismiss();
		
		driver.findElement(By.name("fileupload")).sendKeys("E:\\Shubhada Work\\EraPower Test Cases.ods");
		

	}

}

/* Notes -- pop up types
 * 
 * 1. alert ---- javascript pop up  --- alert API (alert.accept  or alert.dismiss)
 * 
 * 2. File upload popup - --- Browse button (type = file , sendKeys(path))
 * 
 * 3. Browser Window popup  ---- Advertisement popup (WindowHandler API, getwindowhandles())
 
 */
