package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.bean.req.UpdUselessReissueReq;
import com.ibm.business.bean.res.GetUselessReissueRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdUselessReissueRes;

/**
 * 利用不能カード再発行用登録内容照会・更新
 *
 */
public interface UselessReissueRemote {

    /**
     * 利用不能によるカード再発行申込を照会する。
     * 
     * @param header ヘッダー
     * @return レスポンス・エンティティ
     */
    public ResponseEntity<GetUselessReissueRes> getUselessReissue(HeaderInfoRes headerInfo);

    /**
     * 利用不能によるカード再発行申込を受け付ける。
     * 
     * @param header ヘッダー
     * @param request 利用不能によるカード再発行申込情報
     * @return レスポンス・エンティティ
     */
    public ResponseEntity<UpdUselessReissueRes> postUselessReissue(HeaderInfoRes headerInfo,
            UpdUselessReissueReq request);
}
