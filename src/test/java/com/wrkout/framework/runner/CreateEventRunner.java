
package com.wrkout.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/VerifyCreateEvent.feature" }, glue = {
		"classpath:com.wrkout.framework.stepdefinition",
		"classpath:com.wrkout.framework.helper" }, plugin = { "pretty", "json:target/CreateEventRunner.json" })

public class CreateEventRunner extends AbstractTestNGCucumberTests {
	
	

}
