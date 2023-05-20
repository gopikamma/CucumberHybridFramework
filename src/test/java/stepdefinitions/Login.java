package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	private LoginPage loginpage;
	private AccountPage accountPage;
	private CommonUtils commonutils;
	
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	
		loginpage.enterEmailAddress(emailText);  
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	    loginpage.enterPassword(passwordText);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage = loginpage.clickLogin();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	  
	  Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	  
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		commonutils = new CommonUtils();
		loginpage.enterEmailAddress(commonutils.getEmailWithTimeStamp());
		
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
	}

	@Then("User should get a proper worning message about credentials mismatch")
	public void user_should_get_a_proper_worning_message_about_credentials_mismatch() {
	    Assert.assertTrue(loginpage.getWarnningMessageText().contains("Warning: No match for E-Mail Address and/or Password"));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(" ");
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		 loginpage.enterPassword(" ");
	}

	
	
}
