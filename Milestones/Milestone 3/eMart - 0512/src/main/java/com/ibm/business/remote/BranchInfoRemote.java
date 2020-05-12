package com.ibm.business.remote;

import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.res.BranchInfosRes;

/**
* BFFDigital
* @author ShiYan May 24, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public interface BranchInfoRemote {

	public BaseResponse<BranchInfosRes> getBranches(String searchUseAccessToken, String username, String bankToken, String searchContent);
	
	public BaseResponse<BranchInfosRes> searchBranches(String searchUseAccessToken, String username, String bankToken, String searchContent);
}
