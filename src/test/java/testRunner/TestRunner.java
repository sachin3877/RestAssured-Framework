package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = {
		"stepDefination" },plugin="json:target/jsonReports/cucumber-report.json", monochrome = true, dryRun = false)
public class TestRunner {

}
