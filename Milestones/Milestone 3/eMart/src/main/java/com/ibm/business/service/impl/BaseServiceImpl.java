package com.ibm.business.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.bean.res.AddressAndPhoneNumberListRes;
import com.ibm.business.bean.res.InitRemoteRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.RemoteConstant;

/**
 * サービスのベースクラス
 * 
 * @author ShiYan May 27, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 */
public abstract class BaseServiceImpl {

    protected boolean isSuccess(BaseResponse<?> res) {
        return null != res && ApiConstant.STATUS_OK.equals(res.getStatus());
    }

    /**
     * リモートAPIから返したHttpEntityがエラーかを判断する
     * @param entity ResponseEntity
     * @return エラーの場合はfalse、その他はtrue
     */
    protected boolean isOK(ResponseEntity<?> entity) {
        // HttpStatusCodeが200以外はfalseを返す
        if (!entity.getStatusCode().is2xxSuccessful()) {
            return false;
        }
        // body部のerrorCodeが空文字・NULL以外はfalseを返す
        Object body = entity.getBody();
        if (body != null && (body instanceof InitRemoteRes)) {
            InitRemoteRes res = (InitRemoteRes) body;
            return StringUtils.isEmpty(res.getErrorCode());
        }
        // body部なしの場合はtrueを返す
        return true;
    }

    /**
     * HttpHeadersからレスポンス・ヘッダーマップを作成
     * @param httpHeaders HTTPヘッダー
     * @return レスポンス・ヘッダーマップ
     */
    protected Map<String, String> createResponseHeaderMap(HttpHeaders httpHeaders) {
        Map<String, String> responseMap = new HashMap<String, String>();
        // 取引ID
        createResponseHeaderValue(httpHeaders, responseMap,
                RemoteConstant.HEADER_PARAM_KEY_TRANSATIONID);
        // 経路選択情報
        createResponseHeaderValue(httpHeaders, responseMap,
                RemoteConstant.HEADER_PARAM_KEY_ROUTINGINFO);
        return responseMap;
    }

    /**
     * HttpHeadersからレスポンス・ヘッダーマップを作成
     * @param httpHeaders HTTPヘッダー
     * @param responseMap レスポンス・ヘッダーマップ
     * @param key キー
     */
    private void createResponseHeaderValue(HttpHeaders httpHeaders, Map<String, String> responseMap,
            String key) {
        String val = httpHeaders.getFirst(key);
        if (!StringUtils.isEmpty(val)) {
            responseMap.put(key, val);
        }
    }
}
