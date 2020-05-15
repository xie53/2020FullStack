package com.ibm.business.user.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.user.bean.req.SellerInfoRes;
import com.ibm.business.user.constant.ErrorConstant;
import com.ibm.business.user.db.entity.Seller;
import com.ibm.business.user.db.repository.SellerRepository;
import com.ibm.business.user.response.BaseResponse;
import com.ibm.business.user.response.EmptyResponse;
import com.ibm.business.user.response.ErrorResponse;
import com.ibm.business.user.service.SellerService;
import com.ibm.business.user.util.DateUtil;
import com.ibm.business.user.response.NormalResponse;

/**
 * BFFDigital
 * 
 * @author ShiYan May 11, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 **/

@Service("sellerService")
public class SellerServiceImpl extends BaseServiceImpl implements SellerService {

    private static final Logger logger = LogManager.getLogger(SellerServiceImpl.class);

    @Value("${token.expire.time}")
    private long tokenExpireTime;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private SellerRepository sellerRepository;
    
    /**
     * Seller Login Api
     */
    public BaseResponse<SellerInfoRes> sellerLogin(String userName, String password) {
    	SellerInfoRes sellerInfoRes = new SellerInfoRes();

    	Optional<Seller> buyerList = sellerRepository.findByUserNameAndPassword(userName, password);
    	
    	Seller seller = null;
    	if (!buyerList.isPresent()) {
    		return new ErrorResponse<>(ErrorConstant.FAIL_TO_GET_USER_INFO);
    	} else {
    		seller = buyerList.get();
        }
    	sellerInfoRes.setId(Long.toString(seller.getId()));
    	sellerInfoRes.setUserName(seller.getUserName());
    	sellerInfoRes.setCompany(seller.getCompany());
    	sellerInfoRes.setGstin(seller.getGstin());
    	sellerInfoRes.setBriefCompany(seller.getBriefCompany());
    	sellerInfoRes.setPostalAddress(seller.getPostalAddress());
    	sellerInfoRes.setWebsite(seller.getWebsite());
    	sellerInfoRes.setEmailId(seller.getEmailId());
    	sellerInfoRes.setContactNumber(seller.getContactNumber());
    	sellerInfoRes.setCreateDate(seller.getCreateDate());

		return new NormalResponse<SellerInfoRes>(sellerInfoRes);
    }
    
    /**
     * Buyer Register API
     */
    public EmptyResponse<SellerInfoRes> sellerRegister(SellerInfoRes sellerInfoRes) {
    	Seller seller = new Seller();

		if(sellerInfoRes != null) {
	        Timestamp createdDate = DateUtil.getCurrentTimestap();
	        seller.setUserName(sellerInfoRes.getUserName());
	        seller.setPassword(sellerInfoRes.getPassword());
	    	seller.setCompany(sellerInfoRes.getCompany());
	    	seller.setGstin(sellerInfoRes.getGstin());
	    	seller.setBriefCompany(sellerInfoRes.getBriefCompany());
	    	seller.setPostalAddress(sellerInfoRes.getPostalAddress());
	    	seller.setWebsite(sellerInfoRes.getWebsite());
	    	seller.setEmailId(sellerInfoRes.getEmailId());
	    	seller.setContactNumber(sellerInfoRes.getContactNumber());
	        seller.setCreateDate(createdDate);
		}
		
		seller = sellerRepository.saveAndFlush(seller);

    	if ("".equals(seller.getId())) {
    		return new EmptyResponse<SellerInfoRes>("NG");
    	}

		return new EmptyResponse<SellerInfoRes>("OK");

//		sellerRepository.save(seller);
//    	Optional<Seller> buyerList = sellerRepository.findByUserName(sellerInfoRes.getUserName());
//    	
//    	if (!buyerList.isPresent()) {
//    		return new EmptyResponse<SellerInfoRes>("NG");
//    	}
//
//		return new EmptyResponse<SellerInfoRes>("OK");
    }

}