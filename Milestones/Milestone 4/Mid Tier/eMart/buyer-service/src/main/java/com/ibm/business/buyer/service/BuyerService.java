package com.ibm.business.buyer.service;

import org.springframework.http.ResponseEntity;

import com.ibm.business.buyer.bean.req.BuyerInfoRes;
import com.ibm.business.buyer.bean.req.ItemsInfoListRes;
import com.ibm.business.buyer.db.entity.Seller;
import com.ibm.business.buyer.response.BaseResponse;
import com.ibm.business.buyer.response.EmptyResponse;

/**
 * User API
 */
public interface BuyerService {

	/**
	 * Search Items Api
	 */
	public BaseResponse<ItemsInfoListRes> searchItemsInfo(String itemName, String category, String subCategory,
			Double startPrice, Double endPrice);

//	/**
//	 * Search Purchase History Api
//	 */
//	public EmptyResponse<BuyerInfoRes> searchPurchaseHistoryInfo(BuyerInfoRes buyerInfoRes);
}
