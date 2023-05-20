package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils 
{
	WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickOnElement(WebElement element,long DurationInsec)
	{
		
		WebElement ele = waitForElement(element,DurationInsec);
		ele.click();
	}
	
	public void typeTextIntoElement(WebElement element,long DurationInsec, String textTobeTyped) {
		
		WebElement ele = waitForElement(element,DurationInsec);
		ele.click();
		ele.clear();
		ele.sendKeys(textTobeTyped);
	}
	
	public WebElement waitForElement(WebElement element,long DurationInsec )
	{
		WebElement webElement = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInsec));
		webElement =  wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e) 
		{
			e.printStackTrace();
		
		}
		
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption, long DurationInSec)
	{
		WebElement ele = waitForElement(element, DurationInSec);
		Select select = new Select(ele);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSec) {
		Alert alert = waitForAlert(durationInSec);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSec) {
		Alert alert = waitForAlert(durationInSec);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSec)
	{
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverandClick(WebElement element, long durationInSec) {
		

		WebElement ele = waitForVisibilityOfElement(element, durationInSec);
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSec) {
		WebElement ele = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
		ele = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ele;
	}
	public void javascriptClick(WebElement element, long durationInSec) {
		WebElement ele = waitForVisibilityOfElement(element, durationInSec);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void javascriptType(WebElement element, long durationInSec, String textTobeTyped) {
		WebElement ele = waitForVisibilityOfElement(element, durationInSec);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].value='"+textTobeTyped+"'", ele);
	}
	
	public String getTextFromElement(WebElement element, long durationInSec)
	{
		WebElement ele = waitForElement(element, durationInSec);
		return ele.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSec) {
		try {
		WebElement ele = waitForVisibilityOfElement(element, durationInSec);
		return ele.isDisplayed();
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
