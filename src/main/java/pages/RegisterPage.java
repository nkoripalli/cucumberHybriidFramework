package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elmenetUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, RegisterPage.class);
		elmenetUtils = new ElementUtils(driver);
	}

	@FindBy(id="input-firstname")
	private WebElement firstnameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastnameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;

	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsLetter;
	
	@FindBy(id="//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessMessage;

	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;

	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	public void enterFirstName(String firstNameText) {
		firstnameField.sendKeys(firstNameText);
	}

	public void enterlastName(String lastNameText) {
		//lastnameField.sendKeys(lastNameText);
		elmenetUtils.typeText(lastnameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterEmail(String emailText) {
		//emailField.sendKeys(emailText);
		elmenetUtils.typeText(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterTelephone(String telephoneNumber) {
		//telephoneField.sendKeys(telephoneNumber);
		elmenetUtils.typeText(telephoneField, telephoneNumber, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterPassword(String passwordText) {
		//passwordField.sendKeys(passwordText);
		elmenetUtils.typeText(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		//confirmPasswordField.sendKeys(confirmPasswordText);
		elmenetUtils.typeText(confirmPasswordField, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void selectPrivacyPolicy() {
		elmenetUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//		privacyPolicy.click();
	}

	public void SelectNewsLetter() {
		elmenetUtils.clickOnElement(newsLetter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void clickOnContinueButton() {
		//continueButton.click();
		elmenetUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	

	public String checkAccountSuccessMessage() {
		return elmenetUtils.getTextFromatELement(accountSuccessMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	
	
	public String getFirstNameWarning() {
		firstNameWarning.getText();
		return elmenetUtils.getTextFromatELement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	
	
	public String getLastNameWarning() {
		return elmenetUtils.getTextFromatELement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}	
}