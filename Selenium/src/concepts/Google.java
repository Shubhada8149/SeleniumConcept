package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.google.com/");
		
		
		//String handler = driver.getWindowHandle();
		
	//	System.out.println("Google window id is" +handler);
		
		/*
		driver.findElement(By.id("languages-button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[21]/a/span[2]")).click();
		
		Thread.sleep(2000);*/
		
		
		driver.get("http://psassv5.auracorpuat.com/#/signin/");
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
				
		driver.findElement(By.id("email")).sendKeys("SSQA-Japan");
		Thread.sleep(1000);
		
		driver.findElement(By.id("pwd")).sendKeys("7vPy@dM00ML4#5");
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		
	
		
		//click on response
		
		driver.findElement(By.xpath("//div[@class='dashboard_banner ng-scope  customer_feeback_banner_responses']")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/div[3]/div/div/div[3]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]")).click();
		Thread.sleep(5000);
		
		//click on dashboard
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/nav/ul/li[2]/a")).click();
		Thread.sleep(5000);
		
		//Click on chart
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/div[3]/div/div/div[3]/div[3]/div[1]/div/div[1]/h3/span[2]/span/a[2]")).click();
		Thread.sleep(5000);
		
		//match 3.2 value
		
		//click on change level
		
		driver.findElement(By.xpath("//button[@class='btn-link btn_change_level']")).click();
		Thread.sleep(5000);
		
	//click on apply button
		driver.findElement(By.xpath("//button[@class='btn btn-primary ng-isolate-scope']")).click();
	}

}
