package com.ibm.business.remote.impl;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.exception.SystemException;
import com.ibm.business.exception.UnauthorizedException;
import com.ibm.business.message.MessageConst;
import com.ibm.business.service.impl.BaseServiceImpl;
import com.ibm.business.util.HttpHeaderUtil;

/**
 * リモート通信のベースクラス
 * 
 * @author ShiYan May 28, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 */
public class BaseRemoteImpl extends BaseServiceImpl {

	private static final Logger logger = LogManager.getLogger(BaseRemoteImpl.class);

	@Value(value = "${remote.base.url}")
	protected String remoteBaseUrl;

	@Value(value = "${remote.mock.mode}")
	protected String mockMode;

	@Value(value = "${remote.http.header.value.ibm.client.id}")
	protected String ibmClientId;

	@Value(value = "${remote.http.header.value.client.id}")
	protected String clientId;

	@Value(value = "${remote.http.header.value.redirect.uri}")
	protected String redirectUri;

	@Value(value = "${remote.http.header.value.grant.type}")
	protected String grantType;

	@Autowired
	private RestTemplate restTemplate;

    @Autowired
    HttpHeaderUtil httpHeaderUtil;
    
	/**
	 * アプリケーションコンテキスト
	 */
    //@Autowired
	//private ApplicationContext applicationContext;

	/**
	 * 住所変更のヘッダーマップを作成する
	 * @param headerInfo ヘッダー部
	 * @return 住所変更のヘッダーマップ
	 */
	protected HttpHeaders getAddressChangeHeaderMap(HeaderInfoRes headerInfo) {
	    HttpHeaders headers = new HttpHeaders();
        // ビジネスヘッダーを設定
        addHeaderInfo(headers, headerInfo);
        // システムヘッダーを設定
        addSystemHttpHeader(headers);
		return headers;
	}

