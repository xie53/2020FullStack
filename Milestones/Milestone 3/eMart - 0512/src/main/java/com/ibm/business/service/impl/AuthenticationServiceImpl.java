package com.ibm.business.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.api.response.BankingOAuthToken;
import com.ibm.business.bean.req.OtpIssueReq;
import com.ibm.business.bean.res.AccessTokenRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.OtpIssueRes;
import com.ibm.business.constant.EnumAppStatus;
import com.ibm.business.db.entity.AccessToken;
import com.ibm.business.db.entity.OAuthToken;
import com.ibm.business.db.entity.PbkApplicationConfiguration;
import com.ibm.business.db.repository.AccessTokenRepository;
import com.ibm.business.db.repository.OAuthTokenRepository;
import com.ibm.business.db.repository.PbkApplicationConfigurationRepository;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.exception.UnauthorizedException;
import com.ibm.business.remote.AuthenticationRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.AuthenticationService;
import com.ibm.business.util.DateUtil;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
 * BFFDigital
 * 
 * @author ShiYan May 11, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 **/

@Service("authenticationService")
public class AuthenticationServiceImpl extends BaseServiceImpl implements AuthenticationService {

    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Value("${token.expire.time}")
    private long tokenExpireTime;

    @Resource(name = "authenticationRemote")
    private AuthenticationRemote authenticationRemote;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    EntityManager entityManager;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Autowired
    private OAuthTokenRepository oAuthTokenRepository;

    @Autowired
    private PbkApplicationConfigurationRepository pbkApplicationConfigurationRepository;

    @Override
    public EnumAppStatus isValidateAppSecret(String appSecret) {
        if (appSecret == null) {
            return null;
        }
        Optional<PbkApplicationConfiguration> optPbk =
                pbkApplicationConfigurationRepository.findByAppSecret(appSecret);
        if (!optPbk.isPresent()) {
            return null;
        }
        PbkApplicationConfiguration pbk = optPbk.get();
        EnumAppStatus appStatus = EnumAppStatus.status(pbk.getAppSecretStatus());
        return appStatus;
    }

    @Override
    public boolean isValidateAccessToken(String accessToken) {
        if (accessToken == null || accessToken.length() != 36) {
            return false;
        }
        Optional<AccessToken> optTat = accessTokenRepository.findByAccessToken(accessToken);
        if (!optTat.isPresent()) {
            return false;
        }
        AccessToken tat = optTat.get();
        if (tat.getCreatedAt().getTime() + tokenExpireTime < new Date().getTime()) {
            return false;
        }
        return true;
    }

    @Override
    public AccessTokenRes generateAccessToken(String deviceId) {
        AccessTokenRes getTokenRes = new AccessTokenRes();
        /*
         * BaseResponse<String> searchUseAccessTokenRes =
         * authenticationRemote.getSearchUseAccessToken(authCode); if
         * (!isSuccess(searchUseAccessTokenRes)) { return new
         * ErrorResponse<>(ErrorConstant.FAIL_TO_GET_SEARCH_USE_ACCESS_TOKEN); } //
         * BaseResponse<String> searchUseAccessTokenRes = new BaseResponse<String>(); //
         * searchUseAccessTokenRes.setResult("4298347982fhskdjhf");
         * 
         * BaseResponse<UserInfoRes> getUserInfoRes =
         * userInfoRemote.getUserInfo(searchUseAccessTokenRes.getResult(), deviceId); if
         * (!isSuccess(getUserInfoRes)) { return new
         * ErrorResponse<>(ErrorConstant.FAIL_TO_GET_USER_INFO); }
         * 
         * if (!getUserInfoRes.getResult().getInitializedFlg().equals("true")) {
         * BaseResponse<BaseRemoteRes> updateUserInfoRes =
         * userInfoRemote.updateUserInfo(searchUseAccessTokenRes.getResult(), deviceId); if
         * (!isSuccess(updateUserInfoRes)) { return new
         * ErrorResponse<>(ErrorConstant.FAIL_TO_UPDATE_USER_INFO); } }
         */
        Optional<AccessToken> accessTokenList = accessTokenRepository.findByDeviceId(deviceId);

        AccessToken accessToken = null;
        String token = UUID.randomUUID().toString();
        Timestamp createdAt = DateUtil.getCurrentTimestap();
        if (!accessTokenList.isPresent()) {
            accessToken = new AccessToken();
            accessToken.setDeviceId(deviceId);
            accessToken.setAccessToken(token);
            accessToken.setCreatedAt(createdAt);
            accessToken.setUpdatedAt(createdAt);
            accessToken.setOauthAccessToken(null);
        } else {
            accessToken = accessTokenList.get();
            accessToken.setAccessToken(token);
            accessToken.setCreatedAt(createdAt);
            accessToken.setUpdatedAt(createdAt);
        }
        accessTokenRepository.save(accessToken);
        logger.info("Bffトークンテーブルにデータを挿入/更新する");

        getTokenRes.setToken(accessToken.getAccessToken());
        return getTokenRes;
    }

    public String getOAuthRedirect(String deviceId) {

        String redirectUrl = authenticationRemote.getAuthUrl(getState(deviceId));
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(redirectUrl);
        return builder.build().toUriString();

    }

