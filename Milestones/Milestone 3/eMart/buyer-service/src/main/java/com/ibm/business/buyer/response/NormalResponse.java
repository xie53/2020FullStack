package com.ibm.business.buyer.response;

import com.ibm.business.buyer.constant.ApiConstant;

public class NormalResponse<T> extends BaseResponse<T> {
	
	public NormalResponse(T result) {
		this.status = ApiConstant.STATUS_OK;
		this.result = result;
	}
}
