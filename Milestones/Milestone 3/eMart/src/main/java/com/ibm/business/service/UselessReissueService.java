package com.ibm.business.service;

import com.ibm.business.bean.req.UpdUselessReissueReq;
import com.ibm.business.bean.res.GetUselessReissueRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdUselessReissueRes;
import com.ibm.business.remote.bean.RemoteApiServerResponse;

/**
 * 利用不能カード再発行用登録内容照会・更新
 *
 */
public interface UselessReissueService {

    /**
     * 口座情報に紐づく再発行可能物件と連絡先（送付先住所・電話番号）を照会する。
     * <p>
     * 再発行可能物件がない場合は、エラーを応答する。
     * </p>
     * 
     * @param headerInfo ヘッダー部
     * @return 再発行可能物件と連絡先（送付先住所・電話番号）の照会情報
     */
    public RemoteApiServerResponse<GetUselessReissueRes> getUselessReissue(HeaderInfoRes headerInfo);

    /**
     * 利用不能によるカード再発行申込を受け付ける。
     * 
     * @param header ヘッダー
     * @param request 利用不能によるカード再発行申込情報
     * @return 利用不能によるカード再発行申込結果情報
     */
    public RemoteApiServerResponse<UpdUselessReissueRes> postUselessReissue(HeaderInfoRes headerInfo,
            UpdUselessReissueReq request);

}
