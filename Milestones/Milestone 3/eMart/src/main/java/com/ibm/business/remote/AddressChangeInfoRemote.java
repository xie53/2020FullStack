package com.ibm.business.remote;

import org.springframework.http.ResponseEntity;

import com.ibm.business.bean.req.AddressPhonenumberReq;
import com.ibm.business.bean.res.AddressAndPhoneNumberListRes;
import com.ibm.business.bean.res.AddressChangeListRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.PlannedDatesRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;

/**
* 住所変更_住所・電話番号変更用登録内容照会・申込受付API
**/

public interface AddressChangeInfoRemote {

    /**
     * エンドユーザーが入力した検索条件に合致する郵便番号住所リストを応答する。
     * 
     * @param headerInfo ヘッダー
     * @param searchType 検索タイプ: 郵便番号/漢字住所
     * @param searchKey 検索キー
     * @param maxRowNumber 検索結果の最大応答数
     * @return 郵便番号住所リストの照会情報
     */
	public ResponseEntity<AddressChangeListRes> getAddressInfo(HeaderInfoRes headerInfo, String searchType, String searchKey, String maxRowNumber);

    /**
     * 口座情報に紐づく登録済住所（最大2つ）と電話番号（最大3つ）を照会する。
     * 
     * @param header ヘッダー
     * @return 口座情報に紐づく住所・電話番号の照会情報
     */
	public ResponseEntity<AddressAndPhoneNumberListRes> getAddressOrTelephoneInfo(HeaderInfoRes headerInfo);

    /**
     * テスト日時が設定されている場合、テスト日時での処理予定日を照会する。
     * 
     * @param headerInfo ヘッダー
     * @return 処理予定日情報
     */
	public ResponseEntity<PlannedDatesRes> getPlannedDatesInfo(HeaderInfoRes headerInfo);

    /**
     * エンドユーザーの登録済住所（最大2つ）と電話番号（最大3つ）の変更申込を受け付ける。
     * 
     * @param headerInfo ヘッダー部
     * @param request 口座情報に紐づく住所・電話番号の申込情報
     * @return 変更後住所・電話番号の情報
     */
	public ResponseEntity<ReceiptNumberInfoRes> sendAddressOrTelephoneAcceptInfo(HeaderInfoRes headerInfo, AddressPhonenumberReq request);

}