	/**
     * 住所変更のヘッダーマップを作成する
     * @param headerInfo ヘッダー部
     * @return 住所変更のヘッダーマップ
     */
    protected HttpHeaders postAddressChangeHeaderMap(HeaderInfoRes headerInfo) {
        HttpHeaders headers = new HttpHeaders();
        // ビジネスヘッダーを設定
        addHeaderInfo(headers, headerInfo);
        // システムヘッダーを設定
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);// application/json
        addSystemHttpHeader(headers);
        return headers;
    }

    /**
     * 共通のヘッダーインフォーを設定する
     * @param headers HTTPヘッダー
     * @param headerInfo　ヘッダー部
     * @return HTTPヘッダー
     */
    protected HttpHeaders addHeaderInfo(HttpHeaders headers, HeaderInfoRes headerInfo) {
        headers.add(RemoteConstant.HEADER_PARAM_KEY_CLIENT_ID, headerInfo.getClientId());
        //headerMap.add(RemoteConstant.HEADER_PARAM_KEY_USERINFO, headerInfo.getUserinfo());
        //headerMap.add(RemoteConstant.HEADER_PARAM_KEY_AUTHTYPE, headerInfo.getAuthtype());
        headers.add(RemoteConstant.HEADER_PARAM_KEY_TRANSATIONID, headerInfo.getTransactionID());
        headers.add(RemoteConstant.HEADER_PARAM_KEY_ROUTINGINFO, headerInfo.getRoutingInfo());
        headers.add(RemoteConstant.HEADER_PARAM_KEY_AUTHORIZATION, "Bearer " + headerInfo.getAuthorization());
        headers.add(RemoteConstant.HEADER_PARAM_KEY_BANKCODE, headerInfo.getBankCode());
        headers.add(RemoteConstant.HEADER_PARAM_KEY_DEVICEID, headerInfo.getDeviceID());
        return headers;
    }
    
    /**
     * 汎用通信用のHTTPヘッダーを追加
     * <ol>
     *  <li>Accept: application/json</li>
     *  <li>Accept-Charset: UTF-8</li>
     * </ol>
     * @param headers　HTTPヘッダー
     * @return HTTPヘッダー
     */
    protected HttpHeaders addSystemHttpHeader(HttpHeaders headers) {
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);// application/json
        List<Charset> acceptCharsets = Collections.singletonList(StandardCharsets.UTF_8); // Accept-Charset:UTF-8
        headers.setAcceptCharset(acceptCharsets);
        return headers;
    }

    /**
     * リモート通信を実施
     * @param <T> クラス型
     * @param url URL
     * @param method メソッド
     * @param requestEntity リクエスト
     * @param responseType レスポンス
     * @return レスポンス・エンティティ
     */
    protected <T> ResponseEntity<T> execute(URI url, HttpMethod method, @Nullable HttpEntity<?> requestEntity,
			Class<T> responseType) {
		try {
		    ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, requestEntity, String.class);
		    // レスポンスヘッダー
		    HttpHeaders responseHeaders = responseEntity.getHeaders();
		    // レスポンスコード
		    HttpStatus responseHttpStatus = responseEntity.getStatusCode();
            // レスポンスボディ部
            String responseBody = responseEntity.getBody();
		    // TODO XXX BFOからerrorMessageが配列の場合は、暫定対応する
            ObjectMapper mapper = new ObjectMapper();
            // JacksonによりJSONをMapに解析
            Map<?, ?> responseMap = new HashMap();
            if(responseBody!=null && responseBody.length()>0) {
                responseMap = mapper.readValue(responseBody, Map.class);
            }
            @SuppressWarnings("rawtypes")
            HashMap newResponseMap = new HashMap();
            newResponseMap.putAll(responseMap);

            /*
             * サンプルエラーメッセージレスポンス
             * StatusCode: 200
             * {
             *   "errorMessage": [
             *     "userKanjiName  null データの桁数が有効な桁数の範囲内ではありません。データ[] 桁数の範囲[1-102]",
             *     "userName  null データの桁数が有効な桁数の範囲内ではありません。データ[] 桁数の範囲[1-71]",
             *     "beforeAddress[0].addressType 0 null 有効な形式ではありません。データ[0] 形式[[1-2]{1}]",
             *     "alteredAddress[0].addressCode 123-4567 null 有効な形式ではありません。データ[123-4567] 形式[[0-9]{7}]",
             *     "alteredAddress[0].addressType 0 null 有効な形式ではありません。データ[0] 形式[[1-2]{1}]"
             *   ],
             *   "errorCode": "biz error"
             * }
             */
            if(responseMap.containsKey("errorMessage")) {
                Object errorMessage = responseMap.get("errorMessage");
                if(errorMessage instanceof List) {
                    // リストの場合は、Stringに変換する（暫定対応）
                    @SuppressWarnings("rawtypes")
                    List errorMessageList = (List) errorMessage;
                    StringBuffer newErrorMessage = new StringBuffer();
                    for(int i=0;i<errorMessageList.size();i++) {
                        Object o = errorMessageList.get(i);
                        newErrorMessage.append(String.valueOf(o));
                        if(i<errorMessageList.size()-1) {
                            newErrorMessage.append(",");
                        }
                    }
                    newResponseMap.put("errorMessage", newErrorMessage.toString());
                    responseBody = mapper.writeValueAsString(newResponseMap);
                }
            }

            // JacksonによりJSONを対象クラスに解析
		    T resObject = mapper.readValue(responseBody, responseType);
            return ResponseEntity.status(responseHttpStatus) // ステータス
                    .headers(responseHeaders) // ヘッダー
                    .body(resObject); // ボディ
        } catch (UnauthorizedException e) {
            logger.error("Remote APIを呼び出す時未認証エラーが発生しました: [" + method + "] " + url, e);
            throw e;
		} catch (ResourceAccessException e ) {
		    logger.error("Remote APIを呼び出す時タイムアウトしました: [" + method + "] " + url, e);
		    throw new SystemException(MessageConst.E000000004001, e);
		} catch (RestClientResponseException e) {
		    // BackendApiから40x, 50xを返す場合はここで処理
		    logger.error("Remote APIを呼び出す時処理エラーが発生しました: [" + method + "] " + url + ", HTTPレスポンスコード: " + e.getRawStatusCode(), e);
		    throw new SystemException(MessageConst.E000000004004, e);
		} catch (RestClientException e) {
	        logger.error("Remote APIを呼び出す時予期しないエラーが発生しました: [" + method + "] " + url, e);
	        throw new SystemException(MessageConst.E000000004000, e);
		} catch (JsonParseException | JsonMappingException e) {
	        logger.error("Remote APIを呼び出す時JSON解析エラーが発生しました: [" + method + "] " + url, e);
	        throw new SystemException(MessageConst.E000000004005);
		} catch (Throwable e) {
            logger.error("Remote APIを呼び出す時予期しないエラーが発生しました: [" + method + "] " + url, e);
            throw new SystemException(MessageConst.E000000004000, e);
		}
	}

	/*protected <T> ResponseEntity<T> execute(URI url, HttpMethod method, @Nullable HttpEntity<?> requestEntity,
			ParameterizedTypeReference<T> responseType) {
        try {
            return restTemplate.exchange(url, method, requestEntity, responseType);
        } catch (UnauthorizedException e) {
            logger.error("Remote APIを呼び出す時未認証エラーが発生しました: [" + method + "] " + url, e);
            throw e;
        } catch (ResourceAccessException e ) {
            logger.error("Remote APIを呼び出す時タイムアウトしました: [" + method + "] " + url, e);
            throw new SystemException(ErrorConstant.SYS_REMOTE_IO_ERROR, e);
        } catch (RestClientResponseException e) {
            logger.error("Remote APIを呼び出す時処理エラーが発生しました: [" + method + "] " + url, e);
            // 一般は投げない
            throw new SystemException(ErrorConstant.SYS_REMOTE_ERROR, e);
        } catch (RestClientException e) {
            logger.error("Remote APIを呼び出す時エラーが発生しました: [" + method + "] " + url, e);
            throw new SystemException(ErrorConstant.SYS_REMOTE_ERROR, e);
        } catch (Throwable e) {
            logger.error("Remote APIを呼び出す時エラーが発生しました: [" + method + "] " + url, e);
            throw new SystemException(e);
        }
	}*/
}
