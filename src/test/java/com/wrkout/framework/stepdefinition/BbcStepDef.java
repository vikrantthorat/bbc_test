package com.wrkout.framework.stepdefinition;

import com.wrkout.framework.settings.ObjectRepo;
import com.wrkout.helper.PageObject.LandingPage;
import com.wrkout.helper.PageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	LandingPage landP = new LandingPage(ObjectRepo.driver);

	@Given("^user reached on login screen$")
	public void user_reached_on_login_screen() throws Throwable {

		ObjectRepo.driver.get(ObjectRepo.reader.getAdminWebsite());

	}

	@When("^user enters credentials and click on Sign in button$")
	public void user_enters_credentials_and_click_on_sign_in_button() throws Throwable {

		lp.enterUserName(ObjectRepo.reader.getAdminUserName());
		lp.enterPass(ObjectRepo.reader.getAdminPassword());
		lp.ClickSignIn();

	}

	@Then("^user must reached to  landing page validate by title$")
	public void user_reached_must_reached_to_landing_page() throws Throwable {

		landP.verifylandingPageTitle();

	}

	@Given("^MOVR user reached on login screen$")
	public void movr_user_reached_on_login_screen() throws Throwable {

		ObjectRepo.driver.get(ObjectRepo.reader.getMOVRWebsite());

	}

	@When("^MOVR user enters credentials and click on Sign in button$")
	public void movr_user_enters_credentials_and_click_on_sign_in_button() throws Throwable {

		lp.enterUserName(ObjectRepo.reader.getMovrUserName());
		lp.enterPass(ObjectRepo.reader.getMovrPassword());
		lp.ClickSignIn();

	}

	@Then("^user  must reached to  landing page of MOVR application  validate by title$")
	public void user_reached_must_reached_to_landing_page_of_movr_application() throws Throwable {

		landP.verifylandingPageTitleMOVR();

	}

	
}
