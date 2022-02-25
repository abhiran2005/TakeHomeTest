package testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.annotations.Test;

import pages.EmailConfirmationPage;
import pages.LoginPage;
import pages.SignupPage;
import utils.TestHelper;

public class SignupTests extends BaseTest{
	private static final String URL = "https://www.quora.com/";

	@Test
	public static void testSignupFlow() {
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickSignupWithEmail();
		
		SignupPage signupPage = new SignupPage(driver);
		signupPage.waitForElementToBeVisible(driver, signupPage.getNameTextField(), Duration.ofSeconds(3));
		
		signupPage.setName(TestHelper.generateRandomString(10));
		String emailAddress = TestHelper.generateRandomEmail();
		signupPage.setEmail(emailAddress);
		signupPage.clickNextButton();
		
		EmailConfirmationPage emailConfirmationPage = new EmailConfirmationPage(driver);
		emailConfirmationPage.waitForElementToBeVisible(driver, emailConfirmationPage.getConfirmationCodeTextField(), Duration.ofSeconds(3));
		assertTrue(emailConfirmationPage.getEnterCodeSentToEmailLabelText().contains(emailAddress), "Enter code sent lable should contain user's email address.");
		
		assertFalse(emailConfirmationPage.isNextButtonEnabled(), "Next button should be disabled.");
	}	

}
