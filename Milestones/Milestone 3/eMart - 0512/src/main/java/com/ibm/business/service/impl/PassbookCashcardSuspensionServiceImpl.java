package com.ibm.business.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.bean.req.UpdPassbookCashcardSuspensionReq;
import com.ibm.business.bean.res.GetPassbookCashcardSuspensionRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdPassbookCashcardSuspensionRes;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.remote.PassbookCashcardSuspensionRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.PassbookCashcardSuspensionService;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
 * 利用停止・再発行用登録内容照会API
 *
 */
@Service("passbookCashcardSuspensionService")
public class PassbookCashcardSuspensionServiceImpl extends BaseServiceImpl
        implements PassbookCashcardSuspensionService {

    @Resource(name = "passbookCashcardSuspensionRemote")
    private PassbookCashcardSuspensionRemote passbookCashcardSuspensionRemote;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）を照会する。
     * 
     * @param headerInfo ヘッダー部
     * @return 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の照会情報
     */
    @Override
    public RemoteApiServerResponse<GetPassbookCashcardSuspensionRes> getGetPassbookCashcardSuspension(
            HeaderInfoRes headerInfo) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<GetPassbookCashcardSuspensionRes> res =
                passbookCashcardSuspensionRemote.getPassbookCashcardSuspension(headerInfo);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            GetPassbookCashcardSuspensionRes getPassbookCashcardSuspensionRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (getPassbookCashcardSuspensionRes != null
                    && !StringUtil.isEmpty(getPassbookCashcardSuspensionRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(getPassbookCashcardSuspensionRes,
                        responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        GetPassbookCashcardSuspensionRes addressAndPhoneNumberListRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<GetPassbookCashcardSuspensionRes> remoteApiServerResponse =
                new RemoteApiServerResponse<GetPassbookCashcardSuspensionRes>(
                        addressAndPhoneNumberListRes, responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）を申込する。
     * 
     * @param headerInfo ヘッダー部
     * @param request 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）申込情報
     * @return 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の申込結果情報
     */
    @Override
    public RemoteApiServerResponse<UpdPassbookCashcardSuspensionRes> postGetPassbookCashcardSuspension(
            HeaderInfoRes headerInfo, UpdPassbookCashcardSuspensionReq request) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<UpdPassbookCashcardSuspensionRes> res = passbookCashcardSuspensionRemote
                .postPassbookCashcardSuspension(headerInfo, request);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            UpdPassbookCashcardSuspensionRes updPassbookCashcardSuspensionRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (updPassbookCashcardSuspensionRes != null
                    && !StringUtil.isEmpty(updPassbookCashcardSuspensionRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(updPassbookCashcardSuspensionRes,
                        responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        UpdPassbookCashcardSuspensionRes updPassbookCashcardSuspensionRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<UpdPassbookCashcardSuspensionRes> remoteApiServerResponse =
                new RemoteApiServerResponse<UpdPassbookCashcardSuspensionRes>(
                        updPassbookCashcardSuspensionRes, responseHeaderMap);
        return remoteApiServerResponse;
    }

}
