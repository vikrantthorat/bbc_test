package com.wrkout.framework.configreader;

import java.util.Properties;

import org.apache.log4j.Level;

import com.wrkout.framework.configuration.browser.BrowserType;
import com.wrkout.framework.interfaces.IconfigReader;
import com.wrkout.framework.utility.ResourceHelper;

public class PropertyFileReader implements IconfigReader {

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configfile/" + "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public PropertyFileReader(String fileName) {
	 * 
	 * prop = new Properties(); try { prop.load(ResourceHelper
	 * .getResourcePathInputStream("configfile/" + fileName)); } catch (Exception e)
	 * { e.printStackTrace(); } }
	 */

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String hoverUserName() {
		return prop.getProperty("Username");
	}

	public String hoverPassword() {
		return prop.getProperty("Password");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public String getWaitTime() {
		String time = prop.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");

	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DtaBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}

	public String getFirstName() {
		return prop.getProperty("firstName");
	}

	public String getLastName() {
		return prop.getProperty("lastName");
	}

	public String getGender() {
		return prop.getProperty("gender");
	}

	public String getDOB() {
		return prop.getProperty("dob");
	}

	public Level getLoggerLevel() {

		switch (prop.getProperty("Logger.Level")) {

		case "DEBUG":
			return Level.DEBUG;
		case "INFO":
			return Level.INFO;
		case "WARN":
			return Level.WARN;
		case "ERROR":
			return Level.ERROR;
		case "FATAL":
			return Level.FATAL;
		}
		return Level.ALL;
	}

	@Override
	public String getHomePageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFindAgentTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHomeSelectionTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFaqPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAgentProposalTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBuyProcessTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoanApprovalTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPriceRangeTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAdminWebsite() {

		return prop.getProperty("AdminWebsite");

	}

	@Override
	public String getAdminUserName() {

		return prop.getProperty("AdminUsername");

	}

	@Override
	public String getAdminPassword() {

		return prop.getProperty("AdminPassword");

	}

	@Override
	public String getMOVRWebsite() {

		return prop.getProperty("MOVRWebsite");

	}

	@Override
	public String getMovrUserName() {

		return prop.getProperty("MovrUserName");

	}

	@Override
	public String getMovrPassword() {

		return prop.getProperty("MovrPassword");

	}

}
