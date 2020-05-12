package com.ibm.business.remote.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * リモートAPIから返したレスポンスオブジェクト
 *
 * @param <T> 対象クラス
 */
public class RemoteApiServerResponse<T> implements java.io.Serializable {

    private static final long serialVersionUID = 1471593749605564622L;
    /** 業務処理 */
    private T response;
    /** ヘッダーマップ */
    private Map<String, String> headers = new HashMap<String, String>();

    public RemoteApiServerResponse(T response, Map<String, String> headers) {
        this.response = response;
        this.headers = headers;
    }

    public RemoteApiServerResponse(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "ServerResponse [response=" + response + ", headers=" + headers + "]";
    }


}
