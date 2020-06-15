package com.ibm.business.user.response;

import com.ibm.business.user.constant.ApiConstant;

public class NormalResponse<T> extends BaseResponse<T> {
	
	public NormalResponse(T result) {
		this.status = ApiConstant.STATUS_OK;
		this.result = result;
	}
}
