package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class PlannedDatesRes extends InitRemoteRes{
	private String plannedDates;
	
	public String getPlannedDates() {
		return plannedDates;
	}

	public void setPlannedDates(String plannedDates) {
		this.plannedDates = plannedDates;
	}

	@Override
	public String toString() {
		return "PlannedDatesRes [plannedDates=" + plannedDates + "]";
	}
}
