package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.TestHelper;

public class LoginTests extends BaseTest {
	private static final String URL = "https://www.quora.com/";
	private static final String NO_ACC_FOUND_ERR_ENG = "No account found for this email. Retry, or Sign up for Quora.";

	/***
	 * Verify a user without an account cannot login via email/password.
	 * This test tries to login with auto generated email address and password combination and verifies that appropriate error messages are displayed.
	 */
	@Test
	public static void testUserWithoutAccCannotLogin() {
		/*NOTE: Adding multiple verifications in one testcase to reduce the setup time. 
		 * Ideally one test should test an isolated element/workflow. 
		 * However, UI tests are resource intensive and slow. 
		 * Adding hundreds of such tests would extend the test execution time significantly. */
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);

		/* Quora login page seems to have a call to the backend logic which is checking
		 if the email address exists in their user db. As soon as user is done
		 entering the email address, the error message shows up.*/
		loginPage.setEmail(TestHelper.generateRandomEmail() + Keys.TAB);

		// Verify that the expected error message is visible on the page.
		assertTrue(
				loginPage.waitForElementToBeVisible(driver, loginPage.getNoAccountFoundErrorMessageElement(),
						Duration.ofSeconds(5)),
				"Expected error message is not visible even after waiting for desired amount of time.");

		/* Verify the expected error text matches the error shown on the page.
		 This can be enhanced in future to verify messages in different languages.*/
		assertEquals(loginPage.getNoAccountFoundErrorText(), NO_ACC_FOUND_ERR_ENG);

		loginPage.setPassword(TestHelper.generateRandomString(5));

		assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled");

		// Click login button and verify that the click is intercepted.
		try {
			loginPage.clickLogin();
		} catch (Exception exe) {
			assertEquals(exe.getClass(), ElementClickInterceptedException.class);
		}

		// Verify that the page doesn't redirect and the login button is still visible
		// since the login was unsuccessful
		assertFalse(loginPage.waitForElementToBeInvisible(driver, loginPage.getLoginButton(), Duration.ofSeconds(3)),
				"Login button is not visible anymore, the page must be redirected.");
	}
}
