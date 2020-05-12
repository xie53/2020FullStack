package com.ibm.business.bean.req;

import java.util.Date;

import com.ibm.business.util.DateUtil;

/**
* BFFDigital
* @author ShiYan Jun 10, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteAddressChangeReq {

	private String bankCode;
	private String deviceID;
	private String searchKey;
	private String maxRowNumber;

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

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getMaxRowNumber() {
		return maxRowNumber;
	}

	public void setMaxRowNumber(String maxRowNumber) {
		this.maxRowNumber = maxRowNumber;
	}

	@Override
	public String toString() {
		return "AddressChangeReq [bankCode=" + bankCode + ", deviceID=" + deviceID + ", searchKey="
				+ searchKey + ", maxRowNumber=" + maxRowNumber + "]";
	}
}
