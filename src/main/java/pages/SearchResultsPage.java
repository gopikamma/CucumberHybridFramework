package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchResultsPage 
{
	WebDriver driver;
	private ElementUtils elementutils;
	
	public SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPproduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement messageText;
	
	public boolean displayStatusOfValidProduct() {
		//return validHPproduct.isDisplayed();
		return elementutils.displayStatusOfElement(validHPproduct, 5);
	}
	
	public String getMessageText()
	{
		//return messageText.getText();
		return elementutils.getTextFromElement(messageText, 5);
	}
}
