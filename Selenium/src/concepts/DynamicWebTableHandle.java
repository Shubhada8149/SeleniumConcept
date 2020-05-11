package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://ui.freecrm.com/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("email")).sendKeys("otari.shubhada@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);

		WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]"));
		loginbtn.click();

		driver.findElement(By.xpath("//div[@id='main-nav']//a[5]")).click();
		Thread.sleep(3000);

		// //tr[5]//td[2]
		// print all deals
		String before_xpath = "//tr[";
		String after_xpath = "]//td[2]";

		for (int i = 1; i <= 5; i++) {

			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains("dealtest")) {
				driver.findElement(By.xpath("//tr[" + i + "]//td[2]")).click(); //click on 4 th record

			}
		}

	}

}
