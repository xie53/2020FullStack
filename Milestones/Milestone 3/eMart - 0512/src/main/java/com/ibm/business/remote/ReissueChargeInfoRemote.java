package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.bean.res.GetReissueChargeinfoRes;
import com.ibm.business.bean.res.HeaderInfoRes;

/**
 * 再発行手数料情報照会
 *
 */
public interface ReissueChargeInfoRemote {

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
    public ResponseEntity<GetReissueChargeinfoRes> getReissueChargeInfo(HeaderInfoRes headerInfo,
            String cashcardCount, String passbookCount);

}
