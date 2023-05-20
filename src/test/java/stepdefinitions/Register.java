package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register 
{
	WebDriver driver;	
	private RegisterPage registerpage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonutils;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) throws InterruptedException {
	  Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	   
	  registerpage.enterFirstName(dataMap.get("firstName"));
	  registerpage.enterLastName(dataMap.get("lastName"));
	  commonutils = new CommonUtils();
	  registerpage.enterEmailAddress(commonutils.getEmailWithTimeStamp());
	  registerpage.enterTelephone(dataMap.get("telephone")); 
	  registerpage.enterPassword(dataMap.get("password"));
	  registerpage.enterConfirmPassword(dataMap.get("password"));
	 
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	  Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	  registerpage.enterFirstName(dataMap.get("firstName"));
	  registerpage.enterLastName(dataMap.get("lastName"));
	  registerpage.enterEmailAddress(dataMap.get("email"));
	  registerpage.enterTelephone(dataMap.get("telephone"));
	  registerpage.enterPassword(dataMap.get("password"));
	  registerpage.enterConfirmPassword(dataMap.get("password"));
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() throws InterruptedException {
	    registerpage.selectPrivacyPolicy();
	    
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		
		accountSuccessPage = registerpage.clickOnContinueButton();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		 
	    Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}

	@And("User selects Yes fore Newsletter")
	public void user_selects_yes_fore_newsletter() {
		registerpage.selectYesNewsLetterOption();
	}

	@Then("User account should get a proper warning about duplicate email")
	public void user_account_should_get_a_proper_warning_about_duplicate_email() {
	   Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is Already Registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		registerpage.enterFirstName(" ");
		  registerpage.enterLastName(" ");
		  registerpage.enterEmailAddress(" ");
		  registerpage.enterTelephone(" ");
		  registerpage.enterPassword(" ");
		  registerpage.enterConfirmPassword(" ");
	}


	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	 Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));   
	Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getWarningMessageText());
	
	}
}
