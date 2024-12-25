package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, HomePage.class);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDrodown;

	@FindBy(linkText="Login")
	private WebElement login;

	@FindBy(linkText="Register")
	private WebElement register;

	public void clickOnMyAccount() {
		//myAccountDrodown.click();
		elementUtils.clickOnElement(myAccountDrodown, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(login, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//login.click();
		return new LoginPage(driver);
	}	
	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(register, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
}