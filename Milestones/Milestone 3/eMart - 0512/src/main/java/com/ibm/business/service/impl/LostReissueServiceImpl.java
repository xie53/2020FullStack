package com.ibm.business.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.bean.req.UpdLostReissueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdLostReissueRes;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.remote.LostReissueRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.LostReissueService;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
 * 喪失による再発行サービス
 *
 */
@Service("lostReissueService")
public class LostReissueServiceImpl extends BaseServiceImpl implements LostReissueService {

    /**　ロガー */
    private static final Logger logger = LogManager.getLogger(LostReissueServiceImpl.class);

    @Resource(name = "lostReissueRemote")
    LostReissueRemote lostReissueRemote;

    @Autowired
    TokenUtil tokenUtil;


    /**
     * 喪失による再発行の申込を受け付ける
     * 
     * @param header ヘッダー
     * @param request 喪失による再発行の申込情報
     * @return 喪失による再発行の申込情報レスポンス
     */
    @Override
    public RemoteApiServerResponse<UpdLostReissueRes> postLostReissue(HeaderInfoRes headerInfo,
            UpdLostReissueReq request) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<UpdLostReissueRes> res =
                lostReissueRemote.postLostReissue(headerInfo, request);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            UpdLostReissueRes updLostReissueRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (updLostReissueRes != null
                    && !StringUtil.isEmpty(updLostReissueRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(updLostReissueRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        UpdLostReissueRes updLostReissueRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<UpdLostReissueRes> remoteApiServerResponse =
                new RemoteApiServerResponse<UpdLostReissueRes>(updLostReissueRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }
}
