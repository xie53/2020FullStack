package com.ibm.business.user.service;

import com.ibm.business.user.bean.req.BuyerInfoRes;
import com.ibm.business.user.response.BaseResponse;
import com.ibm.business.user.response.EmptyResponse;

/**
 * Buyer API
 */
public interface BuyerService {

    /**
     * Buyer Login API
     */
    public BaseResponse<BuyerInfoRes> buyerLogin(String userName, String password);

    /**
     * Buyer Register API
     */
    public EmptyResponse<BuyerInfoRes> buyerRegister(BuyerInfoRes buyerInfoRes);
}
