package com.ibm.business.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.constant.ErrorConstant;
import com.ibm.business.db.entity.AccessToken;
import com.ibm.business.db.repository.AccessTokenRepository;
import com.ibm.business.db.repository.OAuthTokenRepository;
import com.ibm.business.exception.ApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.exception.UnauthorizedException;
import com.ibm.business.message.MessageConst;

@Component
public class TokenUtil {

	private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

	private static final String ALG_HMAC_SHA256 = "HmacSHA256";

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

//	@Value("${pbk.auth.accessToken.secret}")
//	private String pbkAccessTokenSecret;

	@Value("${pbk.oauth2.state.secret}")
	private String pbkOAuth2StateSecret;
    
//	@Value("${pbk.util.rev.secret}")
//	private String pbkRevSecret;
//
//	private String pbkAccountTokenSecret = "accountToken";

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Autowired
    private OAuthTokenRepository oAuthTokenRepository;

	/*
	 * public String generateBFFAccessToken(String deviceId, String
	 * accessTokenAdditionalValue) {
	 * 
	 * String plaintext = sdf.format(new Date()) + deviceId +
	 * accessTokenAdditionalValue;
	 * 
	 * return generateHashSHA256(plaintext, pbkAccessTokenSecret); }
	 */

	public String generateBFFOAuth2State(String deviceId, String stateAdditionalValue) {

		String plaintext = sdf.format(new Date()) + deviceId + stateAdditionalValue;

		return generateHashSHA256(plaintext, pbkOAuth2StateSecret);
	}

	/*
	 * public String generateRev() {
	 * 
	 * String plaintext = sdf.format(new Date());
	 * 
	 * return generateHashSHA256(plaintext, pbkRevSecret); }
	 * 
	 * public String generateAccountToken(String branchNumber, String accountType,
	 * String accountNumber, String accountAdditionalValue) {
	 * 
	 * String plaintext = branchNumber + accountType + accountNumber +
	 * accountAdditionalValue;
	 * 
	 * return generateHashSHA256(plaintext, pbkAccountTokenSecret); }
	 */

	public String generateHashSHA256(String plainText, String secret) {

		String hashString = "";

		try {
			SecretKeySpec sk = new SecretKeySpec(secret.getBytes(), ALG_HMAC_SHA256);
			Mac mac = Mac.getInstance(ALG_HMAC_SHA256);
			mac.init(sk);

			byte[] mac_bytes = mac.doFinal(plainText.getBytes());

			StringBuilder sb = new StringBuilder(2 * mac_bytes.length);
			for (byte b : mac_bytes) {
				sb.append(String.format("%02x", b & 0xff));
			}
			hashString = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.info("ハッシュ値の生成に失敗しました。　Cause:{} ,Message:{}", e.getCause(), e.getMessage(), e);
			throw new SystemException(MessageConst.E000000000000, e);
		} catch (InvalidKeyException e) {
			logger.info("ハッシュ値の生成に失敗しました。　Cause:{} ,Message:{}", e.getCause(), e.getMessage(), e);
            throw new SystemException(MessageConst.E000000000000, e);
		}

		return hashString;

	}

	/**
	 * HeaderInfoのOAuthトークンを設定
	 * @param headerInfo
	 */
	public void setOAuthToken(HeaderInfoRes headerInfo) {
        if(StringUtils.isEmpty(headerInfo.getAuthorization())) {
            Optional<AccessToken> optAccessToken =
                    accessTokenRepository.findByAccessToken(headerInfo.getToken());
            if (!optAccessToken.isPresent()) {
                throw new UnauthorizedException();
            }
            AccessToken accessToken = optAccessToken.get();
    
            // set IDG return access token
            headerInfo.setAuthorization(accessToken.getOauthAccessToken());
        }
    }
    
	/**
	 * <p>アクセストークンをチェックする</p>
	 * アクセストークンが存在、かつSearchUserTokenがNULL以外の場合がtrueを返す
	 * @param accessToken アクセストークン
	 * @return アクセストークンが存在、かつSearchUserTokenがNULL以外の場合がtrueを返す
	 */
	public boolean checkSeachUseTokenExist(Optional<AccessToken> accessToken) {
	    return accessToken.isPresent() && null != accessToken.get().getOauthAccessToken() && accessToken.get().getOauthAccessToken().length() > 0;
	}
}
