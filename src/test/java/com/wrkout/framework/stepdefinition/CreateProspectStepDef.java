package com.wrkout.framework.stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.wrkout.framework.helper.Wait.WaitHelper;
import com.wrkout.framework.settings.ObjectRepo;
import com.wrkout.helper.PageObject.LandingPage;
import com.wrkout.helper.PageObject.ProspectPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateProspectStepDef {
	
	String random = RandomStringUtils.randomAlphabetic(3);
	String UserName = "TestUser";
	ProspectPage prosPage= new ProspectPage(ObjectRepo.driver);
	
	
	  @Given("^user login the app$") 
	  public void user_login_the_application() throws Throwable {
		  
		  prosPage.loginTheApp();
	  
	  }
	 
	
	
    @When("^on the landing page tap on User and select MOVR$")
    public void on_the_landing_page_tap_on_user_and_select_movr() throws Throwable {
         

    	prosPage.ClickUser();
    	prosPage.ClickMOVR();

    	
    }

    @Then("^tap on create new prospect button and fill the form$")
    public void tap_on_create_new_prospect_button_and_fill_the_form() throws Throwable {
         
   
    	
    	prosPage.ClickCreateProspect();
   
    	UserName= UserName +random;
    	prosPage.sendFirstName(UserName);
       	
       	
    	prosPage.sendLastName("Last Name");
    	prosPage.sendMobileNumber("740545465465");
 
    	prosPage.sendemailAddress(random+"email@yopmail.com");

    	prosPage.sendPostal("380056");
    	
    	prosPage.sendNotes("Test NOtes");

    	prosPage.SelectSourceFromDRP();
    	
    	//Thread.sleep(6000);
    	
    }
    
    
    @And("^once record saved successfully$")
    public void once_record_saved_successfully() throws Throwable {

    	prosPage.ClicksaveProspectBTTN();
    	
    	
    	
    }

    @Then("^verify the data has been added into the application$")
    public void verify_the_data_has_been_added_into_the_application() throws Throwable {
    	
    	
    	
    	prosPage.verifyRecordInList(UserName);
    	prosPage.validateData( UserName, "Last Name", "740545465465", "380056", "Test NOtes");

    	
         
    }


	
	
	
	
	
	
}
