package com.wrkout.framework.stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.wrkout.framework.helper.Wait.WaitHelper;
import com.wrkout.framework.settings.ObjectRepo;
import com.wrkout.helper.PageObject.LandingPage;
import com.wrkout.helper.PageObject.MovrPage;
import com.wrkout.helper.PageObject.ProspectPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateMOVRStepDef {

	
	  String random = RandomStringUtils.randomAlphabetic(3); 
	  String moverName = "TestUser";
	 
	MovrPage movrPage = new MovrPage(ObjectRepo.driver);

	
	
	@Given("^user login the application in order to create MOVR$")
	public void user_login_the_application() throws Throwable {

		movrPage.loginTheApp();

	}

	@When("^on the landing page must tap on User and then select MOVR$")
	public void on_the_landing_page_tap_on_user_and_select_movr() throws Throwable {

		movrPage.ClickUser();
		movrPage.ClickMOVR();

	}

	@Then("^tap on create new MOVR button and fill the form$")
	public void tap_on_create_new_prospect_button_and_fill_the_form() throws Throwable {

		movrPage.ClickCreateProspect();

		moverName = moverName + random;
		movrPage.sendFirstName(moverName);

		movrPage.sendLastName("Last Name");
		movrPage.sendMobileNumber("740545465465");

		movrPage.sendemailAddress(random + "email@yopmail.com");

		movrPage.sendPostal("380056");

		movrPage.sendNotes("Test NOtes");

		movrPage.SelectSourceFromDRP();

		// Thread.sleep(6000);

	}

	@And("^once MOVR record saved successfully$")
	public void once_record_saved_successfully() throws Throwable {

		movrPage.ClicksaveProspectBTTN();

	}

	@Then("^verify the MOVR data has been added into the application$")
	public void verify_the_data_has_been_added_into_the_application() throws Throwable {

		movrPage.verifyRecordInList(moverName);
		movrPage.validateData(moverName, "Last Name", "740545465465", "380056");

	}

}
