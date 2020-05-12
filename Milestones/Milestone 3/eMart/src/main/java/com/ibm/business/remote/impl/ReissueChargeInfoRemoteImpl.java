package com.ibm.business.remote.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.bean.res.GetReissueChargeinfoRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.remote.ReissueChargeInfoRemote;

/**
 * 再発行手数料情報照会
 *
 */
@Service("reissueChargeInfoRemote")
public class ReissueChargeInfoRemoteImpl extends BaseRemoteImpl implements ReissueChargeInfoRemote {
    /** ロガー */
    private static final Logger logger = LogManager.getLogger(ReissueChargeInfoRemoteImpl.class);

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
     * @return レスポンス・エンティティ
     */
    @Override
    public ResponseEntity<GetReissueChargeinfoRes> getReissueChargeInfo(HeaderInfoRes headerInfo,
            String cashcardCount, String passbookCount) {
        logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.REISSUE_CHARGE_INFO_PATH);

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.REISSUE_CHARGE_INFO_PATH) //
                        .queryParam("cashcardCount", cashcardCount) // カード再発行枚数
                        .queryParam("passbookCount", passbookCount); // 通帳再発行枚数

        HttpEntity<String> entity = new HttpEntity<>(null, getAddressChangeHeaderMap(headerInfo));
        logger.info("API input -> " + entity);

        ResponseEntity<GetReissueChargeinfoRes> responseEntity =
                execute(builder.build().encode().toUri(), HttpMethod.GET, entity,
                        GetReissueChargeinfoRes.class);

        logger.info("API output <- " + responseEntity);
        logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.REISSUE_CHARGE_INFO_PATH);
        return responseEntity;
    }

}
