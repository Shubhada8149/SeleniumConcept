package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser_HeadlessBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("window-size=1400,800"); // window size is compulsory , if not mentioned then it will give error element not found
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://ui.freecrm.com/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Before login");

		driver.findElement(By.name("email")).sendKeys("otari.shubhada@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);

		WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]"));
		loginbtn.click();

		System.out.println("Login successfully");
	}

}


// if application is compatible with mobile phone then it is not necessary to write window size
//Chrome version should be greater than 60