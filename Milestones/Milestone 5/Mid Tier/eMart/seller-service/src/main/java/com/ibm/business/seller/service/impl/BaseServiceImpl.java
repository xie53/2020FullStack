package com.ibm.business.seller.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.ibm.business.seller.bean.res.InitRemoteRes;
import com.ibm.business.seller.constant.ApiConstant;
import com.ibm.business.seller.response.BaseResponse;

/**
 * サービスのベースクラス
 * 
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
}
