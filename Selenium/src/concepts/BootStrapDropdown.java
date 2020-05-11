package concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		Thread.sleep(2000);

		List<WebElement> dropdown_list = driver
				.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));

		// Printing the amount of WebElements inside the list
		System.out.println("The Options in the Dropdown are: " + dropdown_list.size());

		// Condition to get the WebElement for list and Click over "Angular" option
		for (int i = 0; i < dropdown_list.size(); i++) {
			// Printing All the options from the dropdown
			System.out.println(dropdown_list.get(i).getText());

			// Checking the condition whether option in text "Angular" is comming
			if (dropdown_list.get(i).getText().contains("Angular")) {
				// Clicking if text "Angular" is there
				dropdown_list.get(i).click();

				// Breaking the condition if the condition get satisfied
				break;
			}
		}
	}
}
