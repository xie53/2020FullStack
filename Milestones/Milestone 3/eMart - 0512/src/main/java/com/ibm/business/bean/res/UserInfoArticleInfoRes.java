package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoArticleInfoRes {
	private String storeName;
	private String acctNo;
	private String kmk;
	private String name;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getKmk() {
		return kmk;
	}

	public void setKmk(String kmk) {
		this.kmk = kmk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserInfoArticleInfoRes [storeName=" + storeName + ", acctNo=" + acctNo + 
				", kmk=" + kmk + ", name=" + name + "]";
	}
}
