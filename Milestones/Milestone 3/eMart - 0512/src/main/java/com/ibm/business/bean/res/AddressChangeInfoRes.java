package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AddressChangeInfoRes {
	private String zipcode;
	private String addressForDisplay;
	private String addressKnForDisplay;
	private String address;
	private String additionalAddress;
	private String addressKn;
	private String additionalAddressKn;
	private Boolean addressCodeDuplicationFlag;
	private String addressCode;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressForDisplay() {
		return addressForDisplay;
	}

	public void setAddressForDisplay(String addressForDisplay) {
		this.addressForDisplay = addressForDisplay;
	}

	public String getAddressKnForDisplay() {
		return addressKnForDisplay;
	}

	public void setAddressKnForDisplay(String addressKnForDisplay) {
		this.addressKnForDisplay = addressKnForDisplay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdditionalAddress() {
		return additionalAddress;
	}

	public void setAdditionalAddress(String additionalAddress) {
		this.additionalAddress = additionalAddress;
	}

	public String getAddressKn() {
		return addressKn;
	}

	public void setAddressKn(String addressKn) {
		this.addressKn = addressKn;
	}

	public String getAdditionalAddressKn() {
		return additionalAddressKn;
	}

	public void setAdditionalAddressKn(String additionalAddressKn) {
		this.additionalAddressKn = additionalAddressKn;
	}

	public Boolean getAddressCodeDuplicationFlag() {
		return addressCodeDuplicationFlag;
	}

	public void setAddressCodeDuplicationFlag(Boolean addressCodeDuplicationFlag) {
		this.addressCodeDuplicationFlag = addressCodeDuplicationFlag;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	@Override
	public String toString() {
		return "AddressChangeInfoRes [zipcode=" + zipcode + ", addressForDisplay=" + addressForDisplay + ", addressKnForDisplay=" + addressKnForDisplay + 
				", address=" + address + ", additionalAddress=" + additionalAddress + ", addressKn=" + addressKn + 
				", additionalAddressKn=" + additionalAddressKn + ", addressCodeDuplicationFlag=" + addressCodeDuplicationFlag + ", addressCode=" + addressCode + "]";
	}
}
