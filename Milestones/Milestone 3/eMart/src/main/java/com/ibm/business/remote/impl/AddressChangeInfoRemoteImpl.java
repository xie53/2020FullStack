package com.ibm.business.remote.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.bean.req.AddressPhonenumberReq;
import com.ibm.business.bean.res.AddressAndPhoneNumberListRes;
import com.ibm.business.bean.res.AddressChangeListRes;
import com.ibm.business.bean.res.AlteredAddressRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.PhoneNumberRes;
import com.ibm.business.bean.res.PlannedDatesRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.remote.AddressChangeInfoRemote;

/**
* 住所変更_住所・電話番号変更用登録内容照会・申込受付API
**/

@Service("addressChangeInfoRemote")
public class AddressChangeInfoRemoteImpl extends BaseRemoteImpl implements AddressChangeInfoRemote {
	
	private static final Logger logger = LogManager.getLogger(AddressChangeInfoRemoteImpl.class);

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
	public ResponseEntity<AddressChangeListRes> getAddressInfo(HeaderInfoRes headerInfo, String searchType, String searchKey, String maxRowNumber) {
		logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.ADDRESS_CHANGE_INFO_BASE_PATH.concat("/" + searchType));
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.ADDRESS_CHANGE_INFO_BASE_PATH).path("/" + searchType)
				.queryParam("searchKey", searchKey)
				.queryParam("maxRowNumber", maxRowNumber);
		
//		logger.info("API input header => client_id: " + headerInfo.getClientId() + ",userinfo: " + headerInfo.getUserinfo() + ",authtype: " + headerInfo.getAuthtype()
//					+ ",transactionID: " + headerInfo.getTransactionID() + ",routingInfo: " + headerInfo.getRoutingInfo() + ",Authorization: " + headerInfo.getAuthorization());
//		logger.info("API input parameters => bankCode: " + bankCode + ",deviceID: " + deviceID + ",searchKey: " + searchKey + ",maxRowNumber: " + maxRowNumber);

		HttpEntity<String> entity = new HttpEntity<>(null, getAddressChangeHeaderMap(headerInfo));
		logger.info("API input -> " + entity);

		ResponseEntity<AddressChangeListRes> responseEntity = execute(builder.build().encode().toUri(), HttpMethod.GET, entity, AddressChangeListRes.class);

		/*
		 * // TODO Mock - Need to be deleted if (mockMode.equals("true")) { if
		 * (responseEntity == null || responseEntity.getBody() == null) { BankInfosRes
		 * res = new BankInfosRes();
		 * 
		 * BankInfoRes bankInfoRes1 = new BankInfoRes();
		 * bankInfoRes1.setBankToken("banktoken001");
		 * bankInfoRes1.setBankName("三菱UFJ銀行"); bankInfoRes1.setBankNameKana("");
		 * BankInfoRes bankInfoRes2 = new BankInfoRes();
		 * bankInfoRes2.setBankToken("banktoken002"); bankInfoRes2.setBankName("みずほ銀行");
		 * bankInfoRes2.setBankNameKana("");
		 * 
		 * res.getBankInfos().add(bankInfoRes1); res.getBankInfos().add(bankInfoRes2);
		 * 
		 * responseEntity = new ResponseEntity<BankInfosRes>(res, HttpStatus.OK); } }
		 */
		
		logger.info("API output <- " + responseEntity);
		logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.ADDRESS_CHANGE_INFO_BASE_PATH.concat("/" + searchType));
		return responseEntity;
	}

    /**
     * 口座情報に紐づく登録済住所（最大2つ）と電話番号（最大3つ）を照会する。
     * 
     * @param header ヘッダー
     * @return 口座情報に紐づく住所・電話番号の照会情報
     */
	@Override
	public ResponseEntity<AddressAndPhoneNumberListRes> getAddressOrTelephoneInfo(HeaderInfoRes headerInfo) {
		logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);

		HttpEntity<String> entity = new HttpEntity<>(null, getAddressChangeHeaderMap(headerInfo));
		logger.info("API input -> " + entity);

		ResponseEntity<AddressAndPhoneNumberListRes> responseEntity = execute(builder.build().encode().toUri(),
				HttpMethod.GET, entity, AddressAndPhoneNumberListRes.class);

		logger.info("API output <- " + responseEntity);
		logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);
		return responseEntity;
	}

    /**
     * テスト日時が設定されている場合、テスト日時での処理予定日を照会する。
     * 
     * @param headerInfo ヘッダー
     * @return 処理予定日情報
     */
	@Override
	public ResponseEntity<PlannedDatesRes> getPlannedDatesInfo(HeaderInfoRes headerInfo) {
		logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.PLANNED_DATES_PATH);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.PLANNED_DATES_PATH);

