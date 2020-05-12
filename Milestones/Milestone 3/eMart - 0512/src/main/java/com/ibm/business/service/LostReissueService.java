package com.ibm.business.service;

import com.ibm.business.bean.req.UpdLostReissueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdLostReissueRes;
import com.ibm.business.remote.bean.RemoteApiServerResponse;

/**
 * 喪失による再発行サービス
 *
 */
public interface LostReissueService {

    /**
     * 喪失による再発行の申込を受け付ける
     * 
     * @param header ヘッダー
     * @param request 喪失による再発行の申込情報
     * @return 喪失による再発行の申込情報レスポンス
     */
    public RemoteApiServerResponse<UpdLostReissueRes> postLostReissue(HeaderInfoRes headerInfo,
            UpdLostReissueReq request);

}
