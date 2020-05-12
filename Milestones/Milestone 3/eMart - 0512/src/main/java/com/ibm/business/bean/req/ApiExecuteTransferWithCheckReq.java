package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ApiExecuteTransferWithCheckReq {

	private String authCode;
	private String transactionId;
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "ApiExecuteTransferReq [authCode=" + authCode + ", transactionId="
				+ transactionId + "]";
	}
}
