package com.wrkout.helper.PageObject;

import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wrkout.framework.helper.BasePageObject.PageBase;
import com.wrkout.framework.helper.Logger.LoggerHelper;

public class LoginPage extends PageBase {

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		

	}

	/** Web Elements */

	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	private WebElement emailAddress;
	
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement password;
	
	

	
	@FindBy(xpath = "//button[@id='next']")
	@CacheLookup
	private WebElement signInButton;

	@FindBy(css = "a.profile-pin-input__forgot-pin")
	@CacheLookup
	private WebElement forgotPin;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	@CacheLookup
	private WebElement forgotYourPassword;

	@FindBy(xpath = "//div[@class=\"sign-in-form__tertiary-actions\"]")
	@CacheLookup
	private static WebElement openAccountBtn;

	@FindBy(xpath = "//div[@class=\"welcome-screen__title\"]")
	@CacheLookup
	private static WebElement welcomeScreenElement;

	private final String pageUrl = "/signin?email=";



	/** Public Methods  **/

	public WebDriver getDriver() {
		return this.driver;
	}

	public void enterUserName(String username) {
		emailAddress.sendKeys(username);
		log.info(username);
	}

	public void enterPass(String userpwd) {
		password.sendKeys(userpwd);
		log.info(password);
	}

	/**
	 * Click on Sign In Button.
	 *
	 * @return the login class instance.
	 */
	public void ClickSignIn() {
		signInButton.click();
		log.info(signInButton);
	}

	//Verify user on Singin page
	/*
	 * public void verifySigninPageTitle() {
	 * Assert.assertTrue(LoginTitle.isDisplayed()
	 * ,"Login page title is not displayed");
	 * log.info("Sing in page title is verified on page"); }
	 */

	//Click on Create On Now button
	public void openAccountBtnClick()
	{
		try {
			openAccountBtn.click();
		}catch(Exception e)
		{
			log.info("Error while clicking Create Now One Button on login Page");
		}
	}

	//verify user landed on home page after login

	public void verifyHomePage()
	{
		Assert.assertTrue(welcomeScreenElement.isDisplayed(), "Error after login, User is not able to see home page.");
		log.info("Welcome text is verified on Home Page");
	}

}
