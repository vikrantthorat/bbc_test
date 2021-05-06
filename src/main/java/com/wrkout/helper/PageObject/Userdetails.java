
package com.wrkout.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.wrkout.framework.configreader.PropertyFileReader;
import com.wrkout.framework.helper.BasePageObject.PageBase;
import com.wrkout.framework.helper.Logger.LoggerHelper;



public class Userdetails extends PageBase {

	private static WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(Userdetails.class);

	public Userdetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/** Region Webelement **/

	@FindBy(css = "//span[contains(text(),'Back to Sign In')]")
	@CacheLookup
	private WebElement backToSignIn;

	@FindBy(xpath = "//h2[@class=\"register-step1__form-title\"]")
	@CacheLookup
	private static WebElement crateYourAccountTitle;

	@FindBy(id = "email")
	@CacheLookup
	private static WebElement email;

	@FindBy(id = "password")
	@CacheLookup
	private static WebElement password;

	@FindBy(id = "confirmPassword")
	@CacheLookup
	private static WebElement confirmPassword;

	@FindBy(id = "firstName")
	@CacheLookup
	private static WebElement firstName;

	@FindBy(id = "lastName")
	@CacheLookup
	private static WebElement lastName;

	@FindBy(css = "button.select__button")
	@CacheLookup
	private static WebElement gender;

	@FindBy(xpath = "//div[@id=\"episodeSortingContainer\"]//li[2]")
	@CacheLookup
	private static WebElement dropDownValue;

	@FindBy(xpath = "//div[contains(text(),'Date of Birth')]")
	@CacheLookup
	private static WebElement dateofBirth;

	private final String pageUrl = "/register";

	@FindBy(name = "setUpPIN")
	@CacheLookup
	private WebElement setUpAnAccountPinOptionaldate;

	@FindBy(name = "confirmAge")
	@CacheLookup
	private WebElement confirAge;

	@FindBy(name = "day")
	@CacheLookup
	private static WebElement thisProductsOrServicesProvidedAre1;

	@FindBy(name = "month")
	@CacheLookup
	private static WebElement thisProductsOrServicesProvidedAre2;

	@FindBy(name = "year")
	@CacheLookup
	private static WebElement thisProductsOrServicesProvidedAre3;

	@FindBy(name = "termsCondition")
	@CacheLookup
	private static WebElement thisProductsOrServicesProvidedAre4;

	@FindBy(xpath = "//div[@class=\"form form-white register-form register-step1\"]//div[@class=\"account-btn__spinner-container\"]")
	@CacheLookup
	private static WebElement submitBtn;

	static PropertyFileReader configread = new PropertyFileReader();
	

	/**
	 * Region Public
	 * 
	 * @throws InterruptedException
	 **/
	
	public WebDriver getDriver() {
		return this.driver;
	}

	// Verify page title
	public void verifyCreateAccounttitle() throws InterruptedException {

		Thread.sleep(5000);
		Assert.assertTrue(crateYourAccountTitle.isDisplayed(), "Create your meCONNECT account title is not displayed.");
		log.info("Create your meCONNECT account title is verified on page");
	}
	
	// Enter details require to create account
	public void EnterDetailsForAccountCreation() {
		//tbh.sendKeys(By.id("email"), configread.getUserName());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		email.sendKeys(configread.getUserName());
		password.sendKeys(configread.getPassword());
		confirmPassword.sendKeys(configread.getPassword());
		firstName.sendKeys(configread.getFirstName());
		lastName.sendKeys(configread.getLastName());
		gender.click();
		dropDownValue.click();
		// dateofBirth.sendKeys(configread.getDOB());
		thisProductsOrServicesProvidedAre1.sendKeys("10");
		thisProductsOrServicesProvidedAre2.sendKeys("10");
		thisProductsOrServicesProvidedAre3.sendKeys("1990");
		//thisProductsOrServicesProvidedAre4.click();
		executor.executeScript("arguments[0].click();", thisProductsOrServicesProvidedAre4);
		// Alternate Way to select check Box
		// checkBox.selectCheckBox(thisProductsOrServicesProvidedAre4);
		executor.executeScript("arguments[0].click();", submitBtn);
		//submitBtn.click();
	}

}
