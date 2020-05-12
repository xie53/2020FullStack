package com.ibm.business.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.bean.res.GetReissueChargeinfoRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.remote.ReissueChargeInfoRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.ReissueChargeInfoService;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
 * 再発行手数料情報照会API
 *
 */
@Service("reissueChargeInfoService")
public class ReissueChargeInfoServiceImpl extends BaseServiceImpl
        implements ReissueChargeInfoService {
    /**　ロガー */
    private static final Logger logger = LogManager.getLogger(ReissueChargeInfoServiceImpl.class);

    @Resource(name = "reissueChargeInfoRemote")
    ReissueChargeInfoRemote reissueChargeInfoRemote;

    @Autowired
    TokenUtil tokenUtil;

    /**
     * 指定された物件の再発行手数料、および、引き落とし可能な口座情報を応答する。<br>
     * カード再発行枚数と通帳再発行枚数はどちらか片方のみ有効とし、どちらも設定がないケース、および、両方設定されているケースはエラーを応答する。
     * <p>
     * テスト日時が設定されている場合、テスト日時での再発行手数料を照会する。
     * 判定基準は、照会時点（サーバ処理時点）とする。
     * 手数料徴収可能な口座を保有していない場合、エラーを応答する。
     * </p>
     * 
     * @param header ヘッダー
     * @param cashcardCount カード再発行枚数
     * @param passbookCount 通帳再発行枚数
     * @return 指定された物件の再発行手数料、および、引き落とし可能な口座情報
     */
    @Override
    public RemoteApiServerResponse<GetReissueChargeinfoRes> getReissueChargeInfo(
            HeaderInfoRes headerInfo, String cashcardCount, String passbookCount) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<GetReissueChargeinfoRes> res = reissueChargeInfoRemote
                .getReissueChargeInfo(headerInfo, cashcardCount, passbookCount);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            GetReissueChargeinfoRes getReissueChargeInfoRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (getReissueChargeInfoRes != null
                    && !StringUtil.isEmpty(getReissueChargeInfoRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(getReissueChargeInfoRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        GetReissueChargeinfoRes getReissueChargeInfoRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<GetReissueChargeinfoRes> remoteApiServerResponse =
                new RemoteApiServerResponse<GetReissueChargeinfoRes>(getReissueChargeInfoRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }
}
