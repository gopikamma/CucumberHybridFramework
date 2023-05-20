package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement entertelephone;
	
	@FindBy(id="input-password")
	private WebElement enterpassword;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement YesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	public void enterFirstName(String firstNameText)
	{
		//firstNameField.sendKeys(firstNameText);
		elementutils.typeTextIntoElement(firstNameField, 5, firstNameText);
	}

	public void enterLastName(String lastNameText)
	{
		//lastNameField.sendKeys(lastNameText);
		elementutils.typeTextIntoElement(lastNameField, 5, lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		//emailField.sendKeys(emailText);
		elementutils.typeTextIntoElement(emailField, 5, emailText);
	}
	
	public void enterTelephone(String phno) {
		//entertelephone.sendKeys(phno);
		elementutils.typeTextIntoElement(entertelephone, 5, phno);
	}
	
	public void enterPassword(String password) {
		//enterpassword.sendKeys(password);
		elementutils.typeTextIntoElement(enterpassword, 5, password);
	}
	
	public void enterConfirmPassword(String password) {
		//confirmpassword.sendKeys(password);
		elementutils.typeTextIntoElement(confirmpassword, 5, password);
	}
	
	public void selectPrivacyPolicy()
	{
		//privacyPolicyOption.click();
		elementutils.clickOnElement(privacyPolicyOption, 5);
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		//continueButton.click();
		elementutils.clickOnElement(continueButton, 5);
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption()
	{
		//YesNewsletterOption.click();
		elementutils.clickOnElement(YesNewsletterOption, 5);
	}
	
	public String getWarningMessageText() {
		//return warningMessage.getText();
		return elementutils.getTextFromElement(warningMessage, 5);
	}
	
	public String getFirstNameWarning() {
		//return firstNameWarning.getText();
		return elementutils.getTextFromElement(firstNameWarning, 5);
	}

}
