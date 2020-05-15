package com.ibm.business.user.service;

import com.ibm.business.user.bean.req.SellerInfoRes;
import com.ibm.business.user.response.BaseResponse;
import com.ibm.business.user.response.EmptyResponse;

/**
 * Seller API
 */
public interface SellerService {

    /**
     * Seller Login Api
     */
    public BaseResponse<SellerInfoRes> sellerLogin(String userName, String password);

    /**
     * Seller Register API
     */
    public EmptyResponse<SellerInfoRes> sellerRegister(SellerInfoRes sellerInfoRes);
}
