package com.ibm.business.remote.impl;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.business.api.response.BankingOAuthToken;
import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.NormalResponse;
import com.ibm.business.bean.req.AddressPhonenumberReq;
import com.ibm.business.bean.req.OtpIssueReq;
import com.ibm.business.bean.res.AlteredAddressRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.OtpIssueRes;
import com.ibm.business.bean.res.PhoneNumberRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.exception.ApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.exception.UnauthorizedException;
import com.ibm.business.message.MessageConst;
import com.ibm.business.remote.AuthenticationRemote;
import com.ibm.business.util.RequestCorrelation;

/**
* BFFDigital
* @author ShiYan May 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/
@Service("authenticationRemote")
public class AuthenticationRemoteImpl extends BaseRemoteImpl implements AuthenticationRemote {
	
	private static final Logger logger = LogManager.getLogger(AuthenticationRemoteImpl.class);

	@Autowired
	protected RestTemplate restTemplate;

	@Value("${banking.oauth2.clientSecret}")
	protected String clientSecret;

	@Value("${banking.oauth2.clientId}")
	protected String clientId;

	@Value("${banking.oauth2.redirectUrl}")
	protected String redirectUrl;

	@Value("${banking.oauth2.scope}")
	protected String scope;

	@Value("${banking.oauth2.authtype}")
	protected String authtype;

	@Value("${banking.oauth2.baseUri}")
	protected String baseUri;

	@Value("${banking.http.retryTimeInterval}")
	protected int retryTimeInterval;
	
	protected static String HEADER_AUTHORIZATION = "Authorization";

	protected static String HEADER_BEARER = "Bearer ";
	

	/**
	 * OAuth2.0 認証URL取得API
	 */
	public String getAuthUrl(String state) {

		logger.info("API Call Start: OAuth2.0 認証URL取得API");

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		queryParams.add("response_type", "code");
		queryParams.add("client_id", this.clientId);
		queryParams.add("redirect_uri", this.redirectUrl);
		queryParams.add("scope", this.scope);
		queryParams.add("authtype", this.authtype);
		queryParams.add("state", state);

		logger.info("API input parameters => response_type: " + "code" + ",client_id: " + this.clientId + ",redirect_uri: " + this.redirectUrl
				 + ",scope: " + this.scope + ",authtype: " + this.authtype + ",state: " + state);
		logger.info("API remote URL: " + baseUri + "/login");
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUri + "/login").queryParams(queryParams);
		
		ResponseEntity<String> token;
		try {
			token = this.retryableExecute(builder.build().encode().toUri(), HttpMethod.GET, null, String.class);
		}  catch (UnauthorizedException e) {
		    logger.info("リモートサービスとの通信で未認証エラーが発生しました。Cause:{} ,Message:{}", e.getCause(),
                    e.getMessage(), e);
		    // 未認証エラー
		    throw e;
		}  catch(RestClientException e) {
		    logger.info("リモートサービスとの通信で予期しないエラーが発生しました。Cause:{} ,Message:{}", e.getCause(),
                    e.getMessage(), e);
	        // サーバエラー
            throw e;
		}  catch (ApplicationException | SystemException e) {
            throw e;
		}  catch (Exception e) {
			logger.info("リモートサービスとの通信で予期しないエラーが発生しました。Cause:{} ,Message:{}", e.getCause(),
					e.getMessage(), e);
			throw new SystemException(MessageConst.E000000004001);
		}
		for (Entry<String, List<String>> s : token.getHeaders().entrySet()) {

			logger.info("API Call Result: Header{}:{}", s.getKey(), s.getValue());

		}

		logger.info("API Call End: OAuth2.0 認証URL取得API");
		return token.getHeaders().get("location").get(0);

	}

    /**
     * アクセストークン発行要求（認可コード使用）API
     * 認可コード、ステートからOAuth2のトークンを取得
     * @param code 認可コード
     * @param state ステート
     * @return OAuth2のトークン情報
     */
	public BankingOAuthToken getAuthTokenWithCode(String code, String state) {

		logger.info("API Call Start: アクセストークン発行要求（認可コード使用）API");

		String auth = clientId + ":" + clientSecret;
		byte[] encodedAuth = Base64Utils.encode(auth.getBytes(Charset.forName("UTF-8")));
		String authHeader = "Basic " + new String(encodedAuth, StandardCharsets.UTF_8);

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(HEADER_AUTHORIZATION, authHeader);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		queryParams.add("grant_type", "authorization_code");
		queryParams.add("code", code);
        queryParams.add("state", state);
		queryParams.add("scope", scope);
		queryParams.add("redirect_uri", redirectUrl);
		queryParams.add("uuid", RequestCorrelation.getCorrelationId());
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUri + "/v1/token").queryParams(queryParams);
//		URI uri = builder.build().encode().toUri();
//		logger.info("API remote URL: " + uri.toString());
//        logger.info("API input header => Authorization: " + authHeader);
//        logger.info("API input header => Content-Type: " + MediaType.APPLICATION_FORM_URLENCODED_VALUE);
//        logger.info("API input parameters => grant_type: " + "authorization_code" + ",code: " + code 
//            + ",scope: " + scope + ",redirect_uri: " + redirectUrl + ",uuid: " + RequestCorrelation.getCorrelationId());

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(null, headers);
		logger.info("API input -> " + entity);

		ResponseEntity<BankingOAuthToken> token = this.retryableExecute(builder.build().encode().toUri(), HttpMethod.POST,
				entity, BankingOAuthToken.class);
		logger.info("API output <- " + token);

        if (token.getStatusCode().is4xxClientError()) {
            // トークン取得失敗
            // 例：400 { "error":"invalid_grant" }
            logger.info("ログオン失敗。OAuthトークンを取得失敗。Apiから返したレスポンスコード：" + token.getStatusCodeValue());
            throw new ApplicationException(MessageConst.E001001000000);
        } else if (token.getStatusCode().is5xxServerError()) {
            // トークン取得失敗
            logger.info("ログオン失敗。OAuthトークンを取得失敗。Apiから返したレスポンスコード：" + token.getStatusCodeValue());
            throw new ApplicationException(MessageConst.E001001000001);
        } else if (!token.getStatusCode().is2xxSuccessful()) {
            logger.info("ログオン失敗。OAuthトークンを取得失敗。Apiから返したレスポンスコード：" + token.getStatusCodeValue());
            throw new ApplicationException(MessageConst.E001001000002);
        }

		BankingOAuthToken body = token.getBody();
		logger.debug("API Call Result: アクセストークン発行要求（認可コード使用）API getAccessToken:{}", body.getAccessToken());
		logger.debug("API Call Result: アクセストークン発行要求（認可コード使用）API getRefreshToken:{}", body.getRefreshToken());

		logger.info("API Call End: アクセストークン発行要求（認可コード使用）API");
		return body;
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
	public ResponseEntity<OtpIssueRes> otpIssueNotifyMethod(HeaderInfoRes headerInfo, String service,
			String notifyMethod, OtpIssueReq request) {
		logger.info("### Remote API call start: [POST] " + remoteBaseUrl
				+ RemoteConstant.OTP_ISSUE_INFO_PATH.concat("/" + service + "/" + notifyMethod));

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(remoteBaseUrl + RemoteConstant.OTP_ISSUE_INFO_PATH).path("/" + service)
				.path("/" + notifyMethod);

		HttpEntity<OtpIssueReq> entity = new HttpEntity<OtpIssueReq>(request, postAddressChangeHeaderMap(headerInfo));
		logger.info("API input -> " + entity);

		ResponseEntity<OtpIssueRes> responseEntity = execute(builder.build().encode().toUri(), HttpMethod.POST, entity,
				OtpIssueRes.class);

		logger.info("API output <- " + responseEntity);
		logger.info("### Remote API call end: [POST] " + remoteBaseUrl
				+ RemoteConstant.OTP_ISSUE_INFO_PATH.concat("/" + service + "/" + notifyMethod));
		return responseEntity;
	}


	protected <T> ResponseEntity<T> retryableExecute(URI uri, HttpMethod method,
			HttpEntity<MultiValueMap<String, String>> entity, Class<T> targetClass) {

		try {
			logger.info("API Calling: uri:{}", uri.toString());

			if (entity != null) {
				HttpHeaders headers = entity.getHeaders();
				if (headers != null) {
					for (Entry<String, List<String>> key : headers.entrySet()) {
						for (String v : key.getValue()) {
							logger.debug("API Calling: headerKey:{}, Value:{}", key.getKey(), v);
						}
					}
				}
				logger.info("API Calling: entity.body:{}", entity.getBody());
			}
			ResponseEntity<T> responseEntity = restTemplate.exchange(uri, method, entity, targetClass);
			return responseEntity;
		} catch (ResourceAccessException timeoutE) {

			try {
				Thread.sleep(retryTimeInterval);

				ResponseEntity<T> responseEntity = restTemplate.exchange(uri, method, entity, targetClass);
				return responseEntity;

			} catch (ResourceAccessException retryTimeoutE) {

				logger.info("リモートサービスサービスとの通信に失敗しました。(Retry失敗)。Cause:{} ,Message:{}", retryTimeoutE.getCause(),
						retryTimeoutE.getMessage(), retryTimeoutE);
				throw new SystemException(MessageConst.E000000004003);

			} catch (InterruptedException e) {

				logger.info("リモートサービスサービスとの通信に失敗しました。(RetryInterval待機失敗)。Cause:{} ,Message:{}", e.getCause(), e.getMessage(), e);
				throw new SystemException(MessageConst.E000000004002);

			}
		}
	}
}
