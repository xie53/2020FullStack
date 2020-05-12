package com.ibm.business.constant;

/**
* BFFDigital
* @author ShiYan May 27, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public enum ErrorConstant {
	
    GENERAL_ERROR("E50000100000", "システムエラー") , // システムエラー
    SYS_DB_ERROR("E50000100001", "データベース更新エラー") , // データベース更新エラー
    SYS_REMOTE_IO_ERROR("E50000100002", "リモートサービス接続エラー") , // リモートサービス接続エラー。-> ResourceAccessException
    SYS_REMOTE_ERROR("E50000100003", "リモートサービスエラー") , // リモートサービス接続エラー。-> RestClientResponseException
    FAIL_TO_LOGIN("E20000100000", "ログオン失敗。再度ログオンしてください"), //ログオンエラー
	INVALID_PARAMETER("E40000100000", "パラメータエラー"), // パラメータチェックエラー
	WRONG_ACCESS_TOKEN("E40100100000", "アクセストークンが無効"), // アクセストークンが無効
	//INEXIST_ACCESS_TOKEN("E401-002", "Access token is not exist"),

//	FAIL_TO_GET_SEARCH_USE_ACCESS_TOKEN("E500-002", "Fail to get search use access token"),
	FAIL_TO_GET_TRANSFER_USE_ACCESS_TOKEN("E500-003", "Fail to get transfer use access token"),
//	FAIL_TO_GET_USER_INFO("E500-003", "Fail to get user info"),
//	FAIL_TO_UPDATE_USER_INFO("E500-004", "Fail to update user info"),
	FAIL_TO_SEARCH_BANK_INFO("E500-005", "Fail to search bank info"),
//	FAIL_TO_SEARCH_BRANCH_INFO("E500-006", "Fail to search branch info"),
	FAIL_TO_CONFIRM_TRANSACTION("E500-007", "Fail to confirm transaction"),
	FAIL_TO_EXECUTE_TRANSACTION_WITH_CHECK("E500-008", "Fail to execute transaction with check");
//	FAIL_TO_PARSE_JSON_FROM_OBJECT("E500-999", "Fail to parse json from object");
//	
	
	ErrorConstant(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
