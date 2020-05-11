package concepts;

import org.testng.annotations.Test;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DownloadFile {

	WebDriver driver;
	File folder;

	@BeforeTest
	public void setup() {

		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		System.setProperty("webdriver.chrome.driver",
				"C://Users//Shubhada//Documents//Selenium jars//chromedriver.exe");
		// driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_settings.popups", 0);

		prefs.put("download.defalut_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

	}

	@Test
	public void downloadFileTest() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/download");

		driver.findElement(By.linkText("empty.txt")).click();
		Thread.sleep(2000);

		File listOfFiles[] = folder.listFiles();

		// make sure directory is not empty

		// Assert.assertEquals(listOfFiles.length,is(not(0)));

		for (File file : listOfFiles) {

	//		Assert.assertEquals(file.length(), is(not((long) 0)));
		}
	}

	@AfterTest
	public void tearDown() {

		driver.close();
		for (File file : folder.listFiles()) {
			file.delete();
		}

		folder.delete();
	}

}