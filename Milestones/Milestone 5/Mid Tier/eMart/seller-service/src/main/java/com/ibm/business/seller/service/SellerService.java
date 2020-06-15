package com.ibm.business.seller.service;

import com.ibm.business.seller.bean.req.ItemsInfoRes;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.EmptyResponse;

/**
 * User API
 */
public interface SellerService {

    /**
     * View Item Stock Api
     */
    public BaseResponse<ItemsInfoRes> getViewStock(String itemName);

    /**
     * Seller Add Items Api
     */
    public EmptyResponse<ItemsInfoRes> postAddItems(ItemsInfoRes itemsInfoRes);
}
