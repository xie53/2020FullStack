package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoRes extends BaseRemoteRes {
	
	@JsonAlias("initialized_flg")
	private String initializedFlg;
	private String balance;
	private String isRestricted;
	public String getInitializedFlg() {
		return initializedFlg;
	}
	public void setInitializedFlg(String initializedFlg) {
		this.initializedFlg = initializedFlg;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getIsRestricted() {
		return isRestricted;
	}
	public void setIsRestricted(String isRestricted) {
		this.isRestricted = isRestricted;
	}
	@Override
	public String toString() {
		return "UserInfoRes [initializedFlg=" + initializedFlg + ", balance=" + balance + ", isRestricted="
				+ isRestricted + "]";
	}
}
