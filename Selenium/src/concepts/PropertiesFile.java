package concepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {

	public static WebDriver driver;
	
	public static void main (String[] args) throws Exception {
	
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace\\Selenium\\src\\study\\config.properties");
		
		prop.load(fis);
	
		System.out.println(prop.getProperty("browser")); // to print the value of browser
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Shubhada\\Documents\\Selenium jars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//There are different ways of creating and maintaining properties file
		
	// first approach
		
		//driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		
//		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		
//		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div/div[3]")).click();
	
	//second approach - write down name or xpath in properties file itself
		
		
		driver.findElement(By.name(prop.getProperty("username_name"))).sendKeys(prop.getProperty("username"));
		
		driver.findElement(By.name(prop.getProperty("password_name"))).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath(prop.getProperty("loginBtn_xpath"))).click();
	
	}
	
	
}
