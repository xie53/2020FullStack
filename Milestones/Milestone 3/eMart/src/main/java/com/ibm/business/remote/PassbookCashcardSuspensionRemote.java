package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.bean.req.UpdPassbookCashcardSuspensionReq;
import com.ibm.business.bean.res.GetPassbookCashcardSuspensionRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdPassbookCashcardSuspensionRes;

/**
 * 利用停止・再発行用登録内容照会・更新
 *
 */
public interface PassbookCashcardSuspensionRemote {

    /**
     * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）を照会する。
     * <p>
     * 利用停止可能物件、および、再発行可能物件が1つもない場合は、エラーを応答する。
     * </p>
     * @param header ヘッダー
     * @return レスポンス・エンティティ
     */
    public ResponseEntity<GetPassbookCashcardSuspensionRes> getPassbookCashcardSuspension(
            HeaderInfoRes headerInfo);

    /**
     * 利用停止の申込を受け付け、オンラインで更新を行う。
     * 1物件単位（※）での申込が前提のため、「利用停止カード情報」と「利用停止通帳情報」の両方が含まれる場合はエラーを応答する。
     * 総合口座通帳は、口座単位ではなく、総合口座通帳単位（同一通帳種類）で1物件として扱う。
     * 
     * @param header ヘッダー
     * @param request 利用停止・再発行用登録情報
     * @return レスポンス・エンティティ
     */
    public ResponseEntity<UpdPassbookCashcardSuspensionRes> postPassbookCashcardSuspension(
            HeaderInfoRes headerInfo, UpdPassbookCashcardSuspensionReq request);


}
