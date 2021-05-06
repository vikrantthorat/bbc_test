
package com.wrkout.framework.interfaces;

import com.wrkout.framework.configuration.browser.BrowserType;

public interface IconfigReader {

	public String getAdminWebsite();

	public String getAdminUserName();

	public String getAdminPassword();

	public String getMOVRWebsite();

	public String getMovrUserName();

	public String getMovrPassword();

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public BrowserType getBrowser();

	public String getHomePageTitle();

	public String getFindAgentTitle();

	public String getHomeSelectionTitle();

	public String getFaqPageTitle();

	public String getAgentProposalTitle();

	public String getBuyProcessTitle();

	public String getLoanApprovalTitle();

	public String getPriceRangeTitle();

	public String getWaitTime();

}
