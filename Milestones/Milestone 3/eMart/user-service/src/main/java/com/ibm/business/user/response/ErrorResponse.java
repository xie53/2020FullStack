package com.ibm.business.user.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibm.business.user.constant.ApiConstant;
import com.ibm.business.user.constant.ErrorConstant;

public class ErrorResponse<T> extends BaseResponse<T> {
	
	private static final Logger logger = LogManager.getLogger(ErrorResponse.class);
	
	public ErrorResponse() {
		this.status = ApiConstant.STATUS_NG;
	}
	
	public ErrorResponse(ErrorConstant e) {
		this.status = ApiConstant.STATUS_NG;
		this.code = e.getErrorCode();
		this.msg = e.getErrorMessage();
		logger.error("### " + e.getErrorMessage());
	}

	@JsonIgnore
	private Object result;
	private String code;
	private String msg;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}