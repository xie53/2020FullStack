package com.ibm.business.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.ibm.business.util.HttpHeaderUtil;

@Component
public class BaseApi {

    @Autowired
    HttpHeaderUtil httpHeaderUtil;

    /**
     * ディフォルトのレスポンスヘッダーを作成
     * @return レスポンスヘッダー
     */
    protected HttpHeaders createDefaultResponseHttpHeaders() {
        return httpHeaderUtil.createDefaultResponseHttpHeaders();
    }

}
