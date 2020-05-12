package com.ibm.business.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.bean.req.UpdUselessReissueReq;
import com.ibm.business.bean.res.GetUselessReissueRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdUselessReissueRes;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.remote.UselessReissueRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.UselessReissueService;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
 * 利用不能カード再発行用登録内容照会・更新
 *
 */
@Service("uselessReissueService")
public class UselessReissueServiceImpl extends BaseServiceImpl implements UselessReissueService {

    @Resource(name = "uselessReissueRemote")
    private UselessReissueRemote uselessReissueRemote;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 口座情報に紐づく再発行可能物件と連絡先（送付先住所・電話番号）を照会する。
     * <p>
     * 再発行可能物件がない場合は、エラーを応答する。
     * </p>
     * 
     * @param headerInfo ヘッダー部
     * @return 再発行可能物件と連絡先（送付先住所・電話番号）の照会情報
     */
    @Override
    public RemoteApiServerResponse<GetUselessReissueRes> getUselessReissue(
            HeaderInfoRes headerInfo) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<GetUselessReissueRes> res =
                uselessReissueRemote.getUselessReissue(headerInfo);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            GetUselessReissueRes getUselessReissueRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (getUselessReissueRes != null
                    && !StringUtil.isEmpty(getUselessReissueRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(getUselessReissueRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        GetUselessReissueRes getUselessReissueRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<GetUselessReissueRes> remoteApiServerResponse =
                new RemoteApiServerResponse<GetUselessReissueRes>(getUselessReissueRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * 利用不能によるカード再発行申込を受け付ける。
     * 
     * @param header ヘッダー
     * @param request 利用不能によるカード再発行申込情報
     * @return 利用不能によるカード再発行申込結果情報
     */
    @Override
    public RemoteApiServerResponse<UpdUselessReissueRes> postUselessReissue(
            HeaderInfoRes headerInfo, UpdUselessReissueReq request) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<UpdUselessReissueRes> res =
                uselessReissueRemote.postUselessReissue(headerInfo, request);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            UpdUselessReissueRes updUselessReissueRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (updUselessReissueRes != null
                    && !StringUtil.isEmpty(updUselessReissueRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(updUselessReissueRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        UpdUselessReissueRes updUselessReissueRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<UpdUselessReissueRes> remoteApiServerResponse =
                new RemoteApiServerResponse<UpdUselessReissueRes>(updUselessReissueRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }

}