//		logger.info("API input header => client_id: " + headerInfo.getClientId() + ",userinfo: " + headerInfo.getUserinfo() + ",authtype: " + headerInfo.getAuthtype()
//					+ ",transactionID: " + headerInfo.getTransactionID() + ",routingInfo: " + headerInfo.getRoutingInfo() + ",Authorization: " + headerInfo.getAuthorization());

		HttpEntity<String> entity = new HttpEntity<>(null, getAddressChangeHeaderMap(headerInfo));
		logger.info("API input -> " + entity);

		ResponseEntity<PlannedDatesRes> responseEntity = execute(builder.build().encode().toUri(), HttpMethod.GET, entity, PlannedDatesRes.class);

		// TODO Mock - Need to be deleted
		if (mockMode.equals("true")) {
			if (responseEntity == null || responseEntity.getBody() == null) {
				PlannedDatesRes res = new PlannedDatesRes();
				
				res.setPlannedDates("2020-05-20");
	
				responseEntity = new ResponseEntity<PlannedDatesRes>(res, HttpStatus.OK);
			}
		}

		logger.info("API output <- " + responseEntity);
		logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.PLANNED_DATES_PATH);
		return responseEntity;
	}

	/**
	 * エンドユーザーの登録済住所（最大2つ）と電話番号（最大3つ）の変更申込を受け付ける。
	 * 
	 * @param headerInfo ヘッダー部
	 * @param request    口座情報に紐づく住所・電話番号の申込情報
	 * @return 変更後住所・電話番号の情報
	 */
	@Override
	public ResponseEntity<ReceiptNumberInfoRes> sendAddressOrTelephoneAcceptInfo(HeaderInfoRes headerInfo,
			AddressPhonenumberReq request) {
		logger.info("### Remote API call start: [POST] " + remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);

//		ObjectMapper objectMapper = new ObjectMapper();
//		String params = null;
//		try {
//			params = objectMapper.writeValueAsString(request);
//		} catch (JsonProcessingException e) {
//			logger.error("### Failed parse json from object: " + request);
//		}
        HttpEntity<AddressPhonenumberReq> entity =
                new HttpEntity<AddressPhonenumberReq>(request, postAddressChangeHeaderMap(headerInfo));
		logger.info("API input -> " + entity);

		ResponseEntity<ReceiptNumberInfoRes> responseEntity = execute(builder.build().encode().toUri(), HttpMethod.POST,
				entity, ReceiptNumberInfoRes.class);

		// TODO Mock - Need to be deleted
		if (mockMode.equals("true")) {
			if (responseEntity == null || responseEntity.getBody() == null) {
				ReceiptNumberInfoRes res = new ReceiptNumberInfoRes();

				AlteredAddressRes alteredAddress1 = new AlteredAddressRes();
				alteredAddress1.setZipCode("021-1234");
				alteredAddress1.setKanjiAddress("東京都ソートテスト区");
				alteredAddress1.setAddress("ﾄｳｷｮｳﾄｿｰﾄﾃｽﾄｼ");
				alteredAddress1.setAddressType("2");
				alteredAddress1.setAddressDeleteFlag(true);
				res.getAlteredAddress().add(alteredAddress1);

				PhoneNumberRes phoneNumber1 = new PhoneNumberRes();
				phoneNumber1.setPhoneNumber("012-1234-5678");
				phoneNumber1.setPhoneType("0");
				res.getAlteredPhoneNumber().add(phoneNumber1);

				res.setReceiptNumberCustomer("C-11-0045");

				responseEntity = new ResponseEntity<ReceiptNumberInfoRes>(res, HttpStatus.OK);
			}
		}

		logger.info("API output <- " + responseEntity);
		logger.info("### Remote API call end: [POST] " + remoteBaseUrl + RemoteConstant.ADDRESS_PHONE_NUMBER_PATH);
		return responseEntity;
	}

}
