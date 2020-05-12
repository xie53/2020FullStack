package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan Jun 12, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteUpdateUserInfoReq {

	private String username;
	private String initialized_flg;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getInitialized_flg() {
		return initialized_flg;
	}
	public void setInitialized_flg(String initialized_flg) {
		this.initialized_flg = initialized_flg;
	}
	@Override
	public String toString() {
		return "RemoteUpdateUserInfoReq [username=" + username + ", initialized_flg=" + initialized_flg + "]";
	}
	
}
