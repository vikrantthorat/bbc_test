
package com.wrkout.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/VerifyStaffMember.feature" }, glue = {
		"classpath:com.wrkout.framework.stepdefinition",
		"classpath:com.wrkout.framework.helper" }, plugin = { "pretty", "json:target/CreateStaffRunner.json" })

public class CreateStaffRunner extends AbstractTestNGCucumberTests {
	
	

}

