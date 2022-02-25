package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

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
