package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.NONE;

import com.ibm.business.validator.InputConstraint;

/**
 * 住所変更_郵便番号住所照会リクエスト
 *
 */
public class GetAccessTokenInfoReq {
    /** 認可コード */ 
    @InputConstraint(itemName="認可コード", notEmpty=true, type=NONE, minLength=1, maxLength=1500) 
    private String code; 
    /** ステート */  
    @InputConstraint(itemName="ステート", notEmpty=false, type=NONE, minLength=1, maxLength=64) 
    private String state;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}   

}
