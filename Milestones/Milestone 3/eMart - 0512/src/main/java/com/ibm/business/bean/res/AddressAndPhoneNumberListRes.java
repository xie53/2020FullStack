package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AddressAndPhoneNumberListRes extends InitRemoteRes{
	private String userKanjiName;
	private String userName;
	private Boolean addressChangeableFlag;
	private List<AddressRes> address = new ArrayList<>();
	private Boolean phoneChangeableFlag;
	private List<PhoneNumberRes> phoneNumber = new ArrayList<>();
	private List<AccountInfoRes> accountInfo = new ArrayList<>();

	public String getUserKanjiName() {
		return userKanjiName;
	}

	public void setUserKanjiName(String userKanjiName) {
		this.userKanjiName = userKanjiName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getAddressChangeableFlag() {
		return addressChangeableFlag;
	}

	public void setAddressChangeableFlag(Boolean addressChangeableFlag) {
		this.addressChangeableFlag = addressChangeableFlag;
	}

	public List<AddressRes> getAddress() {
		return address;
	}

	public void setAddress(List<AddressRes> address) {
		this.address = address;
	}

	public Boolean getPhoneChangeableFlag() {
		return phoneChangeableFlag;
	}

	public void setPhoneChangeableFlag(Boolean phoneChangeableFlag) {
		this.phoneChangeableFlag = phoneChangeableFlag;
	}

	public List<PhoneNumberRes> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<PhoneNumberRes> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<AccountInfoRes> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<AccountInfoRes> accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "AddressAndPhoneNumberListRes [userKanjiName=" + userKanjiName + ", userName=" + userName + ", addressChangeableFlag=" + addressChangeableFlag 
				+ ", address=" + address + ", phoneChangeableFlag=" + phoneChangeableFlag + ", phoneNumber=" + phoneNumber + ", accountInfo=" + accountInfo + "]";
	}
}
