package com.ibm.business.service;

import com.ibm.business.api.response.BankingOAuthToken;
import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.req.OtpIssueReq;
import com.ibm.business.bean.res.AccessTokenRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.OtpIssueRes;
import com.ibm.business.constant.EnumAppStatus;
import com.ibm.business.remote.bean.RemoteApiServerResponse;

/**
 * 認証・認可サービス
 */
public interface AuthenticationService {

    /**
     * BFFアクセストークンが有効をチェックする
     * @param accessToken BFFアクセストークン
     * @return true：有効
     */
    public boolean isValidateAccessToken(String accessToken);

    /**
     * BFFアプリシークレットが有効をチェックする
     * @param appSecret BFFアプリシークレット
     * @return true：有効
     */
    public EnumAppStatus isValidateAppSecret(String appSecret);

    /**
     * コンテキスト・チェンジを実施
     * @param deviceId デバイスID
     * @return アクセストークンレスポンス
     */
    public AccessTokenRes generateAccessToken(String deviceId);

    /**
     * デバイスIDからレディレクトURLを取得
     * @param deviceId デバイスID
     * @return レディレクトURL
     */
    public String getOAuthRedirect(String deviceId);

    /**
     * 認可コード、ステートからOAuth2のトークンを取得、DBを更新する
     * @param headerInfo ヘッダー部
     * @param code 認可コード
     * @param state ステート
     * @return OAuth2のトークン情報
     */
    public BankingOAuthToken registerAccount(HeaderInfoRes headerInfo, String code, String state);

    /**
     * ワンタイムパスワードの発行を依頼する。
     * 
     * @param headerInfo ヘッダー部
     * @param service 住所·電話番号変更
     * @param notifyMethod 通知方法
     * @param request 口座情報に紐づく住所・電話番号の申込情報
     * @return 通番情報
     */
	public RemoteApiServerResponse<OtpIssueRes> otpIssueNotifyMethod(HeaderInfoRes headerInfo, String service,
			String notifyMethod, OtpIssueReq request);
}
