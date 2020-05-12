package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ReceiptNumberInfoRes extends InitRemoteRes{
	private String receiptNumberCustomer;
	private List<AlteredAddressRes> alteredAddress = new ArrayList<>();
	private List<PhoneNumberRes> alteredPhoneNumber = new ArrayList<>();

	public String getReceiptNumberCustomer() {
		return receiptNumberCustomer;
	}

	public void setReceiptNumberCustomer(String receiptNumberCustomer) {
		this.receiptNumberCustomer = receiptNumberCustomer;
	}

	public List<AlteredAddressRes> getAlteredAddress() {
		return alteredAddress;
	}

	public void setAlteredAddress(List<AlteredAddressRes> alteredAddress) {
		this.alteredAddress = alteredAddress;
	}

	public List<PhoneNumberRes> getAlteredPhoneNumber() {
		return alteredPhoneNumber;
	}

	public void setAlteredPhoneNumber(List<PhoneNumberRes> alteredPhoneNumber) {
		this.alteredPhoneNumber = alteredPhoneNumber;
	}

	@Override
	public String toString() {
		return "ReceiptNumberInfoRes [receiptNumberCustomer=" + receiptNumberCustomer + ", alteredAddress=" + alteredAddress + ", alteredPhoneNumber=" + alteredPhoneNumber + "]";
	}
}
