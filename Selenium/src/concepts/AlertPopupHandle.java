package concepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		
		//alert.accept(); // click on OK button
		
		alert.dismiss(); // click on cancle button
		
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct alert message");
		}else {
			System.out.println("wrong alert message");
		}
		
		
		
	}

}
