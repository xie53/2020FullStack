package com.ibm.business.seller.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.business.seller.constant.ApiConstant;
import com.ibm.business.seller.constant.ErrorConstant;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.ErrorResponse;

public class BaseController {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected boolean isSuccess(BaseResponse<?> res) {
		return null != res && ApiConstant.STATUS_OK.equals(res.getStatus());
	}
	
	protected void setResponseStatus(BaseResponse<?> res, HttpServletResponse response) {
		if (!isSuccess(res)) {
			try {
				response.setStatus(Integer.parseInt(((ErrorResponse<?>)res).getCode().substring(1, 4)));
			} catch (Exception e) {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
		}
	}

	protected <T> BaseResponse<T> returnAndSendInvalidParameterError(HttpServletResponse response) throws JsonProcessingException, IOException {
		ErrorResponse<?> res = new ErrorResponse<>(ErrorConstant.INVALID_PARAMETER);
//		response.setStatus(HttpStatus.NOT_MODIFIED.value());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.getOutputStream().write(objectMapper.writeValueAsString(res).getBytes());
		response.getOutputStream().flush();
		return null;
	}
}