    /**
     * ワンタイムパスワードの発行を依頼する。
     * 
     * @param headerInfo ヘッダー部
     * @param service 住所·電話番号変更
     * @param notifyMethod 通知方法
     * @param request 口座情報に紐づく住所・電話番号の申込情報
     * @return 通番情報
     */
    @Override
    public RemoteApiServerResponse<OtpIssueRes> otpIssueNotifyMethod(HeaderInfoRes headerInfo,
            String service, String notifyMethod, OtpIssueReq request) {

        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<OtpIssueRes> res = authenticationRemote.otpIssueNotifyMethod(headerInfo,
                service, notifyMethod, request);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            OtpIssueRes otpIssueRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (otpIssueRes != null && !StringUtil.isEmpty(otpIssueRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(otpIssueRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        OtpIssueRes otpIssueRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<OtpIssueRes> remoteApiServerResponse =
                new RemoteApiServerResponse<OtpIssueRes>(otpIssueRes, responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * 認可コード、ステートからOAuth2のトークンを取得、DBを更新する
     * @param headerInfo ヘッダー部
     * @param code 認可コード
     * @param state ステート
     * @return OAuth2のトークン情報
     */
    @Override
	public BankingOAuthToken registerAccount(HeaderInfoRes headerInfo, String code, String state) {
		logger.info("インターフェイス （個人バンキングAPI OAuth2.0 リダイレクトエンドポイント） input parameters => code: " + code 
				+ ",state: " + state + ",deviceId: " + headerInfo.getDeviceID());

		// リモートApi通信用のOAuthTokenを設定
		tokenUtil.setOAuthToken(headerInfo);

		// リモートApiからOAuth2トークンを取得
		BankingOAuthToken token = (BankingOAuthToken) authenticationRemote.getAuthTokenWithCode(code, state);
		String accessToken = token.getAccessToken();
		String refreshToken = token.getRefreshToken();
		int expiresIn = Integer.valueOf(token.getExpiresIn());
		String scope = token.getScope();

		// AccessTokenテーブルを更新する
		Optional<AccessToken> optAccessToken = accessTokenRepository.findByDeviceId(headerInfo.getDeviceID());

		AccessToken accessTokenTemp = null;
		if (!optAccessToken.isPresent() || !headerInfo.getToken().equals(optAccessToken.get().getAccessToken())) {
			logger.error("デバイスID：" + headerInfo.getDeviceID() + ", アクセストークン：" + headerInfo.getToken()
					+ "でアクセストークンテーブルに該当データを見つかりません。");
			// デバイスIDでBFFのアクセストークンを取得できない
			throw new UnauthorizedException();
		}
		Timestamp currentTimestamp = DateUtil.getCurrentTimestap();
		accessTokenTemp = optAccessToken.get();
		accessTokenTemp.setOauthAccessToken(accessToken); // IDG return access token
		accessTokenTemp.setUpdatedAt(currentTimestamp);
		accessTokenTemp.setCreatedAt(currentTimestamp);
		accessTokenRepository.save(accessTokenTemp);
		logger.info("Bffトークンテーブルにデータを更新する");

		// OAuthTokenテーブルを更新する
		Optional<OAuthToken> optOAuthToken = oAuthTokenRepository.findByDeviceId(headerInfo.getDeviceID());
		OAuthToken oauthToken = null;
		if (optOAuthToken.isPresent()) {
			oauthToken = optOAuthToken.get();
		} else {
			oauthToken = new OAuthToken();
		}
		Timestamp dateNow = DateUtil.getCurrentTimestap();
		oauthToken.setDeviceId(headerInfo.getDeviceID());
		oauthToken.setOauthAccessToken(accessToken);
		oauthToken.setOauthRefreshToken(refreshToken);
		oauthToken.setOauthScope(scope);
		oauthToken.setOauthTokenIssuedAt(dateNow);
		oauthToken.setOauthTokenExpiresIn(expiresIn);
		oauthToken.setUpdatedAt(dateNow);
		oauthToken.setCreatedAt(dateNow);
		oAuthTokenRepository.save(oauthToken);
		logger.info("Oauthトークンテーブルにデータを挿入する");

		return token;
	}

    public String getState(String deviceId) {

        // Generate state
        int tryCount = 0;
        String state = null;
        String additionalValue = null;
        // while (state == null) {

        // if (tryCount > HASH_GENERATION_TRY_MAX - 1) {
        // throw new ApplicationException("E002001000001", new String[] {});
        // }

        additionalValue = String.format("%02d", tryCount);

        String newState = tokenUtil.generateBFFOAuth2State(deviceId, additionalValue);

        // check if the generated account token is already exist in the
        // table.
        // User existingUser = userRepository.findByState(newState);

        // if it does not exist in the table, use it.
        // otherwise, regenerate account token.
        // if (existingUser == null) {

        state = newState;
        // }

        // tryCount++;
        // }

        // User user = userRepository.findByDeviceId(deviceId);
        // user.setDeviceId(deviceId);
        // user.setState(state);
        // user.setStateIssuedAt(now());
        // user.setLastLoginAt(now());
        // user.setUpdatedAt(now());
        //
        // userRepository.save(user);

        return state;
    }

}