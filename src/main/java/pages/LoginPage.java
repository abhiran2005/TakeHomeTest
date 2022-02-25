package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	WebDriver driver;
	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div[2]/div[4]/button")
	private WebElement loginButton;

	// Using full xpath since the element is generated with a new identifier every time.
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div[3]")
	private WebElement noAccountFoundErrorMessage;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/button/div/div/div")
	private WebElement signupWithEmailButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String emailValue) {
		emailTextField.sendKeys(emailValue);
	}

	public void setPassword(String passwordValue) {
		passwordTextField.sendKeys(passwordValue);
	}

	public void clickLogin() {
		getLoginButton().click();
	}

	public WebElement getNoAccountFoundErrorMessageElement() {
		return noAccountFoundErrorMessage;
	}

	public String getNoAccountFoundErrorText() {
		return noAccountFoundErrorMessage.getText();
	}

	public boolean isLoginButtonEnabled() {
		return getLoginButton().isEnabled();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickSignupWithEmail() {
		signupWithEmailButton.click();
	}
}
