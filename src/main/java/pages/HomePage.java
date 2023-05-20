package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchboxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		//myAccountDropMenu.click();
		
		elementutils.clickOnElement(myAccountDropMenu, 5);
	}
	
	public LoginPage selectLoginOption() {
		//loginOption.click();
		elementutils.clickOnElement(loginOption, 5);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		//RegisterOption.click();
		elementutils.clickOnElement(RegisterOption, 5);
		return new RegisterPage(driver);
	}
	
	public void enterProductintoSearchBox(String productname)
	{
		//searchboxField.sendKeys(productname);
		elementutils.typeTextIntoElement(searchboxField, 5, productname);
	}
	
	public SearchResultsPage clickOnSearchButton()
	{
		elementutils.clickOnElement(searchButton, 5);
		searchButton.click();
		return new SearchResultsPage(driver);
	}
}
