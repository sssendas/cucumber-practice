package runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src\\test\\java\\features\\loginTest.feature"},
					glue = {"stepdefinitions"},
					plugin = {"pretty","html:target/cucumber","json:target/cucumber/Cucumber_json_report.json"})

@Test
public class MyRunnerClass extends AbstractTestNGCucumberTests
{

}
