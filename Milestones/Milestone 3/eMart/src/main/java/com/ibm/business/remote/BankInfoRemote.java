package com.ibm.business.remote;

import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.res.BankInfosRes;

/**
* BFFDigital
* @author ShiYan May 24, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public interface BankInfoRemote {

	public BaseResponse<BankInfosRes> getBanks(String searchUseAccessToken, String username, String searchContent);
	
	public BaseResponse<BankInfosRes> searchBanks(String searchUseAccessToken, String username, String searchContent);
}
