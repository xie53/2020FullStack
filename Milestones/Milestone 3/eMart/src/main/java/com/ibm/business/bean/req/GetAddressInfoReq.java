package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;
import static com.ibm.business.validator.InputTypeEnum.NONE;

import com.ibm.business.validator.InputConstraint;

/**
 * 住所変更_郵便番号住所照会リクエスト
 *
 */
public class GetAddressInfoReq {
    /** 検索キー */ 
    @InputConstraint(itemName="検索キー", notEmpty=true, type=NONE, minLength=1, maxLength=120) 
    private String searchKey; 
    /** 検索結果の最大応答数 */  
    @InputConstraint(itemName="検索結果の最大応答数", notEmpty=false, type=HALF_DIGIT, minLength=1, maxLength=4) 
    private String maxRowNumber = "200";

	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getMaxRowNumber() {
		return maxRowNumber;
	}
	public void setMaxRowNumber(String maxRowNumber) {
		this.maxRowNumber = maxRowNumber;
	}   

}
