package com.wrkout.helper.PageObject;

import static org.junit.Assert.assertTrue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.wrkout.framework.helper.BasePageObject.PageBase;
import com.wrkout.framework.helper.Logger.LoggerHelper;
import com.wrkout.framework.helper.Wait.WaitHelper;
import com.wrkout.framework.settings.ObjectRepo;

public class LandingPage extends PageBase {

	private WebDriver driver;
	WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);

	private final static Logger log = LoggerHelper.getLogger(LandingPage.class);

	// String random2 = RandomStringUtils.randomAlphabetic(3);

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}
	
	

	/** Web Elements */

	@FindBy(id = "email")
	@CacheLookup
	private WebElement emailAddress;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//input[@id='username']")
	@CacheLookup
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	private WebElement userPassword;

	@FindBy(xpath = "//p[contains(text(),'Log In')]")
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

	@FindBy(xpath = "//img[@src=\"/images/IF_Logo_White.svg?v=Wr8_sWXhDEojUitottz4x2sdws8QiYYNOzChWGt_hLw\"]")
	@CacheLookup
	private static WebElement welcomeScreenElement;

	@FindBy(xpath = "//img[@src=\"/images/wrkout_logo.png\"]")
	@CacheLookup
	private static WebElement welcomeScreenElementMOVR;

	@FindBy(xpath = "	//a[contains(text(),'Tool')]")
	@CacheLookup
	private static WebElement welcomeScreentool;

	@FindBy(xpath = "	//BUTTON[@id='btnManageEvent']")
	@CacheLookup
	private static WebElement createEventBttn;

	@FindBy(xpath = "//TEXTAREA[@id='Description']")
	@CacheLookup
	private static WebElement EventDesc;

	@FindBy(xpath = "//INPUT[@id='Name']")
	@CacheLookup
	private static WebElement eventName;

	@FindBy(xpath = "	//I[@class='fas fa-cog']")
	@CacheLookup
	private static WebElement welcomeScreenManager;

	@FindBy(xpath = "	//I[@class='fas fa-chevron-right']")
	@CacheLookup
	private static WebElement welcomeScreenArrow;

	@FindBy(xpath = "	(//A[@class='sidebar-link'])[5]")
	@CacheLookup
	private static WebElement welcomeEvent;

	@FindBy(xpath = "	//div[@id='loading-text']")
	@CacheLookup
	private static WebElement LOADER;

	@FindBy(xpath = "	//INPUT[@id='EndDate']")
	@CacheLookup
	private static WebElement endDate;

	@FindBy(xpath = "//input[@class='filepond--browser']")
	@CacheLookup
	private static WebElement browseBttn;

	
	@FindBy(xpath = "//A[@id='Schedule-tab']")
	@CacheLookup
	private static WebElement tabImage;

	
	
	
	private final String pageUrl = "/signin?email=";

	/** Public Methods **/

	public WebDriver getDriver() {
		return this.driver;
	}

	// Click on Create On Now button
	public void openAccountBtnClick() {
		try {
			openAccountBtn.click();
		} catch (Exception e) {
			log.info("Error while clicking Create Now One Button on login Page");
		}
	}

	// verify user landed on home page after login

	public void verifyHomePage() throws InterruptedException {

		// wHelper.hardWait(6000);
		wHelper.waitForElementToBeClickable(welcomeScreenElement);

		Assert.assertTrue(welcomeScreenElement.isDisplayed(), "Error after login, User is not able to see home page.");
		log.info("Welcome text is verified on Home Page");
	}

	// Verify user on Singin page

	public void verifylandingPageTitle() throws InterruptedException {

		//wHelper.hardWait(6000);
		
		

		wHelper.waitForElementToBeClickable(welcomeScreenElement);
		Assert.assertTrue(driver.getTitle().contains("Dashboard - WRKOUT"));
		log.info("Landing Page  title is verified on page");
	}

	public void verifylandingPageTitleMOVR() throws InterruptedException {

	//	wHelper.hardWait(6000);
	

		wHelper.waitForElementToBeClickable(welcomeScreenElementMOVR);
		Assert.assertTrue(driver.getTitle().contains("Landing - WRKOUT"));
		log.info("Landing Page  title is verified on page");
	}

	// Click on Tool
	public void openToolImageClick() throws InterruptedException {
		// try {
		// wHelper.hardWait(10000);
		// driver.navigate().refresh();
		System.out.println("Inside tool");

		By loaderLocator = By.xpath("//div[@id='loading-text']");

		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOf(LOADER)); // wait for loader to appear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator)); // wait for loader to disappear


		By tool = By.xpath("	//a[contains(text(),'Tool')]");
		wHelper.waitForPresenceOfElement(tool);
		
		//wHelper.waitForElementToBeClickable(welcomeScreentool);

		
	
		
		welcomeScreentool.click();
		// wHelper.hardWait(6000);

//	} catch (Exception e) {
		// log.info("Error while clicking Tool image in Home Page");
