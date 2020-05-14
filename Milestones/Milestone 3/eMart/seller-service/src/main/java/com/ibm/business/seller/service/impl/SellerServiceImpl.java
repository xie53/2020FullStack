package com.ibm.business.seller.service.impl;

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

import com.ibm.business.seller.bean.req.BuyerInfoRes;
import com.ibm.business.seller.bean.req.ItemsInfoRes;
import com.ibm.business.seller.bean.res.HeaderInfoRes;
import com.ibm.business.seller.constant.ErrorConstant;
import com.ibm.business.seller.db.entity.Buyer;
import com.ibm.business.seller.db.entity.Items;
import com.ibm.business.seller.db.repository.BuyerRepository;
import com.ibm.business.seller.db.repository.ItemsRepository;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.EmptyResponse;
import com.ibm.business.seller.response.ErrorResponse;
import com.ibm.business.seller.response.NormalResponse;
import com.ibm.business.seller.service.SellerService;
import com.ibm.business.seller.util.DateUtil;
import com.ibm.business.seller.util.StringUtil;

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

    @Autowired
    private ItemsRepository itemsRepository;
    
    /**
     * Buyer Login API
     */
    public BaseResponse<ItemsInfoRes> getViewStock(String itemName) {
    	ItemsInfoRes itemsInfoRes = new ItemsInfoRes();

    	Optional<Items> itemList = itemsRepository.findByItemName(itemName);
    	
    	Items item = null;
    	if (!itemList.isPresent()) {
    		return new ErrorResponse<>(ErrorConstant.FAIL_TO_GET_USER_INFO);
    	} else {
    		item = itemList.get();
        }

    	itemsInfoRes.setItemName(item.getItemName());
    	itemsInfoRes.setStockNumber(item.getStockNumber());
    	itemsInfoRes.setRemainNumber(item.getStockNumber());

		return new NormalResponse<ItemsInfoRes>(itemsInfoRes);
    }
    
    /**
     * Seller Add Items Api
     */
    public EmptyResponse<ItemsInfoRes> postAddItems(ItemsInfoRes itemsInfoRes) {
    	Items item = new Items();

		if(itemsInfoRes != null) {
			String itemId = UUID.randomUUID().toString();
			item.setId(itemId);
			item.setItemName(itemsInfoRes.getItemName());
			item.setCategoryId(Long.valueOf(itemsInfoRes.getCategoryId()));
			item.setSubcategoryId(Long.valueOf(itemsInfoRes.getSubcategoryId()));
			item.setPrice(itemsInfoRes.getPrice());
			item.setStockNumber(itemsInfoRes.getStockNumber());
			item.setRemainNumber(itemsInfoRes.getStockNumber());
			item.setDescription(itemsInfoRes.getDescription());
			item.setRemarks(itemsInfoRes.getRemarks());
		}

		item = itemsRepository.saveAndFlush(item);

    	if ("".equals(item.getId())) {
    		return new EmptyResponse<ItemsInfoRes>("NG");
    	}

		return new EmptyResponse<ItemsInfoRes>("OK");
		
//		logger.info("### postAddItems api result: " + itemsRepository.saveAndFlush(item));
//		itemsRepository.saveAndFlush(item);
//    	Optional<Items> buyerList = itemsRepository.findById(item.getId());
//    	
//    	if (!buyerList.isPresent()) {
//    		return new EmptyResponse<ItemsInfoRes>("NG");
//    	}
//
//		return new EmptyResponse<ItemsInfoRes>("OK");
    }

}