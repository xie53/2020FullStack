package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoAddrRes {
	private String addrKbn;
	private String zipCode;
	private String addr1;
	private String addr2;
	private String kanaAddr;
	private Boolean deleted;

	public String getAddrKbn() {
		return addrKbn;
	}

	public void setAddrKbn(String addrKbn) {
		this.addrKbn = addrKbn;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getKanaAddr() {
		return kanaAddr;
	}

	public void setKanaAddr(String kanaAddr) {
		this.kanaAddr = kanaAddr;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "UserInfoAddrRes [addrKbn=" + addrKbn + ", zipCode=" + zipCode + ", addr1=" + addr1 + 
				", addr2=" + addr2 + ", kanaAddr=" + kanaAddr + ", deleted=" + deleted + "]";
	}
}
