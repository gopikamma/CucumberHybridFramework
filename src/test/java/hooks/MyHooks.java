package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.*;
import utils.ConfigReader;

public class MyHooks {
	
	WebDriver driver;
	private ConfigReader configreader;
	
	
	@Before
	public void setup() throws IOException
	{
		configreader = new ConfigReader();
		Properties prop = configreader.initializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed())
		{
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		driver.quit();
	}

}
