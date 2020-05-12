package com.ibm.business.service;

import com.ibm.business.bean.req.UpdPassbookCashcardSuspensionReq;
import com.ibm.business.bean.res.GetPassbookCashcardSuspensionRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdPassbookCashcardSuspensionRes;
import com.ibm.business.remote.bean.RemoteApiServerResponse;

/**
 * 利用停止・再発行用登録内容照会API
 *
 */
public interface PassbookCashcardSuspensionService {

    /**
     * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）を照会する。
     * 
     * @param headerInfo ヘッダー部
     * @return 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の照会情報
     */
    RemoteApiServerResponse<GetPassbookCashcardSuspensionRes> getGetPassbookCashcardSuspension(
            HeaderInfoRes headerInfo);

    /**
     * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）を申込する。
     * 
     * @param headerInfo ヘッダー部
     * @param request 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）申込情報
     * @return 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の申込結果情報
     */
    RemoteApiServerResponse<UpdPassbookCashcardSuspensionRes> postGetPassbookCashcardSuspension(
            HeaderInfoRes headerInfo, UpdPassbookCashcardSuspensionReq request);

}
