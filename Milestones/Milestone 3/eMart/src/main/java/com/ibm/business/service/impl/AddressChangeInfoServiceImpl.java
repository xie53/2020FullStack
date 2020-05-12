package com.ibm.business.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.business.bean.req.AddressPhonenumberReq;
import com.ibm.business.bean.res.AddressAndPhoneNumberListRes;
import com.ibm.business.bean.res.AddressChangeListRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.PlannedDatesRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;
import com.ibm.business.exception.RemoteApiApplicationException;
import com.ibm.business.exception.SystemException;
import com.ibm.business.remote.AddressChangeInfoRemote;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.service.AddressChangeInfoService;
import com.ibm.business.util.StringUtil;
import com.ibm.business.util.TokenUtil;

/**
* 住所変更_住所・電話番号変更用登録内容照会・申込受付API
**/

@Service("addressChangeInfoService")
public class AddressChangeInfoServiceImpl extends BaseServiceImpl
        implements AddressChangeInfoService {

    @Resource(name = "addressChangeInfoRemote")
    private AddressChangeInfoRemote addressChangeInfoRemote;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * エンドユーザーが入力した検索条件に合致する郵便番号住所リストを応答する。
     * 
     * @param headerInfo ヘッダー
     * @param searchType 検索タイプ: 郵便番号/漢字住所
     * @param searchKey 検索キー
     * @param maxRowNumber 検索結果の最大応答数
     * @return 郵便番号住所リストの照会情報
     */
    @Override
    public RemoteApiServerResponse<AddressChangeListRes> getAddressInfo(HeaderInfoRes headerInfo,
            String searchType, String searchKey, String maxRowNumber) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<AddressChangeListRes> res = addressChangeInfoRemote
                .getAddressInfo(headerInfo, searchType, searchKey, maxRowNumber);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            AddressChangeListRes addressChangeListRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (addressChangeListRes != null
                    && !StringUtil.isEmpty(addressChangeListRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(addressChangeListRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        AddressChangeListRes addressChangeListRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<AddressChangeListRes> remoteApiServerResponse =
                new RemoteApiServerResponse<AddressChangeListRes>(addressChangeListRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * 口座情報に紐づく登録済住所（最大2つ）と電話番号（最大3つ）を照会する。
     * 
     * @param header ヘッダー
     * @return 口座情報に紐づく住所・電話番号の照会情報
     */
    @Override
    public RemoteApiServerResponse<AddressAndPhoneNumberListRes> getAddressOrTelephoneInfo(
            HeaderInfoRes headerInfo) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<AddressAndPhoneNumberListRes> res =
                addressChangeInfoRemote.getAddressOrTelephoneInfo(headerInfo);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            AddressAndPhoneNumberListRes addressAndPhoneNumberListRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (addressAndPhoneNumberListRes != null
                    && !StringUtil.isEmpty(addressAndPhoneNumberListRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(addressAndPhoneNumberListRes,
                        responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        AddressAndPhoneNumberListRes addressAndPhoneNumberListRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<AddressAndPhoneNumberListRes> remoteApiServerResponse =
                new RemoteApiServerResponse<AddressAndPhoneNumberListRes>(
                        addressAndPhoneNumberListRes, responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * テスト日時が設定されている場合、テスト日時での処理予定日を照会する。
     * 
     * @param headerInfo ヘッダー
     * @return 処理予定日情報
     */
    @Override
    public RemoteApiServerResponse<PlannedDatesRes> getPlannedDatesInfo(HeaderInfoRes headerInfo) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<PlannedDatesRes> res =
                addressChangeInfoRemote.getPlannedDatesInfo(headerInfo);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            PlannedDatesRes plannedDatesRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (plannedDatesRes != null && !StringUtil.isEmpty(plannedDatesRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(plannedDatesRes, responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        PlannedDatesRes plannedDatesRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<PlannedDatesRes> remoteApiServerResponse =
                new RemoteApiServerResponse<PlannedDatesRes>(plannedDatesRes, responseHeaderMap);
        return remoteApiServerResponse;
    }

    /**
     * エンドユーザーの登録済住所（最大2つ）と電話番号（最大3つ）の変更申込を受け付ける。
     * 
     * @param headerInfo ヘッダー部
     * @param request 口座情報に紐づく住所・電話番号の申込情報
     * @return 変更後住所・電話番号の情報
     */
    @Override
    public RemoteApiServerResponse<ReceiptNumberInfoRes> sendAddressOrTelephoneAcceptInfo(
            HeaderInfoRes headerInfo, AddressPhonenumberReq request) {
        // リモートApi通信用のOAuthTokenを設定
        tokenUtil.setOAuthToken(headerInfo);
        // リモートApi通信
        ResponseEntity<ReceiptNumberInfoRes> res =
                addressChangeInfoRemote.sendAddressOrTelephoneAcceptInfo(headerInfo, request);
        // ヘッダー部を取得
        HttpHeaders httpHeaders = res.getHeaders();
        // 取引ID、経路選択情報をヘッダーマップに設定
        Map<String, String> responseHeaderMap = createResponseHeaderMap(httpHeaders);

        // サーバリスポンスがOKかを判断する
        if (!isOK(res)) {
            // エラーの場合
            // ボディ部を取得
            ReceiptNumberInfoRes addressAndPhoneNumberListRes = res.getBody();
            // リモートApiサーバ・レスポンスからのエラーコード・エラーメッセージを設定する場合
            if (addressAndPhoneNumberListRes != null
                    && !StringUtil.isEmpty(addressAndPhoneNumberListRes.getErrorCode())) {
                // アプリケーションエラーを投げる
                throw new RemoteApiApplicationException(addressAndPhoneNumberListRes,
                        responseHeaderMap);
            } else {
                // その他の場合はシステムエラーを投げる
                throw new SystemException(responseHeaderMap);
            }
        }
        // ボディ部を取得
        ReceiptNumberInfoRes addressAndPhoneNumberListRes = res.getBody();
        // 返したレスポンスを作成
        RemoteApiServerResponse<ReceiptNumberInfoRes> remoteApiServerResponse =
                new RemoteApiServerResponse<ReceiptNumberInfoRes>(addressAndPhoneNumberListRes,
                        responseHeaderMap);
        return remoteApiServerResponse;
    }

}
