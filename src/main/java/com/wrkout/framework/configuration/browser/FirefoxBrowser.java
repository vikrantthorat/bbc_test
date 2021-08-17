
package com.wrkout.framework.configuration.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wrkout.framework.utility.ResourceHelper;

/**
 * @author krana
 *
 */
public class FirefoxBrowser {
	
	public Capabilities getFirefoxCapabilities() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
		
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("goog:loggingPrefs", logPrefs);
		firefox.setCapability("marionette", true);
		return firefox;
	}
	
	public WebDriver getFirefoxDriver(Capabilities cap) {
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("driver/geckodriver.exe"));
		return new FirefoxDriver(cap);
	}
	
	public WebDriver getFirefoxDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl),cap);
	}

}
