package concepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://popuptest.com/goodpopups.html");
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it= handler.iterator();
		
		String ParentWindowId = it.next();
		System.out.println("Parent window id is" +ParentWindowId); //print parent window id
		
		String ChildWindowId = it.next();
		System.out.println("Child window id is" + ChildWindowId); //print child window id
		
		driver.switchTo().window(ChildWindowId);
		System.out.println("Child window title is" + driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(ParentWindowId);
		
		System.out.println("Parent window title is" + driver.getTitle());
		
		driver.close();
		
	}

}
