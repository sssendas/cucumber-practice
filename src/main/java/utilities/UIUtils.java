package utilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class UIUtils
{
	public static WebDriver driver = null;
	public WebDriver driverInitiator()
	{
		
		
		Properties prop = new PropertyReader().propertyReader();
		
		String browser = prop.getProperty("browser");
		System.out.println("Browser value provided as "+browser+" in property file");
		
		if(browser.equalsIgnoreCase("chrome")||browser.equalsIgnoreCase("firefox")||browser.equalsIgnoreCase("ie")
				||browser.equalsIgnoreCase("chromeheadless")||browser.equalsIgnoreCase("firefoxheadless"))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Initiated chrome-driver as driver");
			}
			
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Initiated Firefox-driver as driver");
			}
			
			if(browser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver","src/main/resources/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				System.out.println("Initiated IE-driver as driver");
			}
			if(browser.equalsIgnoreCase("chromeheadless"))
			{
				System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
				ChromeOptions chops = new ChromeOptions();
				chops.addArguments("--headless");
				
//				or
//				chops.setHeadless(true);
				
				driver = new ChromeDriver(chops);
				System.out.println("Initiated ChromeHedless-driver as driver");
			}
			if(browser.equalsIgnoreCase("firefoxheadless"))
			{
				System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
				FirefoxOptions ffops = new FirefoxOptions();
				ffops.setHeadless(true);
				
//				or
//				ffops.addArguments("--headless");
				
				driver = new FirefoxDriver(ffops);
				System.out.println("Initiated FirefoxHeadless-driver as driver");
			}
		}
		else
		{
			System.out.println("Wrong browser value has been kept in config.properties file");
		}
		
		return driver;
	}

}
