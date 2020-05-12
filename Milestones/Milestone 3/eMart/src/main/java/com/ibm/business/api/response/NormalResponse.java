package com.ibm.business.api.response;

import com.ibm.business.constant.ApiConstant;

public class NormalResponse<T> extends BaseResponse<T> {
	
	public NormalResponse(T result) {
		this.status = ApiConstant.STATUS_OK;
		this.result = result;
	}
}
