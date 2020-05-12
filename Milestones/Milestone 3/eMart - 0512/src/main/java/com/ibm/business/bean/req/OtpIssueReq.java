package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class OtpIssueReq {
	
	private String bankCode;
	private String deviceID;
	private String telephoneNumber;

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public String toString() {
		return "OtpIssueReq [bankCode=" + bankCode + ", deviceID=" + deviceID + ", telephoneNumber=" + telephoneNumber + "]";
	}
}
