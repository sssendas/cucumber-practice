package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import utilities.UIUtils;

public class loginStepStepdefinition
{
	static WebDriver driver = null;
	static WebDriverWait wait = null;
	
	@Given("^Load Browser$")
	public void loadBrowser()
	{
		driver = new UIUtils().driverInitiator();
		String URL = "https://www.amazon.in";
		driver.get(URL);
		wait = new WebDriverWait(driver, 60);
		System.out.println("Openned "+URL+" in web browser");
	}
	
	@Then("^Click to Login Area$")
	public void click_to_login()
	{
		WebElement element = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		System.out.println("Clicked on login area to login");
	}
	
	
	@Then("^Give Username as \"(.*)\"$")
	public void enter_username(String userName)
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='ap_email']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(userName);
		System.out.println("Passed "+userName+" as User Name");
	}
	
	@And("^Click on Continue button$")
	public void click_continue_after_username()
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='continue']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		System.out.println("Clicked on continue button after passing username");
	}
	
	@Then("^Enter Password as \"(.*)\"$")
	public void enter_password(String password)
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='ap_password']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(password);
		System.out.println("Passed "+password+" as password");
	}
	
	@And("^Check keep me signed in checkbox$")
	public void keep_me_signedIn()
	{
		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		if(element.isSelected())
		{
			System.out.println("Check Box is already selected");
		}
		else
		{
			System.out.println("Check Box is not pre-selected");
			element.click();
			System.out.println("Check Box is selected now");
		}
		
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	@And ("^Click on Login button$")
	public void click_on_login_button()
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		System.out.println("Clicked on sign-in button after passing password");
	}
	
	
	@Then("^Enter below as username$")
	public void enter_username(DataTable data)
	{
		List<List<String>> rawData = data.cells();
		String userName = rawData.get(0).get(0).toString();
		WebElement element = driver.findElement(By.xpath("//input[@id='ap_email']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(userName);
		System.out.println("Passed "+userName+" as User Name");
		
	}
	
	@Then("^Enter below as password$")
	public void enter_password(DataTable data)
	{
		List<List<String>> rawData = data.cells();
		String password = rawData.get(0).get(0).toString();
		WebElement element = driver.findElement(By.xpath("//input[@id='ap_password']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(password);
		System.out.println("Passed "+password+" as User Name");
	}

}
