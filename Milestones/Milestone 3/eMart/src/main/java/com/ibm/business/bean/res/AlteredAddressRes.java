package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AlteredAddressRes {
	private String zipCode;
	private String kanjiAddress;
	private String address;
	private String addressType;
	private Boolean addressDeleteFlag;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getKanjiAddress() {
		return kanjiAddress;
	}

	public void setKanjiAddress(String kanjiAddress) {
		this.kanjiAddress = kanjiAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Boolean getAddressDeleteFlag() {
		return addressDeleteFlag;
	}

	public void setAddressDeleteFlag(Boolean addressDeleteFlag) {
		this.addressDeleteFlag = addressDeleteFlag;
	}

	@Override
	public String toString() {
		return "AlteredAddressRes [zipCode=" + zipCode + ", kanjiAddress=" + kanjiAddress + ", address=" + address + ", addressType=" + addressType + ", addressDeleteFlag=" + addressDeleteFlag + "]";
	}
}
