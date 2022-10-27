package com.salesforce.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
			"json:target/cucumber-reports/cucumber.json" },
		features= {"src/test/resources/com/salesforce/feature/SalesforceFeature.feature"},
		glue= {"com.salesforce.automation.stepDef"},
		dryRun = false, // if dry run is true, it will generate missing snippet before execution whole test case
		monochrome=true,
		tags= "@regression" // it will execute only test cases that are marked regression in feature file)
		)
public class SalesforceRunner extends AbstractTestNGCucumberTests{

}