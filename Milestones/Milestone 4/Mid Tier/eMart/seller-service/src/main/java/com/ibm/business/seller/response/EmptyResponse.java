package com.ibm.business.seller.response;

import com.ibm.business.seller.constant.ApiConstant;

@SuppressWarnings("rawtypes")
public class EmptyResponse<T> extends BaseResponse<T> {

    @SuppressWarnings("unchecked")
    public EmptyResponse() {
        super();
        this.status = ApiConstant.STATUS_OK;
        this.result = null;
    }

    @SuppressWarnings("unchecked")
    public EmptyResponse(String status) {
        super();
        this.status = status;
        this.result = null;
    }
}
