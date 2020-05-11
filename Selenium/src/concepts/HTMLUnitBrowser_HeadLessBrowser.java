package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitBrowser_HeadLessBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");

		WebDriver driver = new HtmlUnitDriver();

		// WebDriver driver = new ChromeDriver();

		driver.get("https://www.rediff.com/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String before_title = driver.getTitle();
		System.out.println("before login title is" + before_title);

		Thread.sleep(5000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/p/a[1]")).click();
		Thread.sleep(5000);
		String after_title = driver.getTitle();
		System.out.println("after login title is" + after_title);
	}

}
