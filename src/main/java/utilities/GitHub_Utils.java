package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHub_Utils
{
	static WebDriver driver;
	static WebDriverWait wait;
	
	public GitHub_Utils(WebDriver driver)
	{
		GitHub_Utils.driver = driver;
		wait = new WebDriverWait(driver,60);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	public void openURL()
	{
		String URL = "https://www.github.com";
		driver.get(URL);
		System.out.println("Opened "+URL+" in browser");
	}
	
	public void clickOnSignIn()
	{
		WebElement element = driver.findElement(By.xpath("//a[@href='/login']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		System.out.println("Clicked on sign-in area to provide credentials");
	}
	
	public void passUsername(String userName)
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='login_field']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(userName);
		System.out.println("Passed "+userName+" as UserName/email value");
	}
	
	public void passPassword(String password)
	{
		WebElement element = driver.findElement(By.xpath("//input[@id='password']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(password);
		System.out.println("Passed "+password+" as UserName/email value");
	}
	
	public void clickOnSignInButton()
	{
		WebElement element = driver.findElement(By.xpath("//input[@value='Sign in']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		System.out.println("Clicked on Sign-in button to sign-in to application");
	}

}
