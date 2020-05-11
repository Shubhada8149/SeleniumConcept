package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedSelectedEnabled {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://api.cogmento.com/register/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// is displayed

		boolean b1 = driver.findElement(By.xpath("//h2[@class='ui blue header']")).isDisplayed();
		System.out.println(b1);

		// is selected

		if (driver.findElement(By.id("terms")).isSelected()) {
			System.out.println("terms checkbox is ticked");
		} else {
			System.out.println("terms checkbox is unticked");
		}

		// is enabled

		boolean b2 = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
		System.out.println(b2);
	}

}

/*
 * Notes :
 * 
 * isDisplayed() - verify the presence of web element within the web page
 * returns "True" - if specified web element is present on the web page returns
 * "False" - if specified web element is not present on the web page - it is
 * capable to check the presence of all type all elements
 *
 * isEnabled() - verify whether the web element is enabled or disabled within
 * the web page - primilarly used for buttons
 *
 * isSelected() - verify element is selected or not - used for radio buttons,
 * drop downs and check boxes.
 *
 */