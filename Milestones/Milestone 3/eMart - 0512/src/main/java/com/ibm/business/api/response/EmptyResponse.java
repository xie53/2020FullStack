package com.ibm.business.api.response;

import com.ibm.business.constant.ApiConstant;

/**
 * 空のレスポンス
 *
 */
@SuppressWarnings("rawtypes")
public class EmptyResponse extends BaseResponse {

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
