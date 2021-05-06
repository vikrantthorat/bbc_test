package com.wrkout.framework.stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;

import com.wrkout.framework.settings.ObjectRepo;
import com.wrkout.helper.PageObject.LandingPage;
import com.wrkout.helper.PageObject.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateEventStepDef {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	LandingPage landP = new LandingPage(ObjectRepo.driver);
	String random = RandomStringUtils.randomAlphabetic(3);

	@Given("^user logged in the application screen$")
	public void user_reached_on_login_screen() throws Throwable {

		ObjectRepo.driver.get(ObjectRepo.reader.getAdminWebsite());
		lp.enterUserName(ObjectRepo.reader.getAdminUserName());
		lp.enterPass(ObjectRepo.reader.getAdminPassword());
		lp.ClickSignIn();

	}

	@When("^tap on tool followed by Events$")
	public void user_enters_credentials_and_click_on_sign_in_button() throws Throwable {

		landP.openToolImageClick();
		landP.openManagerImageClick();
		landP.openArrowClick1();
		landP.openEventClick();
	}

	@Then("^fill the form and validate the record$")
	public void user_reached_must_reached_to_landing_page() throws Throwable {

		landP.createEventBttnClick();
		landP.eventName("Test EVENT " + random);

		landP.eventDescSendData("Test Description");

		landP.saveBTTNClick();

		landP.addimage();

		landP.backEventBttn();
		
		landP.validateEvent("Test EVENT " + random);

		Thread.sleep(3000); // Harcoded wait just for end user to see the browser getting closed

	}

}