//	}
	}

	// Click on Manager
	public void openManagerImageClick() {
		try {
			System.out.println("Inside manager");
			
			By manager = By.xpath("//I[@class='fas fa-cog']");
			wHelper.waitForPresenceOfElement(manager);
			
		//	wHelper.waitForElementToBeClickable(welcomeScreenManager);
			welcomeScreenManager.click();
		} catch (Exception e) {
			log.info("Error while clicking Manager  in Home Page");
		}
	}

	// Click on Arrow
	/*
	 * public void openArrowClick() { try { System.out.println("Inside arrow");
	 * wHelper.waitForElementToBeClickable(welcomeScreenArrow);
	 * welcomeScreenArrow.click(); } catch (Exception e) {
	 * log.info("Error while clicking Arrow image in Home Page"); } }
	 */
	// Click on Event
	
	public void openEventClick() {
		try {

			
			By sideBarEvent = By.xpath("//SPAN[@class='sidebar-link-text'][text()='EVENTS']");
			wHelper.waitForPresenceOfElement(sideBarEvent);
			
			openEventClick2(sideBarEvent);

			
			
		} catch (Exception e) {
			log.info("Error while clicking Event in Home Page");
		}
	}

	public boolean openEventClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}
	
	
	
	
	/*
	 * public void createEventBttnClick() throws InterruptedException {
	 * 
	 * System.out.println("createEventBttnClick "); By loaderLocator =
	 * By.xpath("//div[@id='loading-text']"); WebDriverWait wait = new
	 * WebDriverWait(driver, 10000);
	 * wait.until(ExpectedConditions.visibilityOf(LOADER));
	 * 
	 * // wait for loader to appear
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
	 * // wait for loader to disappear createEventBttn.click();
	 * 
	 * }
	 */

	public void createEventBttnClick() throws InterruptedException {


		
		By crBttn = By.xpath("//BUTTON[@id='btnManageEvent']");
		
		wHelper.waitForPresenceOfElement(crBttn);

	//	wHelper.waitForElementToBeClickable(crBttn);

		createEventBttnClick2(crBttn);

	}

	public boolean createEventBttnClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void saveBTTNClick() throws InterruptedException {

		By saveBttn = By.xpath("//BUTTON[@id='btnSaveEvent']");
		
		wHelper.waitForPresenceOfElement(saveBttn);

	//	wHelper.waitForElementToBeClickable(saveBttn);

		createEventBttnClick2(saveBttn);

	}

	public boolean saveBTTNClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void backEventBttn() throws InterruptedException {

	//	Thread.sleep(4000);

		By saveBttn = By.xpath("(//I[@class='fas fa-chevron-left'])[2]");
		
		
		wHelper.waitForElementToBeClickable(saveBttn);

		
		createEventBttnClick2(saveBttn);

	}

	public boolean backEventBttn2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void addimage() throws InterruptedException {

			Thread.sleep(3000);
			By imgTab = By.xpath("//A[@id='Schedule-tab']");
			
			wHelper.waitForElementToBeClickable(imgTab);
			createEventBttnClick2(imgTab);

		String currentDirectory = System.getProperty("user.dir");
		browseBttn.sendKeys(currentDirectory + "\\TestData\\41024.jpg");

		Thread.sleep(3000);

	}

	public void openArrowClick() {
		try {
			System.out.println("Inside arrow");
			wHelper.waitForElementToBeClickable(welcomeScreenArrow);
			welcomeScreenArrow.click();
		} catch (Exception e) {
			log.info("Error while clicking Arrow image in Home Page");
		}
	}

	public void openArrowClick1() throws InterruptedException {

		//Thread.sleep(4000)
		By arrow = By.xpath("//I[@class='fas fa-chevron-right']");
		

		wHelper.waitForPresenceOfElement(arrow);
		
		
	//wHelper.waitForElementToBeClickable(arrow);

		createEventBttnClick2(arrow);

	}

	public boolean openArrowClick2(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public void eventName(String ename) {
		
		wHelper.waitForElementToBeClickable(eventName);

		eventName.sendKeys(ename);
		log.info(ename);
	}

	public void eventDescSendData(String bj) {
		EventDesc.sendKeys(bj);
		log.info(EventDesc);
	}

	/*
	 * public void endDateClick1() throws InterruptedException {
	 * 
	 * System.out.println("endDate ");
	 * 
	 * endDate.click();
	 * 
	 * }
	 */

	public void endDateClick1() throws InterruptedException {

		By endDate = By.xpath("//INPUT[@id='EndDate']");
		wHelper.waitForElementToBeClickable(endDate);

		createEventBttnClick2(endDate);

	}

	public boolean endDateClick2(By by) throws InterruptedException {

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}

	public void selectTimeFromCalander(String bj) {

		EventDesc.sendKeys(bj);
		log.info(EventDesc);
	}

	public void validateEvent(String random) throws InterruptedException {
		System.out.println("Inside Validate");

		By list = By.xpath("//ul[@class='iftb-event-row']//li//div//h5");

		verifyEventFromList(list, random, driver);

	}

	public  void verifyEventFromList(By List, String Text, WebDriver driver) throws InterruptedException {

		//System.out.println(Text +"  to match");
		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i).getText());

			if (list.get(i).getText().contentEquals(Text)) {
		
				System.out.println("match");
		
				Assert.assertEquals(Text, list.get(i).getText());

				break;

			}

		}
	}


	
	
	
	
	
	
	
	

}
