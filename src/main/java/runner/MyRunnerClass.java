package runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
					features =	{
				
									"src\\test\\java\\features\\loginTest.feature",
									"src\\test\\java\\features\\Scenario_Outline.feature",
									"src\\test\\java\\features\\DataTable-Test.feature",
									"src\\test\\java\\\\features\\Git-Hub_MapFormat.feature"
								},
					glue = {"stepdefinitions"},
					plugin = {"pretty","html:target/cucumber","json:target/cucumber/Cucumber_json_report.json"},
					dryRun = false,
					monochrome = true,
					tags = {"@Smoke"})

@Test
public class MyRunnerClass extends AbstractTestNGCucumberTests
{
	
}
