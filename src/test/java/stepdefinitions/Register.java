package stepdefinitions;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
//	private HomePage homePage;
//	private LoginPage loginPage;
//	private AccountPage accountPage;
	HomePage homePage = new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	AccountPage accountPage = new AccountPage(driver);
	RegisterPage registerPage = new RegisterPage(driver);
	private CommonUtils commonUtils;
	
	@Given("^User navigate to Register Account page$")
	public void User_navigate_to_Register_Account_page() {
		driver = DriverFactory.getDriver();
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
	}

	@When("^User enters below data into the fields$")
	public void User_enters_below_fields_into_the_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterlastName(dataMap.get("lastname"));
		registerPage.enterEmail((commonUtils.getEmailWithTimeStamp()));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("confirmPassword"));
	}


	@When("^User enters below data into the fields with duplicate email$")
	public void User_enters_below_data_into_the_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterlastName(dataMap.get("lastname"));
		registerPage.enterEmail((commonUtils.getEmailWithTimeStamp()));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("confirmPassword"));
	}

	@And("Select Privacy Policy field")
	public void Select_privacy_policy_field() {
		registerPage.selectPrivacyPolicy();
	}

	@And("Clicks on Continue button")
	public void clicks_on_continue_button() {
		registerPage.clickOnContinueButton();
	}

	@Then("Account should get successfully created")
	public void account_should_get_successfully_created() {
		Assert.assertEquals("Your Account Has Been Created!", registerPage.checkAccountSuccessMessage());
	}

	@When("Selects Yes for Newsletter")
	public void selects_yes_for_newsletter() {
		driver.findElement(By.xpath("//input[@name='newsletter', @value='1']")).click();
	}
	@When("User dont enter data in any fields")
	public void user_dont_enter_data_in_any_fields() {
		//	intentionally left blank
	}

	@Then("Warning message should dispaly for all mandatory fields")
	public void warning_messaged_should_dispaly_for_all_mandatory_fields() {
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("alert alert-danger alert-dismissible"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText());
	}

	@Then("Warning message should display indicating duplicate email address")
	public void warning_message_indicating_duplicate_email_address() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	}
}
