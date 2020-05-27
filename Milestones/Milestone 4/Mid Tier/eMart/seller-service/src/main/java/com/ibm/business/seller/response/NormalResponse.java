package com.ibm.business.seller.response;

import com.ibm.business.seller.constant.ApiConstant;

public class NormalResponse<T> extends BaseResponse<T> {
	
	public NormalResponse(T result) {
		this.status = ApiConstant.STATUS_OK;
		this.result = result;
	}
}
