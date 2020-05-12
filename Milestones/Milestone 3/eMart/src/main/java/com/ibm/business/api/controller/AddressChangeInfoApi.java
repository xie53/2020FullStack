package com.ibm.business.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.api.response.BankingOAuthToken;
import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.bean.req.AddressPhonenumberReq;
import com.ibm.business.bean.req.GetAddressInfoReq;
import com.ibm.business.bean.res.AddressAndPhoneNumberListRes;
import com.ibm.business.bean.res.AddressChangeListRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.PlannedDatesRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.CommonConst;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.remote.bean.RemoteApiServerResponseConverter;
import com.ibm.business.service.AddressChangeInfoService;
import com.ibm.business.service.AuthenticationService;
import com.ibm.business.validator.ValidateService;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
* 住所変更_住所・電話番号変更用登録内容照会・申込受付API
**/

@RestController
@RequestMapping(value = ApiConstant.DIGITAL_BASE_PATH + ApiConstant.ADDRESS_CHANGE_BASEPATH)
public class AddressChangeInfoApi extends BaseApi {

	private static final Logger logger = LogManager.getLogger(AddressChangeInfoApi.class);

	@Resource(name = "authenticationService")
    private AuthenticationService authenticationService;
	   
	@Resource(name = "addressChangeInfoService")
	private AddressChangeInfoService addressChangeInfoService;

    /** 入力チェックサービス */
    @Autowired
    ValidateService validateService;


