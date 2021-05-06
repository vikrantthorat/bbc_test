package com.wrkout.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wrkout.framework.helper.BasePageObject.PageBase;
import com.wrkout.framework.helper.Logger.LoggerHelper;




public class PlayVideoPage extends PageBase{

	private WebDriver driver;
	private final static Logger log = LoggerHelper.getLogger(PlayVideoPage.class);

	public PlayVideoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/* Web Elements */

	@FindBy(xpath = "//a[contains(text(),'Series')]")
	@CacheLookup
	private WebElement series_menu;

	@FindBy(xpath = "//a[@aria-label='Dramas']")
	@CacheLookup
	private static WebElement dramas_option;

	@FindBy(xpath="//a[@aria-label='Teenage Textbook: The Series']")
	@CacheLookup
	private static WebElement teenage_txtbook;


	@FindBy(xpath = "(//div[contains(@class, 'player-overlay')])[1]")
	@CacheLookup
	private WebElement video_player;

	@FindBy(xpath = "//button[contains(@class, 'cta-btn--primary-dark')]")
	@CacheLookup
	private WebElement watch_button;

	@FindBy(xpath = "//button[contains(@class, 'cta-btn--primary-dark')]")
	@CacheLookup
	private WebElement next_button_page1;

	@FindBy(xpath = "//button[contains(@class, 'cta-btn--primary-dark')]")
	@CacheLookup
	private WebElement next_button_page2;

	@FindBy(xpath = "//button[contains(@class, 'cta-btn--primary-dark')]")
	@CacheLookup
	private WebElement got_it_btn;

	public WebDriver getDriver() {
		return this.driver;
	}

	public void navigateToDrama() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Thread.sleep(7000);
		executor.executeScript("arguments[0].click();", next_button_page1);
		Thread.sleep(5000);
		executor.executeScript("arguments[0].click();", next_button_page2);
		Thread.sleep(5000);
		executor.executeScript("arguments[0].click();", got_it_btn);
		Thread.sleep(5000);
		executor.executeScript("arguments[0].click();", series_menu);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dramas_option));
		executor.executeScript("arguments[0].click();", dramas_option);
		Thread.sleep(3000);
		executor.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.elementToBeClickable(teenage_txtbook));
		executor.executeScript("arguments[0].click();", teenage_txtbook);
		Thread.sleep(3000);
		executor.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.elementToBeClickable(watch_button));
		executor.executeScript("arguments[0].click();", watch_button);

	}


}
