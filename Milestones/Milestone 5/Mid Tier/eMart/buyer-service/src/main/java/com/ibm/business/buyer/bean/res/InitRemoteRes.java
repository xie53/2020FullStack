package com.ibm.business.buyer.bean.res;

/**
* BFFDigital
* @author ShiYan May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class InitRemoteRes {
	
	private String errorCode;
	private String errorMessage;
	private Boolean reEnterableFlag; 

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    public Boolean getReEnterableFlag() {
        return reEnterableFlag;
    }
    public void setReEnterableFlag(Boolean reEnterableFlag) {
        this.reEnterableFlag = reEnterableFlag;
    }
}
