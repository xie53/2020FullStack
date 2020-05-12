package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AddressRes {
	private String zipCode;
	private String kanjiAddress;
	private String address;
	private String addressType;

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

	@Override
	public String toString() {
		return "AddressRes [zipCode=" + zipCode + ", kanjiAddress=" + kanjiAddress + ", address=" + address + ", addressType=" + addressType + "]";
	}
}
