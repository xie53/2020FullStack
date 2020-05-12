package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AlteredPhoneNumberReq {
	
	private String phoneNumber;
	private String phoneType;
	private Boolean phoneDeleteFlag;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public Boolean getPhoneDeleteFlag() {
		return phoneDeleteFlag;
	}

	public void setPhoneDeleteFlag(Boolean phoneDeleteFlag) {
		this.phoneDeleteFlag = phoneDeleteFlag;
	}

	@Override
	public String toString() {
		return "AlteredPhoneNumberReq [phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + ", phoneDeleteFlag=" + phoneDeleteFlag + "]";
	}
}
