package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.bean.req.UpdLostReissueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdLostReissueRes;

/**
 * 喪失による再発行の申込を受け付ける
 *
 */
public interface LostReissueRemote {

    /**
     * 喪失による再発行の申込を受け付ける
     * 
     * @param header ヘッダー
     * @param request 喪失による再発行の申込情報
     * @return レスポンス・エンティティ
     */
    public ResponseEntity<UpdLostReissueRes> postLostReissue(HeaderInfoRes headerInfo,
            UpdLostReissueReq request);

}
