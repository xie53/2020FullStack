package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AlteredAddressReq {
	
	private String zipCode;
	private String address;
	private String additionalAddress;
	private String addressKn;
	private String additionalAddressKn;
	private String addressCode;
	private String addressType;
	private Boolean addressDeleteFlag;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
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
		return "AlteredAddressReq [zipCode=" + zipCode + ", address=" + address + ", additionalAddress=" + additionalAddress + ", addressKn=" + addressKn
				 + ", additionalAddressKn=" + additionalAddressKn + ", addressCode=" + addressCode + ", addressType=" + addressType + ", addressDeleteFlag=" + addressDeleteFlag + "]";
	}
}
