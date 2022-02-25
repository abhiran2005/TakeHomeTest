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
		// Verify clicking on Signup link open the signup popup
		assertTrue(signupPage.waitForElementToBeVisible(driver, signupPage.getNameTextField(), Duration.ofSeconds(3)),
				"Clicking on signup link should open the signup popup");
		
		signupPage.setName(TestHelper.generateRandomString(10));
		
		String emailAddress = TestHelper.generateRandomEmail();
		signupPage.setEmail(emailAddress);
		signupPage.clickNextButton();
		
		EmailConfirmationPage emailConfirmationPage = new EmailConfirmationPage(driver);
		
		//Verify entering a valid name and email and clicking next opens the email confirmation popup.
		assertTrue(emailConfirmationPage.waitForElementToBeVisible(driver, emailConfirmationPage.getConfirmationCodeTextField(), 
				Duration.ofSeconds(3)),"Entering valid name and emila and clicking next should open email confirmation popup");
		
		//Verify label on email confirmation page contains the email address user entered.
		assertTrue(emailConfirmationPage.getEnterCodeSentToEmailLabelText().contains(emailAddress), 
				"Enter code sent lable should contain user's email address.");
		
		//Verify Next button is disabled.
		assertFalse(emailConfirmationPage.isNextButtonEnabled(), "Next button should be disabled.");
		
		/* After this verification, there should be a utility which waits for the email (configured with internal 
		 * test email service) or a database utility which checks the code generated and enters it in the text field 
		 * for further workflow.*/
		
	}	

}
