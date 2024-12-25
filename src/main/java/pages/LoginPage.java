package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	private ElementUtils elementUtils;

	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, LoginPage.class);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;

	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(id="//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(id="//div[contains(@class, 'alert-dismissible')]")
	private WebElement warningMessgae;
	
	public void enterEmailAddress(String emailText) {
//		emailField.sendKeys(emailText);
//		emailField.clear();
//		emailField.sendKeys(emailText);
		elementUtils.typeText(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	

	public void enterPassword(String passwordText) {
		//passwordField.sendKeys(passwordText);
		elementUtils.typeText(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	
	
	public AccountPage clickOnloginButton() {
		elementUtils.clickOnElement(loginButton, 0);
		//loginButton.click();
		return new AccountPage(driver);
	}	
	
	public String checkWarningMessage() {
		
		return elementUtils.getTextFromatELement(warningMessgae, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessgae.getText();
	}	
}
