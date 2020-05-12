package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoTelPhoneRes {
	private String type;
	private String number;
	private Boolean showflg;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getShowflg() {
		return showflg;
	}

	public void setShowflg(Boolean showflg) {
		this.showflg = showflg;
	}

	@Override
	public String toString() {
		return "UserInfoTelPhoneRes [type=" + type + ", number=" + number + ", showflg=" + showflg + "]";
	}
}
