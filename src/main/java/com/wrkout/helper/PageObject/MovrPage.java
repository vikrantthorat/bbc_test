package com.wrkout.helper.PageObject;

import static com.wrkout.constants.Constants.WAIT_EXPLICIT_SEC;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.wrkout.framework.helper.BasePageObject.PageBase;
import com.wrkout.framework.helper.DropDown.DropDownHelper;
import com.wrkout.framework.helper.Logger.LoggerHelper;
import com.wrkout.framework.helper.Wait.WaitHelper;
import com.wrkout.framework.list.ListHelper;
import com.wrkout.framework.settings.ObjectRepo;

public class MovrPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	ListHelper listHelper = new ListHelper(ObjectRepo.driver);
	DropDownHelper drpHelper = new DropDownHelper(ObjectRepo.driver);

	private final static Logger log = LoggerHelper.getLogger(MovrPage.class);

	// String random2 = RandomStringUtils.randomAlphabetic(3);

	public MovrPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Webelement **/

	@FindBy(xpath = "//a[contains(text(),'Users')]")
	@CacheLookup
	private static WebElement userss;

	// (//A[@class='nav-link ifit-underline-from-center'])[4]
	// "//a[contains(text(),'Tool')]"

	@FindBy(xpath = "(//A[@class='nav-submenu-link'])[7]")
	@CacheLookup
	private static WebElement movr;

	@FindBy(xpath = "//BUTTON[@id='btnAddClient']")
	@CacheLookup
	private static WebElement createNewMOVRBTTN;

	@FindBy(xpath = "//INPUT[@id='txtFirstName']")
	@CacheLookup
	private static WebElement firstName;

	@FindBy(xpath = "//INPUT[@id='txtLastName']")
	@CacheLookup
	private static WebElement lastName;

	@FindBy(xpath = "//INPUT[@id='txtEmail']")
	@CacheLookup
	private static WebElement emailAddress;

	@FindBy(xpath = "//INPUT[@id='txtMobile']")
	@CacheLookup
	private static WebElement mobileNumber;

	@FindBy(xpath = "//INPUT[@id='txtAddress']")
	@CacheLookup
	private static WebElement address1;

	@FindBy(xpath = "//INPUT[@id='txtPostal']")
	@CacheLookup
	private static WebElement postalNumber;

	@FindBy(xpath = "//TEXTAREA[@id='txtNotes']")
	@CacheLookup
	private static WebElement notes;

	@FindBy(xpath = "//BUTTON[@id='btnSaveProspect']")
	@CacheLookup
	private static WebElement saveMovrBTTN;

	@FindBy(xpath = "(//BUTTON[@class='dropdown-item'][text()='Details'])[1]")
	@CacheLookup
	private static WebElement prospectDetailIcon;

	@FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]")
	@CacheLookup
	private static WebElement source;

	@FindBy(xpath = "//ul[@class='dropdown-menu inner show']//li//a//span[2]")
	@CacheLookup
	private static WebElement sourceDRPList;

	By sourceBox = By.xpath("(//BUTTON[@type='button'])[7]");
	By sourceList = By.xpath("//ul[@class='dropdown-menu inner show']//li//a//span[2]");

	//////////////////////////////////////////////////////////////////////////////
	// Methods

	public static WebElement getWebElement(By Xpath) {

		WebElement webElement = ObjectRepo.driver.findElement(Xpath);

		return webElement;
	}

	public void loginTheApp() {

		LoginAdminApp();
		System.out.println("Inside loginTheApp completed");

	}

	public void ClickUser() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		System.out.println("User Click");
		wHelper.waitForElementToBeClickable(userss);
		userss.click();

		log.info(userss);
	}

	public void ClickMOVR() throws InterruptedException {

		wHelper.waitForElementToBeClickable(movr);

		movr.click();

		log.info(movr);

	}

	public void ClickCreateProspect() throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(createNewMOVRBTTN);
		createNewMOVRBTTN.click();
		log.info(createNewMOVRBTTN);

		wHelper.waitForVisibilityLoader();
		wHelper.waitForElementToBeClickable(firstName);

	}

	public void sendFirstName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(firstName);
		firstName.sendKeys(keysToSend);

	}

	public void sendLastName(CharSequence... keysToSend) {

		wHelper.waitForVisibility(lastName);

		lastName.sendKeys(keysToSend);

	}

	public void sendemailAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(emailAddress);

		emailAddress.sendKeys(keysToSend);

	}

	public void sendMobileNumber(CharSequence... keysToSend) {

		wHelper.waitForVisibility(mobileNumber);

		mobileNumber.sendKeys(keysToSend);

	}

	public void sendAddress(CharSequence... keysToSend) {

		wHelper.waitForVisibility(address1);

		address1.sendKeys(keysToSend);

	}

	public void sendPostal(CharSequence... keysToSend) {

		wHelper.waitForVisibility(postalNumber);

		postalNumber.sendKeys(keysToSend);

	}

	public void sendNotes(CharSequence... keysToSend) {

		wHelper.waitForVisibility(notes);

		notes.sendKeys(keysToSend);

	}

	public void ClicksaveProspectBTTN() throws InterruptedException {

		saveMovrBTTN.click();
		log.info(saveMovrBTTN);

	}

	public void SelectSourceFromDRP() throws InterruptedException {

		drpHelper.selectDataFromListOfDRP(sourceList, "Phone", sourceBox);

	}

	By tableList = By.xpath("//table[@id ='tblClientList']//tr//td[1]");

	public void verifyRecordInList(String Text) throws InterruptedException {

		wHelper.waitForVisibilityLoader();
		wHelper.waitForVisbleOfElement(createNewMOVRBTTN);
		listHelper.goToMOVRDetailScreen(Text, tableList);

		ClickDetail();

	}

	public void ClickDetail() throws InterruptedException {

		wHelper.waitForElementToBeClickable(prospectDetailIcon);
		prospectDetailIcon.click();

		log.info(prospectDetailIcon);
	}

	public void validateData(String Name, String LastName, String MobileNumber, String PostalCode)
			throws InterruptedException {

		By firstNameBy = By.xpath("//INPUT[@id='txtFirstName']");
		By lastnameBY = By.xpath("//INPUT[@id='txtLastName']");
		By PostalBy = By.xpath("//INPUT[@id='txtPostalcode']");
		By mobileNumberBY = By.xpath("//INPUT[@id='txtMobile']");
		
		Assert.assertEquals(wHelper.handleStaleElement(firstNameBy, 5, 20).getAttribute("Value"), Name);
		Assert.assertEquals(wHelper.handleStaleElement(lastnameBY, 5, 20).getAttribute("Value"), LastName);
		Assert.assertEquals(wHelper.handleStaleElement(mobileNumberBY, 5, 20).getAttribute("Value"), MobileNumber);
		Assert.assertEquals(wHelper.handleStaleElement(PostalBy, 5, 20).getAttribute("Value"), PostalCode);
	
	}

}
