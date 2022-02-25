package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver = null;

	@BeforeTest
	public void setup() {
		try {
			driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println("Unable to initiate the web driver.");
			e.printStackTrace();
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
