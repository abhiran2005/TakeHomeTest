package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends BasePage {

	WebDriver driver;
	
	@FindBy(id = "profile-name")
	private WebElement nameTextField;
	
	@FindBy(id = "email")
	private WebElement emailTextField;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/button")
	private WebElement nextButton;
	
	@FindBy(id="confirmation-code")
	private WebElement confirmationCodeTextField;

	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmail(String emailValue) {
		emailTextField.sendKeys(emailValue);
	}
	
	public void setName(String nameValue) {
		getNameTextField().sendKeys(nameValue);
	}
	
	public void clickNextButton() {
		nextButton.click();
	}

	public void setConfirmationCodeTextField(String confirmationCodeValue) {
		confirmationCodeTextField.sendKeys(confirmationCodeValue);
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}
}
