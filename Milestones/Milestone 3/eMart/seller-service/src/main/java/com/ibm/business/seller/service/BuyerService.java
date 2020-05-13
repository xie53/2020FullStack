package com.ibm.business.seller.service;

import org.springframework.http.ResponseEntity;

import com.ibm.business.seller.bean.req.BuyerInfoRes;
import com.ibm.business.seller.db.entity.Seller;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.EmptyResponse;

/**
 * User API
 */
public interface BuyerService {

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
