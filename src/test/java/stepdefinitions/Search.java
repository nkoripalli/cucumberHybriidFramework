package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	WebDriver driver;
//	private HomePage homePage;
//	private LoginPage loginPage;
//	private AccountPage accountPage;
	
	
//	@BeforeStep("@Register")
//	public void beforeEveryStep() {
//		System.out.println("++Before every step hook");
//	}
//	
//	@AfterStep("@Register")
//	public void afterEveryStep() {
//		System.out.println("++After every step hook");
//	}
	
	
//	@BeforeStep(order=1)
//	public void beforeEveryStep() {
//		System.out.println("++Before every step hook");
//	}
//	
//	@AfterStep(order=2)
//	public void afterEveryStep() {
//		System.out.println("++After every step hook");
//	}
//	
	@Given("User open the application")
	public void user_open_the_application() {
		driver = DriverFactory.getDriver();
		}

	@When("User enter the product into Search field")
	public void user_enter_the_product_into_search_field(String validProductText) {
		driver.findElement(By.name("search")).sendKeys(validProductText);
	}

	@When("User click on Search button")
	public void user_click_on_search_button() {
		driver.findElement(By.xpath("//button[contains(@class, 'btn-default')]")).click();
	}

	@Then("Valid product should get displyed in serach results")
	public void valid_product_should_get_displyed_in_serach_results() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065')]")).isDisplayed());
	}

	@When("User enter invalid product into Search field")
	public void user_enter_invalid_product_into_search_field(String inValidProductText) {
		driver.findElement(By.name("search")).sendKeys(inValidProductText);
	}
	
	@Then("Proper text indicating user about no matching product shoudl be displayed")
	public void proper_text_indicating_user_about_no_matching_product_shoudl_be_displayed() {
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	}

	@When("User do not enter any product into Search field")
	public void user_do_not_enter_any_product_into_search_field() {
		//Intentionally left blank
	}
}
