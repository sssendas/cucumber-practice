package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import utilities.GitHub_Utils;
import utilities.UIUtils;

public class GitHubFeature_StepDefinition 
{
	public static WebDriver driver = null;
	public static GitHub_Utils ghUtils = null;
	
	
//	Using cucumber hook
	@Before
	public void initiator()
	{
		System.out.println("Executing cucumber hook before each feature. Not a good thing to use.");

	}
	
	@Given("Open Github URL")
	public void open_GH_URL()
	{
//		
		if(UIUtils.driver==null)
		{
			driver = new UIUtils().driverInitiator();
		}
		else
		{
			driver = UIUtils.driver;
		}
		
		ghUtils = new GitHub_Utils(driver);
		ghUtils.openURL();
	}
	
	@Then("Click on Sign-In Area")
	public void click_On_SignIn()
	{
		ghUtils.clickOnSignIn();
	}
	
	@And("Pass below as credentials")
	public void enterCredentials(DataTable creds)
	{
		List<Map<String, String>> allCreds = creds.asMaps(String.class, String.class);
		for(Map<String, String> eachCreds : allCreds)
		{
			ghUtils.passUsername(eachCreds.get("email"));
			ghUtils.passPassword(eachCreds.get("password"));
		}
	}
	
	@Then("Click on Sing in button")
	public void click_On_Signin_Button()
	{
		ghUtils.clickOnSignInButton();
	}

}
