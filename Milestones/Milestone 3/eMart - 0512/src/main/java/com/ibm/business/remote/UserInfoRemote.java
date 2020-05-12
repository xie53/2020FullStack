package com.ibm.business.remote;

import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.res.BaseRemoteRes;
import com.ibm.business.bean.res.UserInfoRes;

/**
* BFFDigital
* @author ShiYan Jun 10, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public interface UserInfoRemote {

	public BaseResponse<UserInfoRes> getUserInfo(String searchUseAccessToken, String username);
	
	public BaseResponse<BaseRemoteRes> updateUserInfo(String searchUseAccessToken, String username);
}
