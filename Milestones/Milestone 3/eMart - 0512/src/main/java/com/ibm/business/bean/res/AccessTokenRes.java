package com.ibm.business.bean.res;

/**
* BFFDigital
* @author ShiYan May 27, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AccessTokenRes {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AccessTokenRes [token=" + token + "]";
	}
}
