
package com.wrkout.framework.helper.Wait;

import static com.wrkout.constants.Constants.WAIT_EXPLICIT_SEC;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import com.wrkout.framework.helper.Generic.GenericHelper;
import com.wrkout.framework.helper.Javascript.JavaScriptHelper;
import com.wrkout.framework.helper.Logger.LoggerHelper;
import com.wrkout.framework.interfaces.IconfigReader;
import com.wrkout.framework.settings.ObjectRepo;
import org.openqa.selenium.JavascriptExecutor;

public class WaitHelper extends GenericHelper {

	private WebDriver driver;
	private IconfigReader reader;
	private Logger oLog = LoggerHelper.getLogger(WaitHelper.class);

	By loaderLocator = By.xpath("//div[@id='loading-text']");

	By delPopUpLocator = By.xpath("//div[@id='ifct-uc-medicalnote-deletebox']//div[@class='modal-content']");
	
	
	
	
	public WaitHelper(WebDriver driver, IconfigReader reader) {
		super(driver);
		this.driver = driver;
		this.reader = reader;
		oLog.debug("WaitHelper : " + this.driver.hashCode());
	}

	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		oLog.debug("");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public void setImplicitWait(long timeout, TimeUnit unit) {
		oLog.info(timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

	public void waitForElementVisible(By locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}

	public void waitForElementVisible2(WebElement welcomeScreenElement, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		oLog.info(welcomeScreenElement);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement((By) welcomeScreenElement)));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}

	public void hardWait(int timeOutInMiliSec) throws InterruptedException {
		oLog.info(timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}

	public WebElement handleStaleElement(By locator, int retryCount, int delayInSeconds) throws InterruptedException {
		oLog.info(locator);
		WebElement element = null;

		while (retryCount >= 0) {
			try {
				element = driver.findElement(locator);
				System.out.println("element found");
				return element;
			} catch (StaleElementReferenceException e) {
				System.out.println("stale exception");
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}

	public void elementExits(By locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}

	public void elementExistAndVisible(By locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
		new JavaScriptHelper(driver).scrollIntoView(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);

	}

	public void waitForIframe(By locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
		oLog.info(locator);
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		driver.switchTo().defaultContent();
		setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
	}

	private Function<WebDriver, Boolean> elementLocatedBy(final By locator) {
		return new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				oLog.debug(locator);
				return driver.findElements(locator).size() >= 1;
			}
		};
	}
	
	
	public  void waitForVisbleOfElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);

	}
	


	public  void waitForElementToBeClickable(WebElement webElement) {
		
		System.out.println("waitForElementToBeClickable");
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));

	}
	

	public void waitForElementToBeClickable(By One, WebElement Two) {

		System.out.println("waitForElementToBeClickable");
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(Two));

		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(null)));
		if (invisible) {

			Two.click();

		}

	}
	
	
	public void waitForElementToBeClickableAndClick(WebElement element) {


		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		//Wait till "Cancel" button is showing up. At cases, it may take some time.
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor)ObjectRepo.driver).executeScript("arguments[0].click()", el); 
	
	
	
	
	}

	
	public void waitForElementToBeClickableAndClick(By elementBY) {

System.out.println("inside waitForElementToBeClickableAndClick");

System.out.println(elementBY +"Element to be clicked");
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		//Wait till "Cancel" button is showing up. At cases, it may take some time.
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(elementBY));
		((JavascriptExecutor)ObjectRepo.driver).executeScript("arguments[0].click()", el); 
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	public  void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));
		
	}
	
	public  void waitForPresenceOfElement(By Xpath) {

		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.presenceOfElementLocated(Xpath));

	}
	

	public  void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, WAIT_EXPLICIT_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public  void waitForVisibilityLoader() throws InterruptedException {
		 try {
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	Thread.sleep(2000);
	//System.out.println("beforevisibility loader");
	
	WebElement webElement = driver.findElement(loaderLocator);

	wait.until(ExpectedConditions.visibilityOf(webElement)); // wait for loader to appear
	wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator)); // wait for loader to disappear
		 } catch (org.openqa.selenium.TimeoutException e) {
			 //System.out.println("timeout exxception catch");
		    }
		 catch(org.openqa.selenium.StaleElementReferenceException e1) {
				//System.out.println("beforevisibility loader catch");
			 handleStaleElement(loaderLocator,5,5);
			 
			 waitForVisibilityLoader();
			 

		 } catch (org.openqa.selenium.NoSuchElementException e) {
			// System.out.println("no such catch");
			 waitForVisibilityLoader();
		    }
		 
	}
	
	public  void waitForDeletePopup() throws InterruptedException {
		 try {
	WebDriverWait wait = new WebDriverWait(driver, 5000);
System.out.println("beforevisibility pop-up");
	
	WebElement webElement = driver.findElement(delPopUpLocator);

	wait.until(ExpectedConditions.visibilityOf(webElement)); // wait for loader to appear
	wait.until(ExpectedConditions.invisibilityOfElementLocated(delPopUpLocator)); // wait for loader to disappear
		 } catch (org.openqa.selenium.TimeoutException e) {
			 System.out.println("timeout exxception catch");
		    }
		 catch(org.openqa.selenium.StaleElementReferenceException e1) {
				System.out.println("beforevisibility pop-up catch");
			// handleStaleElement(loaderLocator,5,5);
			 
			// waitForVisibilityLoader();
			 

		 } catch (org.openqa.selenium.NoSuchElementException e) {
			 System.out.println("no such catch");
		//	 waitForVisibilityLoader();
		    }
		 
	}
	


	
	
	

	

}
