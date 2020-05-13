package com.ibm.business.user.service;

import org.springframework.http.ResponseEntity;

import com.ibm.business.user.bean.req.BuyerInfoRes;
import com.ibm.business.user.db.entity.Seller;
import com.ibm.business.user.response.BaseResponse;
import com.ibm.business.user.response.EmptyResponse;

/**
 * User API
 */
public interface SellerService {

    /**
     * Buyer Login API
     */
    public BaseResponse<BuyerInfoRes> buyerLogin(String userName, String password);

//    /**
//     * Seller Login API
//     */
//    public ResponseEntity<Seller> sellerLogin(String userName, String password);
//
    /**
     * Buyer Register API
     */
    public EmptyResponse<BuyerInfoRes> buyerRegister(BuyerInfoRes buyerInfoRes);
//
//    /**
//     * Seller Register API
//     */
//    public void sellerRegister(String userName, String p);
}
