package runner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src\\test\\java\\features\\loginTest.feature"},
					glue = {"stepdefinitions"},
					plugin = {"pretty","html:target/cucumber"})

@Test
public class MyRunnerClass extends AbstractTestNGCucumberTests
{

}
