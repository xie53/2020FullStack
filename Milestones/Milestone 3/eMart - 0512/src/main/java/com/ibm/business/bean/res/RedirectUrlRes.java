package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RedirectUrlRes {
	private String redirectUrl;

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@Override
	public String toString() {
		return "RedirectUrlRes [redirectUrl=" + redirectUrl + "]";
	}
}
