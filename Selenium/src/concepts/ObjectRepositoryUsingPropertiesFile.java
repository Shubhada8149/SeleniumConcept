package concepts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectRepositoryUsingPropertiesFile {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws Exception {

	Properties prop = new Properties();
	
	FileInputStream fis = new FileInputStream("E:\\eclipse-workspace\\Selenium\\src\\study\\ObjectRepository.properties");
	
	prop.load(fis);
	
	System.out.println(prop.getProperty("url")); // printing value of url property
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver","C://Users//Shubhada//Documents//Selenium jars//firefoxdriver.exe");
		driver = new FirefoxDriver();
	}
	
	driver.get(prop.getProperty("url"));
	
	prop.getProperty("wait");
	
	driver.findElement(By.name(prop.getProperty("fullname_name"))).sendKeys(prop.getProperty("fullname"));
	
	prop.getProperty("wait");
	
	
	}

}
