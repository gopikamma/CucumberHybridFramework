package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage 
{
	WebDriver driver;
	private ElementUtils elementutils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warnningMessage;
	
	public void enterEmailAddress(String emailText) {
		//emailField.sendKeys(emailText);
		elementutils.typeTextIntoElement(emailField, 5, emailText);
	}
	

	public void enterPassword(String passwordText) {
		//passwordField.sendKeys(passwordText);
		elementutils.typeTextIntoElement(passwordField, 5, passwordText);
	}
	
	public AccountPage clickLogin()
	{
		//loginButton.click();
		elementutils.clickOnElement(loginButton, 5);
		return new AccountPage(driver);
	}
	
	public String getWarnningMessageText() {
		//return warnningMessage.getText();
		return elementutils.getTextFromElement(warnningMessage, 5);
	}
}
