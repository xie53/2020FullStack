package com.ibm.business.api.response;

import com.ibm.business.constant.CommonConst;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErrorRes {
	private Information information;
	public ErrorRes(String appStoreRedirectUrl , String googlePlayRedirectUrl){
		this.information = new Information(appStoreRedirectUrl ,googlePlayRedirectUrl);
	}
	
	@ApiModelProperty(position = 1, required = true, value = CommonConst.API_PARAM_ERRORCODE_VALUE, example = CommonConst.API_PARAM_ERRORCODE_EXAMPLE)
	private String errorCode;

	@ApiModelProperty(position = 2, required = true, value = CommonConst.API_PARAM_ERRORMESSAGE_VALUE, example = CommonConst.API_PARAM_ERRORMESSAGE_EXAMPLE)
	private String errorMessage;

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

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}
	
}
