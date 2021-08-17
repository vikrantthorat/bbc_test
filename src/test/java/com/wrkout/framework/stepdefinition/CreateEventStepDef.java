package com.wrkout.framework.stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;

import com.wrkout.framework.helper.Wait.WaitHelper;
import com.wrkout.framework.settings.ObjectRepo;
import com.wrkout.helper.PageObject.EventPage;
import com.wrkout.helper.PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateEventStepDef {

	EventPage ePage = new EventPage(ObjectRepo.driver);
	WaitHelper whelper = new WaitHelper(ObjectRepo.driver, null);
	
	String random = RandomStringUtils.randomAlphabetic(3);

	@Given("^user logged in the application screen$")
	public void user_reached_on_login_screen() throws Throwable {

		ePage.loginTheApp();

	}

	@When("^tap on tool followed by Events$")
	public void user_enters_credentials_and_click_on_sign_in_button() throws Throwable {

		ePage.openToolImageClick();
		ePage.openManagerImageClick();
		ePage.sideMenu();
		ePage.openEventMenu();
	}

	@Then("^fill the form and validate the record$")
	public void user_reached_must_reached_to_landing_page() throws Throwable {

		ePage.createEventBttnClick();
		ePage.eventName("Test EVENT " + random);
		ePage.eventDescSendData("Test Description");
		ePage.addimage();
		
		System.out.println("Firts call");
		ePage.saveBTTNClick();
			
		whelper.waitForVisibilityLoader();
		System.out.println("second call");

		ePage.saveBTTNClick();

		ePage.validateEvent("Test EVENT " + random);
		//ePage.backEventBttn();
		
		Thread.sleep(5000); // Harcoded wait just for end user to see the browser getting closed

	}

}
