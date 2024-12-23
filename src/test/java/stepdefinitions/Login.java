package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
//	private HomePage homePage;
//	private LoginPage loginPage;
//	private AccountPage accountPage;
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	AccountPage accountPage = new AccountPage(driver);
	private CommonUtils CommonUtils;
	//may result in error - driverfactor object please check
	
	@Given("^User navigates to login page$")
	public void User_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();
	}

	@When("User enters valid (.+) address")
	public void User_enters_valid_email_address() {
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	}

	@And("Enter valid (.+) into password field")
	public void Enter_valid_into_password_field(String password) {
		loginPage.enterPassword(password);
	}

	@And("^Clicks on Login button$")
	public void Clicks_on_Login_button() {
		accountPage = loginPage.clickOnloginButton();
	}

	@Then("^User should login successfully$")
	public void User_should_login_successfully() {
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("^User enters invalid email address \"(.+)\"$")
	public void User_enters_invalid_email_address() {

		CommonUtils = new CommonUtils();
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	}

	@And("^Enter invalid password (.+)$")
	public void Enter_invalid_password(String invalidPassword) {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("^User should get a proper warning message$")
	public void User_should_get_a_proper_warning_message() {
		Assert.assertTrue(loginPage.checkWarningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("^User has not enter any credentials$")
	public void User_has_not_enter_any_credentials() {
		loginPage.enterEmailAddress("");
	}
}

