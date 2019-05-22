package stepdefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import utilities.UIUtils;

public class BrowserTerminatorOnly 
{
	@Then("^Close the browser$")
	public void quit_browser()
	{
		WebDriver driver = UIUtils.driver;
		UIUtils.driver=null;
		driver.quit();
		System.out.println("Closed the browser after test run");
	}

}
