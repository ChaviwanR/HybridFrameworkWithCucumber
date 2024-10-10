package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin = {"pretty", "html:src/test/resources/reports/cucumber-reports.html"},
			features = "src/test/resources/featuresFile",
			glue = "StepDefinitions",
			dryRun = false,
			tags = "@smokeTest"
		
		
		
		
		
		)

public class SmokeRunner {

}
