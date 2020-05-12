package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan Jun 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteExecuteTransferWithCheckReq {

	private String username;
	private String transactionNo;
	
	public RemoteExecuteTransferWithCheckReq(String username, String transactionNo) {
		this.username = username;
		this.transactionNo = transactionNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	
}