    /**
     * 廃止(アクセストークン発行要求 + 住所・電話番号変更用登録内容照会API)
     *
     */
    @ApiOperation(value = "(廃止)" + CommonConst.API_OAUTH2_OPE_REDIRECT_VALUE, notes = CommonConst.API_OAUTH2_OPE_REDIRECT_NOTES)
    @RequestMapping(value = ApiConstant.ADDRESS_CHANGE_BASEPATH + ApiConstant.AUTH_GET_TOKEN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "正常", response = BaseResponse.class),
            @ApiResponse(code = 200, message = "ログオン失敗。再度ログオンしてください（E20000100000）", response = ErrorResponse.class),
            @ApiResponse(code = 400, message = "パラメータエラー（E40000100000）", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "アクセストークンが無効（E40100100000）", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "システムエラー（E50000100000）", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "データベース更新エラー（E50000100001）", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "リモートサービス接続エラー（E50000100002）", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "リモートサービスエラー（E50000100003）", response = ErrorResponse.class)
    })
    public ResponseEntity<AddressAndPhoneNumberListRes> callback(
            @RequestHeader(name = "Authorization", required = true) @NonNull String accessToken,
            @RequestHeader(name = "client_id", required = true) @NonNull String client_id,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) @NonNull String routingInfo,
            @RequestHeader(name = "bankCode", required = true) @NonNull String bankCode,
            @RequestHeader(name = "deviceID",required = true) @NonNull String deviceID,
            @ApiParam(value = CommonConst.API_PARAM_CODE_VALUE + ", "
                    + CommonConst.API_PARAM_CODE_PATTERN, required = true) @NotNull @RequestParam(CommonConst.API_PARAM_CODE) String code,
            @ApiParam(value = CommonConst.API_PARAM_STATE_VALUE + ", "
                    + CommonConst.API_PARAM_STATE_DESCRIPTION, required = true) @NotNull @RequestParam(CommonConst.API_PARAM_STATE) String state,
            HttpServletResponse httpServletResponse) {

        // ヘッダー部を作成
        HeaderInfoRes headerInfo = new HeaderInfoRes();

        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // BffTokenを設定
        headerInfo.setToken(accessToken);

        // OAuthトークンをリモートApiから取得
        BankingOAuthToken oauthToken = authenticationService.registerAccount(headerInfo, code, state);

        // クライアントID
        headerInfo.setClientId(client_id);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // OAuthTokenを設定
        headerInfo.setAuthorization(oauthToken.getAccessToken());
        // リモートApi通信
        RemoteApiServerResponse<AddressAndPhoneNumberListRes> res = addressChangeInfoService.getAddressOrTelephoneInfo(headerInfo);
        // レスポンスへ変換
        ResponseEntity<AddressAndPhoneNumberListRes> responseEntity = new RemoteApiServerResponseConverter<AddressAndPhoneNumberListRes>().toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }

    /**
     * 住所・電話番号変更用登録内容照会API
     * （店番、科目、口座番号）
     * @param appSecret アプリシークレット
     * @param accessToken BFFアクセストークン
     * @param clientId クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーツ情報
     * @param bankCode 金融機関コード
     * @param deviceID デバイスID
     * @param httpServletResponse HTTPレスポンス
     * @return　HTTPレスポンスエンティティ
     */
    @RequestMapping(value = ApiConstant.ADDRESS_PHONE_NUMBER_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "住所・電話番号変更用登録内容照会API（店番、科目、口座番号）", notes = "口座情報に紐づく登録済住所（最大2つ）と電話番号（最大3つ）を照会する")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = AddressAndPhoneNumberListRes.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<AddressAndPhoneNumberListRes> getAddressOrTelephoneInfo(
			@RequestHeader(name = "appSecret", required = true) String appSecret,
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "client_id", required = true) String clientId,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
            @RequestHeader(name = "bankCode", required = true) String bankCode,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            HttpServletResponse httpServletResponse) {

        // ヘッダー部を作成
        HeaderInfoRes headerInfo = new HeaderInfoRes();

        // クライアントID
        headerInfo.setClientId(clientId);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // OAuthTokenを設定
        headerInfo.setToken(accessToken);

        // リモートApi通信
        RemoteApiServerResponse<AddressAndPhoneNumberListRes> res = addressChangeInfoService.getAddressOrTelephoneInfo(headerInfo);

        // レスポンスへ変換
        ResponseEntity<AddressAndPhoneNumberListRes> responseEntity = new RemoteApiServerResponseConverter<AddressAndPhoneNumberListRes>().toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }

    /**
     * エンドユーザーの登録済住所（最大2つ）と電話番号（最大3つ）の変更申込を受け付けるAPI
     * @param appSecret アプリシークレット
     * @param accessToken BFFアクセストークン
     * @param clientId クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーツ情報
     * @param bankCode 金融機関コード
     * @param deviceID デバイスID
     * @param addressPhonenumberReq 登録済住所（最大2つ）と電話番号（最大3つ）の変更申込情報
     * @param httpServletResponse HTTPレスポンス
     * @return　HTTPレスポンスエンティティ
     */
	@RequestMapping(value = ApiConstant.ADDRESS_PHONE_NUMBER_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Send Address Or Telephone Accept Info", notes = "住所変更_住所·電話番号変更申込受付API")
	@ApiImplicitParams(value = {})
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = ReceiptNumberInfoRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
	public ResponseEntity<ReceiptNumberInfoRes> addressOrTelephoneAcceptInfo(
			@RequestHeader(name = "appSecret", required = true) String appSecret,
			@RequestHeader(name = "Authorization", required = true) String accessToken,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "transactionID", required = false) String transactionID,
			@RequestHeader(name = "routingInfo", required = true) String routingInfo,
			@RequestHeader(name = "bankCode", required = true) String bankCode,
			@RequestHeader(name = "deviceID", required = true) String deviceID,
			@RequestBody(required = true) AddressPhonenumberReq addressPhonenumberReq,
			HttpServletResponse httpServletResponse) throws Exception {

        // 入力チェック
        validateService.validate(addressPhonenumberReq);

		// ヘッダー部を作成
		HeaderInfoRes headerInfo = new HeaderInfoRes();
        // クライアントID
        headerInfo.setClientId(clientId);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // OAuthTokenを設定
        headerInfo.setToken(accessToken);

		// リモートApi通信
		RemoteApiServerResponse<ReceiptNumberInfoRes> res = addressChangeInfoService.sendAddressOrTelephoneAcceptInfo(headerInfo, addressPhonenumberReq);

		// レスポンスへ変換
		ResponseEntity<ReceiptNumberInfoRes> responseEntity = new RemoteApiServerResponseConverter<ReceiptNumberInfoRes>().toResponseEntity(res);
		logger.info("### api result: " + responseEntity);
		return responseEntity;
	}

    /**
     * 住所変更_郵便番号住所照会API
     * @param searchType 検索タイプ: 郵便番号/漢字住所
     * @param appSecret アプリシークレット
     * @param accessToken BFFアクセストークン
     * @param clientId クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーツ情報
     * @param bankCode 金融機関コード
     * @param deviceID デバイスID
     * @param searchKey 検索キー
     * @param maxRowNumber 検索結果の最大応答数
     * @param httpServletResponse HTTPレスポンス
     * @return　HTTPレスポンスエンティティ
     */
	@ApiOperation(value = "Get Address Info", notes = "住所変更_郵便番号住所照会API")
	@ApiImplicitParams(value = {})
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = AddressAndPhoneNumberListRes.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
	@GetMapping(ApiConstant.ADDRESS_CHANGE_RESOURCE)
	public ResponseEntity<AddressChangeListRes> getAddressInfo(
			@PathVariable(value = "searchType") String searchType,
			@RequestHeader(name = "appSecret", required = true) String appSecret,
			@RequestHeader(name = "Authorization", required = true) String accessToken,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "transactionID", required = false) String transactionID,
			@RequestHeader(name = "routingInfo", required = true) String routingInfo,
			@RequestHeader(name = "bankCode", required = true) String bankCode,
			@RequestHeader(name = "deviceID", required = true) String deviceID,
			@RequestParam(value = "searchKey", required = true) String searchKey,
			@RequestParam(value = "maxRowNumber", required = false) String maxRowNumber,
			HttpServletResponse httpServletResponse) throws Exception {

        // Validateチェック
		GetAddressInfoReq getAddressInfoReq = new GetAddressInfoReq();
        // 検索キー
		getAddressInfoReq.setSearchKey(searchKey);
        // 検索結果の最大応答数
		getAddressInfoReq.setMaxRowNumber(maxRowNumber);
        // 入力チェック
        validateService.validate(getAddressInfoReq);

        // ヘッダー部を作成
        HeaderInfoRes headerInfo = new HeaderInfoRes();

        // クライアントID
        headerInfo.setClientId(clientId);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // OAuthTokenを設定
        headerInfo.setToken(accessToken);

        // リモートApi通信
        RemoteApiServerResponse<AddressChangeListRes> res = addressChangeInfoService.getAddressInfo(headerInfo, searchType, searchKey, maxRowNumber);

        // レスポンスへ変換
        ResponseEntity<AddressChangeListRes> responseEntity = new RemoteApiServerResponseConverter<AddressChangeListRes>().toResponseEntity(res);

		logger.info("### api result: " + responseEntity);
		return responseEntity;
	}

    /**
     * 住所変更_処理予定日照会API
     * @param appSecret アプリシークレット
     * @param accessToken BFFアクセストークン
     * @param clientId クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーツ情報
     * @param bankCode 金融機関コード
     * @param deviceID デバイスID
     * @param searchKey 検索キー
     * @param maxRowNumber 検索結果の最大応答数
     * @param httpServletResponse HTTPレスポンス
     * @return　HTTPレスポンスエンティティ
     */
	@RequestMapping(value = ApiConstant.PLANNED_DATES_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get Planned Dates Info", notes = "住所変更_処理予定日照会API")
	@ApiImplicitParams(value = {})
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = AddressAndPhoneNumberListRes.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
	public ResponseEntity<PlannedDatesRes> getPlannedDatesInfo(
			@RequestHeader(name = "appSecret", required = true) String appSecret,
			@RequestHeader(name = "Authorization", required = true) String accessToken,
			@RequestHeader(name = "client_id", required = true) String clientId,
			@RequestHeader(name = "transactionID", required = false) String transactionID,
			@RequestHeader(name = "routingInfo", required = true) String routingInfo,
			@RequestHeader(name = "bankCode", required = true) @NonNull String bankCode,
			@RequestHeader(name = "deviceID", required = true) @NonNull String deviceID,
			HttpServletResponse httpServletResponse) throws Exception {

        // ヘッダー部を作成
        HeaderInfoRes headerInfo = new HeaderInfoRes();

        // クライアントID
        headerInfo.setClientId(clientId);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // OAuthTokenを設定
        headerInfo.setToken(accessToken);

        // リモートApi通信
        RemoteApiServerResponse<PlannedDatesRes> res = addressChangeInfoService.getPlannedDatesInfo(headerInfo);

        // レスポンスへ変換
        ResponseEntity<PlannedDatesRes> responseEntity = new RemoteApiServerResponseConverter<PlannedDatesRes>().toResponseEntity(res);

		logger.info("### api result: " + responseEntity);
		return responseEntity;
	}
}