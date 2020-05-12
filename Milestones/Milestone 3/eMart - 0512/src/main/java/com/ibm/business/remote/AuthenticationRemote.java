package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.api.response.BankingOAuthToken;
import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.req.OtpIssueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.OtpIssueRes;

/**
* BFFDigital
* @author ShiYan May 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public interface AuthenticationRemote {

	/**
	 * OAuth2.0 認証URL取得API
	 */
	public String getAuthUrl(String state);
	
    /**
     * アクセストークン発行要求（認可コード使用）API
     * 認可コード、ステートからOAuth2のトークンを取得
     * @param code 認可コード
     * @param state ステート
     * @return OAuth2のトークン情報
     */
	public BankingOAuthToken getAuthTokenWithCode(String code, String state);

    /**
     * ワンタイムパスワードの発行を依頼する。
     * 
     * @param headerInfo ヘッダー部
     * @param service 住所·電話番号変更
     * @param notifyMethod 通知方法
     * @param request 口座情報に紐づく住所・電話番号の申込情報
     * @return 通番情報
     */
	public ResponseEntity<OtpIssueRes> otpIssueNotifyMethod(HeaderInfoRes headerInfo, String service,
			String notifyMethod, OtpIssueReq requestJson);
}
