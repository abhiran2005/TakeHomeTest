package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver = null;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
