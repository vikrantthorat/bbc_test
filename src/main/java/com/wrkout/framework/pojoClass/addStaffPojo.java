package com.wrkout.framework.pojoClass;

import java.util.ArrayList;

public class addStaffPojo {
	
	private String selectCalender;
	
	private ArrayList<String> selectDateWiseHours;

	public ArrayList<String> getSelectDateWiseHours() {
		return selectDateWiseHours;
	}

	public void setSelectDateWiseHours(ArrayList<String> listHours) {
		this.selectDateWiseHours = listHours;
	}

	public String getSelectCalender() {
		return selectCalender;
	}

	public void setSelectCalender(String selectCalender) {
		this.selectCalender = selectCalender;
	}

}
