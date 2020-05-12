package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan Jun 18, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ExecuteTransferWithCheckBaseRes {

	@JsonAlias("result")
	private String result;
	@JsonAlias("transactionResponse")
	private ExecuteTransferWithCheckRes executeTransferWithCheckRes;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ExecuteTransferWithCheckRes getExecuteTransferWithCheckRes() {
		return executeTransferWithCheckRes;
	}
	public void setExecuteTransferWithCheckRes(ExecuteTransferWithCheckRes executeTransferWithCheckRes) {
		this.executeTransferWithCheckRes = executeTransferWithCheckRes;
	}
}
