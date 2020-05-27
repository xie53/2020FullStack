package com.ibm.business.buyer.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.ibm.business.buyer.bean.req.ItemsInfoListRes;
import com.ibm.business.buyer.bean.req.ItemsInfoRes;
import com.ibm.business.buyer.bean.res.HeaderInfoRes;
import com.ibm.business.buyer.constant.ErrorConstant;
import com.ibm.business.buyer.db.entity.Buyer;
import com.ibm.business.buyer.db.entity.Items;
import com.ibm.business.buyer.db.repository.BuyerRepository;
import com.ibm.business.buyer.db.repository.ItemsRepository;
import com.ibm.business.buyer.response.BaseResponse;
import com.ibm.business.buyer.response.EmptyResponse;
import com.ibm.business.buyer.response.ErrorResponse;
import com.ibm.business.buyer.response.NormalResponse;
import com.ibm.business.buyer.service.BuyerService;
import com.ibm.business.buyer.util.DateUtil;
import com.ibm.business.buyer.util.StringUtil;

/**
 * BFFDigital
 * 
 * @author ShiYan May 11, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 **/

@Service("buyerService")
public class BuyerServiceImpl extends BaseServiceImpl implements BuyerService {

    private static final Logger logger = LogManager.getLogger(BuyerServiceImpl.class);

    @Value("${token.expire.time}")
    private long tokenExpireTime;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private ItemsRepository itemsRepository;
    
    /**
     * Buyer Login API
     */
    public BaseResponse<ItemsInfoListRes> searchItemsInfo(String itemName, String category, String subCategory,
			Double startPrice, Double endPrice) {
    	List<ItemsInfoRes> itemInformationList = new ArrayList<>();
    	ItemsInfoListRes itemsInfoListRes = new ItemsInfoListRes();

    	List<Items> itemList = itemsRepository.findItemInfo(itemName, category, subCategory, startPrice, endPrice);
//    	Optional<Items> itemList = itemsRepository.findItemInfo(itemName, category, subCategory, startPrice, endPrice);
    	
    	Items item = null;
    	ItemsInfoRes itemsInfoRes = new ItemsInfoRes();
    	if (itemList.size() == 0) {
    		return new ErrorResponse<>(ErrorConstant.FAIL_TO_GET_USER_INFO);
    	} else {
    		for(int i = 0; i < itemList.size(); i++) {
    			item = itemList.get(i);
    			itemsInfoRes.setItemName(item.getItemName());
    			itemsInfoRes.setCategoryId(item.getCategoryId());
    			itemsInfoRes.setSubcategoryId(item.getSubcategoryId());
    			itemsInfoRes.setPrice(item.getPrice());
    			itemsInfoRes.setDescription(item.getDescription());
    			itemsInfoRes.setStockNumber(item.getStockNumber());
    			itemsInfoRes.setRemainNumber(item.getRemainNumber());
    			itemsInfoRes.setRemarks(item.getRemarks());
    			itemInformationList.add(itemsInfoRes);
    		}
        }

    	logger.info("### api result: " + itemInformationList);
    	itemsInfoListRes.setItemInformationList(itemInformationList);

		return new NormalResponse<ItemsInfoListRes>(itemsInfoListRes);
    }

}