package concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class HighlightElement {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// driver.get("https://www.rediff.com/");

		driver.get("https://ui.freecrm.com/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("email")).sendKeys("otari.shubhada@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.name("password")).sendKeys("Test@1234");
		Thread.sleep(2000);

		WebElement loginbtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]"));

		// executeScript -- to execute javascript code

		 flash(loginbtn, driver); // to highlight button

		 drawBorder(loginbtn, driver); // to draw a border

		 generateAlert (driver,"There is an issue with login button");

		clickElementByJS(loginbtn, driver); // click on particular element
		
		//refresh browser - 2 methods
		driver.navigate().refresh();
		Thread.sleep(2000);
		refreshbyjs(driver);
				
		System.out.println(gettitlebyjs(driver));
		
		//get page inner text
		
		getPageInnerText(driver);
		
		System.out.println((getPageInnerText(driver)));
		
		//scroll down
		scrollDown(driver);
	}

	public static void flash(WebElement element, WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundcolor");
		for (int i = 0; i < 2; i++) {
			// Thread.sleep(1000);
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}
	}

	public static void changecolor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {

		}
	}

	public static void drawBorder(WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);

	}

	// if user wants to generate alert for bug

	public static void generateAlert(WebDriver driver, String message) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void refreshbyjs(WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

public static String gettitlebyjs(WebDriver driver) {
	
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	String title = js.executeScript("return document.title;").toString();
	
	return title;
}

	public static String getPageInnerText (WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		
		return pageText;
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
}
