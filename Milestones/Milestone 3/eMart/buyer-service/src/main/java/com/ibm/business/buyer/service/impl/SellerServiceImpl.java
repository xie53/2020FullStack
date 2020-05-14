package com.ibm.business.buyer.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.buyer.bean.req.BuyerInfoRes;
import com.ibm.business.buyer.bean.res.HeaderInfoRes;
import com.ibm.business.buyer.constant.ErrorConstant;
import com.ibm.business.buyer.db.entity.Buyer;
import com.ibm.business.buyer.db.repository.BuyerRepository;
import com.ibm.business.buyer.response.BaseResponse;
import com.ibm.business.buyer.response.EmptyResponse;
import com.ibm.business.buyer.response.ErrorResponse;
import com.ibm.business.buyer.response.NormalResponse;
import com.ibm.business.buyer.service.BuyerService;
import com.ibm.business.buyer.service.SellerService;
import com.ibm.business.buyer.util.DateUtil;
import com.ibm.business.buyer.util.StringUtil;

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
    private BuyerRepository buyerRepository;
    
    /**
     * Buyer Login API
     */
    public BaseResponse<BuyerInfoRes> buyerLogin(String userName, String password) {
    	BuyerInfoRes buyerInfoRes = new BuyerInfoRes();

    	Optional<Buyer> buyerList = buyerRepository.findByUserNameAndPassword(userName, password);
    	
    	Buyer buyer = null;
    	if (!buyerList.isPresent()) {
    		return new ErrorResponse<>(ErrorConstant.FAIL_TO_GET_USER_INFO);
    	} else {
    		buyer = buyerList.get();
        }
    	buyerInfoRes.setUserName(buyer.getUserName());
    	buyerInfoRes.setEmail_id(buyer.getEmail_id());
    	buyerInfoRes.setContact_number(buyer.getContact_number());
    	buyerInfoRes.setCreateDate(buyer.getCreateDate());

		return new NormalResponse<BuyerInfoRes>(buyerInfoRes);
    }
    
    /**
     * Buyer Register API
     */
    public EmptyResponse<BuyerInfoRes> buyerRegister(BuyerInfoRes buyerInfoRes) {
    	Buyer buyer = new Buyer();

		if(buyerInfoRes != null) {
	        Timestamp createdDate = DateUtil.getCurrentTimestap();
			buyer.setUserName(buyerInfoRes.getUserName());
			buyer.setPassword(buyerInfoRes.getPassword());
			buyer.setEmail_id(buyerInfoRes.getEmail_id());
			buyer.setContact_number(buyerInfoRes.getContact_number());
			buyer.setCreateDate(createdDate);
		}

    	buyerRepository.save(buyer);
    	Optional<Buyer> buyerList = buyerRepository.findByUserName(buyerInfoRes.getUserName());
    	
    	if (!buyerList.isPresent()) {
    		return new EmptyResponse<BuyerInfoRes>("NG");
    	}

		return new EmptyResponse<BuyerInfoRes>("OK");
    }

}