package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailConfirmationPage extends BasePage {

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/div/button")
	private WebElement nextButton;

	@FindBy(id = "confirmation-code")
	private WebElement confirmationCodeTextField;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div[3]")
	private WebElement resendCodeLink;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div[1]/div[1]")
	private WebElement enterCodeSentToEmailLabel;

	public EmailConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNextButton() {
		nextButton.click();
	}

	public void setConfirmationCodeTextField(String confirmationCodeValue) {
		getConfirmationCodeTextField().sendKeys(confirmationCodeValue);
	}
	
	public boolean isNextButtonEnabled() {
		return nextButton.isEnabled();
	}
	
	public String getEnterCodeSentToEmailLabelText() {
		return enterCodeSentToEmailLabel.getText();
	}

	public WebElement getConfirmationCodeTextField() {
		return confirmationCodeTextField;
	}
}
