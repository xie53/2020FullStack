package com.ibm.business.bean.res;

import com.ibm.business.constant.ApiConstant;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BaseRemoteRes {
	
	private String status = ApiConstant.STATUS_OK;
	private String reason = "";
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
