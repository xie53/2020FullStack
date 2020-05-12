package com.ibm.business.api.response;

import com.ibm.business.constant.CommonConst;

import io.swagger.annotations.ApiModelProperty;

public class InitResponse<T> {

	public InitResponse(String appStoreRedirectUrl , String googlePlayRedirectUrl){
		
		this.information = new Information(appStoreRedirectUrl ,googlePlayRedirectUrl);
		
	}
	
	private InitResponse(){
		
	}
	
	@ApiModelProperty(position = 1, required = true, value = CommonConst.API_PARAM_INFORMATION_VALUE)
	private Information information;

	public Information getInformation() {
		return information;
	}
}
