package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/***
	 * This method waits for the given web element to be visible for the given duration. 
	 * @param driver - Webdriver object
	 * @param element - Web element function should wait for, to be visible.
	 * @param duration - Time duration to wait for
	 * @return true if the web element is visible during duration, false if not visible after time duration.
	 */
	public boolean waitForElementToBeVisible(WebDriver driver, WebElement element, Duration duration) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException notVisible) {
			// Specific stack trace can be returned or printed here if required.
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/***
	 *  This method waits for the given web element to be invisible for the given duration. 
 	 * @param driver - Webdriver object
	 * @param element - Web element function should wait for, to be invisible.
	 * @param duration - Time duration to wait for
	 * @return true if the web element is invisible during duration, false if still visible after time duration.
	 */
	public boolean waitForElementToBeInvisible(WebDriver driver, WebElement element, Duration duration) {
		WebDriverWait wait = new WebDriverWait(driver, duration);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			return true;
		} catch (TimeoutException stillVisible) {
			// Specific stack trace can be returned or printed here if required.
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
