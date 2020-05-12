package com.ibm.business.constant;

/**
* BFFDigital
* @author ShiYan May 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ApiConstant {
	
	public static final String STATUS_OK = "OK";
	public static final String STATUS_NG = "NG";

	public static final String AUTH_BASE_PATH = "/auth";
	public static final String URI_AUTH_GET_TOKEN = "/getToken";
	public static final String URI_AUTH_REFRESH_TOKEN = "/refreshToken";
	
	public static final String BANK_INFO_BASE_PATH = "/bankInfo";
	public static final String URI_BANK_INFO_GET_BANKS = "/getBanks";
	public static final String URI_BANK_INFO_SEARCH_BANKS = "/searchBanks";
	
	public static final String BRANCH_INFO_BASE_PATH = "/branchInfo";
	public static final String URI_BRANCH_INFO_GET_BRANCHES = "/getBranches";
	public static final String URI_BRANCH_INFO_SEARCH_BRANCHES = "/searchBranches";
	
	public static final String TRANSFER_BASE_PATH = "/transfer";
	public static final String URI_TRANSFER_CONFIRM = TRANSFER_BASE_PATH + "/confirmTransfer";
	public static final String URI_TRANSFER_EXECUTE = TRANSFER_BASE_PATH + "/executeTransfer";
	
	public static final String USER_INFO_BASE_PATH = "/userInfo";
	public static final String URI_USER_INFO_GET_INFO = USER_INFO_BASE_PATH + "/getInfo";
	public static final String URI_USER_INFO = USER_INFO_BASE_PATH + "/getUserInfo";
	
	public static final String ERROR_CODE = "";
	public static final String ERROR_MESSAGE = "";

    /** APIベースURLパス */
	public static final String DIGITAL_BASE_PATH = "/api/v1";
    /** ディフォルト・エンドポイント */
    public static final String DEFAULT_PATH = "";
    /** 認証・コンテキスト・チェンジのベースパス */
	public static final String CONTACT_CHANGE_PATH = "/contactchange";
    /** 認証・OAuth認証URL取得のベースパス */
    public static final String BANKING_RETAIL_AUTH_PATH = "/banking/retail/auth";

    public static final String AUTH_GET_TOKEN = "/getToken";

	public static final String ADDRESS_CHANGE_BASEPATH = "/addresschange";
	public static final String ADDRESS_CHANGE_RESOURCE = "/addresscode/list/{searchType}";
	public static final String ADDRESS_PHONE_NUMBER_PATH = "/addressphonenumber";
	public static final String PLANNED_DATES_PATH = "/planneddates/addresschange";
	public static final String OTP_ISSUE_PATH = "/otpissue/{service}/{notifyMethod}";

	/** 利用停止・再発行Apiのベースパス */
	public static final String PASSBOOK_CASHCARD_SUSPENSION_PATH = "/passbookcashcardsuspension";
	/** 喪失による再発行Apiのベースパス */
    public static final String LOST_REISSUE_PATH = "/lostreissue";
    /** 利用不能カード再発行用登録内容照会・更新Apiのベースパス */
    public static final String REISSUE_CHARGE_INFO_PATH = "/reissuechargeinfo";
    /** 利用不能カード再発行用登録内容照会・更新Apiのベースパス */
    public static final String USELESS_REISSUE_PATH = "/uselessreissue";

}
