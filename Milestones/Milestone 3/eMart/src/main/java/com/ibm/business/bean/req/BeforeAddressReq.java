package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;
import static com.ibm.business.validator.InputTypeEnum.NONE;

import com.ibm.business.validator.InputConstraint;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BeforeAddressReq {

    /** 郵便番号 */
    @InputConstraint(itemName="郵便番号", notEmpty=true, type=NONE, length=8)
	private String zipCode;
    /** 漢字住所 */
    @InputConstraint(itemName="漢字住所", notEmpty=true, type=NONE, minLength=1, maxLength=64)
	private String kanjiAddress;
    /** カナ住所 */
    @InputConstraint(itemName="カナ住所", notEmpty=true, type=NONE, minLength=1, maxLength=128)
	private String address;
    /** 住所区分 */
    @InputConstraint(itemName="住所区分", notEmpty=true, type=HALF_DIGIT, length=1)
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
		return "BeforeAddressReq [zipCode=" + zipCode + ", kanjiAddress=" + kanjiAddress + ", address=" + address + ", addressType=" + addressType + "]";
	}
}
