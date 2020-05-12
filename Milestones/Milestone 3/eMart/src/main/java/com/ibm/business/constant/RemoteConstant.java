package com.ibm.business.constant;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteConstant {
	
	public static final String STATUS_OK = "OK";
	public static final String STATUS_NG = "NG";

	public static final String TEST_ACCESS = "/ba_host/v1/cif/master";
	public static final String URI_GET_SEARCH_USE_ACCESS_TOKEN = "/general-auth/oauth/token";
	public static final String URI_GET_TRANSFER_USE_ACCESS_TOKEN = "/update-auth/oauth/token";
	public static final String URI_GET_BANKS = "/general/furikomi/bank_search";
	public static final String URI_GET_BRANCHES = "/general/furikomi/shiten_search";
	public static final String URI_CONFIRM_TRANSFER = "/general/furikomi/furikomi_confirm";
	public static final String URI_EXECUTE_TRANSFER = "/update/furikomi/furikomi_execute_with_check";
	public static final String URI_GET_USER_INFO = "/general/user/information";
	public static final String URI_UPDATE_USER_INFO = "/general/user/information";
	
	public static final String HEADER_PARAM_KEY_AUTHORIZATION = "Authorization";
	public static final String HEADER_PARAM_KEY_IBM_CLIENT_ID = "X-IBM-Client-Id";
	//public static final String HEADER_PARAM_KEY_CLIENT_ID = "client_id";
	public static final String HEADER_PARAM_KEY_GRANT_TYPE = "grant_type";
	public static final String HEADER_PARAM_KEY_REDIRECT_URI = "redirect_uri";
	public static final String HEADER_PARAM_KEY_CODE = "code";
	
	public static final String HEADER_PARAM_VALUE_AUTHORIZATION_PREFIX = "Bearer ";
	
	public static final String PARAM_AUTH_CODE = "auth_code";
	public static final String PARAM_USER_NAME = "username";
	public static final String PARAM_INITIALIZED_FLG = "initialized_flg";
	
	/** 住所変更 */
	public static final String ADDRESS_CHANGE_INFO_BASE_PATH = "/v1/addresscode/list";
	public static final String ADDRESS_CHANGE_RESOURCE = "/{searchType}";
	public static final String ADDRESS_PHONE_NUMBER_PATH = "/v1/addressphonenumber";
	public static final String PLANNED_DATES_PATH = "/v1/planneddates/addresschange";
	public static final String OTP_ISSUE_INFO_PATH = "/v1/auth/otpissue";

	/** 喪失による再発行の申込 */
	public static final String LOST_REISSUE_PATH = "/v1/lostreissue";
	/** 利用停止・再発行用登録内容照会・更新 */
	public static final String PASSBOOK_CASHCARDS_SUSPENSION_PATH =
            "/v1/passbookcashcardsuspension";
    /** 再発行手数料情報照会 */
	public static final String REISSUE_CHARGE_INFO_PATH = "/v1/reissuechargeinfo";
    /** 利用不能カード再発行用登録内容照会・更新 */
	public static final String USELESS_REISSUE_PATH = "/v1/uselessreissue";
	
	public static final String HEADER_PARAM_KEY_CLIENT_ID = "client_id";
	public static final String HEADER_PARAM_KEY_USERINFO = "userinfo";
	public static final String HEADER_PARAM_KEY_AUTHTYPE = "authtype";
	public static final String HEADER_PARAM_KEY_TRANSATIONID = "transactionID";
	public static final String HEADER_PARAM_KEY_ROUTINGINFO = "routingInfo";
	public static final String HEADER_PARAM_KEY_BANKCODE = "bankCode";
	public static final String HEADER_PARAM_KEY_DEVICEID = "deviceID";
//	public static final String HEADER_PARAM_KEY_AUTHORIZATION = "Authorization";
}
