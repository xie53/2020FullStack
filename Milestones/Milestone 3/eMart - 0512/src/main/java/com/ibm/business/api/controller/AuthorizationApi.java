package com.ibm.business.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.api.response.EmptyResponse;
import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.bean.req.GetAccessTokenInfoReq;
import com.ibm.business.bean.req.OtpIssueReq;
import com.ibm.business.bean.res.AccessTokenRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.OtpIssueRes;
import com.ibm.business.bean.res.ReceiptNumberInfoRes;
import com.ibm.business.bean.res.RedirectUrlRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.CommonConst;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.remote.bean.RemoteApiServerResponseConverter;
import com.ibm.business.service.AddressChangeInfoService;
import com.ibm.business.service.AuthenticationService;
import com.ibm.business.util.RequestCorrelation;
import com.ibm.business.validator.ValidateService;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = ApiConstant.DIGITAL_BASE_PATH)
public class AuthorizationApi extends BaseApi {

    private static final Logger logger = LogManager.getLogger(AuthorizationApi.class);

    @Value("${pbk.app.appStoreRedirectUrl}")
    String appStoreRedirectUrl;

    @Value("${pbk.app.googlePlayRedirectUrl}")
    String googlePlayRedirectUrl;

    @Resource(name = "authenticationService")
    private AuthenticationService authenticationService;

    @Resource(name = "addressChangeInfoService")
    private AddressChangeInfoService addressChangeInfoService;

    /** 入力チェックサービス */
    @Autowired
    ValidateService validateService;

    @RequestMapping(value = ApiConstant.CONTACT_CHANGE_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "コンテキスト・チェンジ", notes = "コンテキスト・チェンジ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = AccessTokenRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<AccessTokenRes> getContactChange(
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestParam(name = "bizKbn", required = false) String bizKbn,
            HttpServletResponse response) throws Exception {

        // 端末IDが全体の局面の変数に設定する
        RequestCorrelation.setDeviceId(deviceID);
        MDC.put("deviceId", deviceID);

        AccessTokenRes res = authenticationService.generateAccessToken(deviceID);

        // レスポンスへ変換
        ResponseEntity<AccessTokenRes> responseEntity = ResponseEntity.status(HttpStatus.OK) // レスポンスHTTPステータスコード
                .headers(createDefaultResponseHttpHeaders()) // レスポンスヘッダー
                .body(res); // ボディ部
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }

    @RequestMapping(value = ApiConstant.BANKING_RETAIL_AUTH_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "OAuth2認証URL取得", notes = "OAuth2認証URL取得")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = RedirectUrlRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<RedirectUrlRes> getOAuthRedirection(
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestParam(name = "bizKbn", required = false) String bizKbn,
            HttpServletResponse httpServletResponse) {

        // validation
        // headerのみのため、チェックなし

        String redirectString = authenticationService.getOAuthRedirect(deviceID);

        RedirectUrlRes redirectUrl = new RedirectUrlRes();
        redirectUrl.setRedirectUrl(redirectString);

        // レスポンスへ変換
        ResponseEntity<RedirectUrlRes> responseEntity = ResponseEntity.status(HttpStatus.OK) // レスポンスHTTPステータスコード
                .headers(createDefaultResponseHttpHeaders()) // レスポンスヘッダー
                .body(redirectUrl); // ボディ部
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }

    /**
     * アクセストークン発行要求API
     * OAuth2のトークンを取得する
     * @param appSecret アプリシークレット
     * @param accessToken BFFアクセストークン
     * @param deviceID デバイスID
     * @param code 認可コード
     * @param state ステート
     * @param httpServletResponse HTTPレスポンス
     * @return　HTTPレスポンスエンティティ
     */
    @ApiOperation(value = CommonConst.API_OAUTH2_OPE_CALLBACK_VALUE,
            notes = CommonConst.API_OAUTH2_OPE_CALLBACK_NOTES)
    @RequestMapping(value = CommonConst.API_OAUTH2_OPE_CALLBACK_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = EmptyResponse.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<EmptyResponse> callback(
			@RequestHeader(name = "appSecret", required = true) String appSecret,
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @ApiParam(
                    value = CommonConst.API_PARAM_CODE_VALUE + ", "
                            + CommonConst.API_PARAM_CODE_PATTERN,
                    required = true) @RequestParam(CommonConst.API_PARAM_CODE) String code,
            @ApiParam(
                    value = CommonConst.API_PARAM_STATE_VALUE + ", "
                            + CommonConst.API_PARAM_STATE_DESCRIPTION,
                    required = true) @RequestParam(CommonConst.API_PARAM_STATE) String state,
            HttpServletResponse httpServletResponse) {
    	
        // Validateチェック
    	GetAccessTokenInfoReq getAccessTokenInfoReq = new GetAccessTokenInfoReq();
        // 認可コード
    	getAccessTokenInfoReq.setCode(code);
        // ステート
    	getAccessTokenInfoReq.setState(state);
        // 入力チェック
        validateService.validate(getAccessTokenInfoReq);

        // ヘッダー部を作成
        HeaderInfoRes headerInfo = new HeaderInfoRes();

        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // OAuthTokenを設定
        headerInfo.setToken(accessToken);
    	
        // OAuthトークンをリモートApiから取得
        authenticationService.registerAccount(headerInfo, code, state);
        logger.info("### api result: OAUTHトークン取得成功");
        return ResponseEntity.status(HttpStatus.OK) // レスポンスHTTPステータスコード
                .headers(createDefaultResponseHttpHeaders()) // レスポンスヘッダー
                .body(new EmptyResponse());
    }

    /**
     * 認証_OTP発行API
     * @param service 住所·電話番号変更
     * @param notifyMethod 通知方法
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
    @ApiOperation(value = "Post OTP Issue Info", notes = "認証_OTP発行API")
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
    @PostMapping(value = ApiConstant.OTP_ISSUE_PATH)
    public ResponseEntity<OtpIssueRes> otpIssueNotifyMethod(
            @PathVariable(value = "service", required = true) String service,
            @PathVariable(value = "notifyMethod", required = true) String notifyMethod,
			@RequestHeader(name = "appSecret", required = true) String appSecret,
            @RequestHeader(name = "Authorization", required = true) String accessToken,
			@RequestHeader(name = "client_id", required = true) String clientId,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
			@RequestHeader(name = "bankCode", required = true) String bankCode,
			@RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestBody(required = true) OtpIssueReq otpIssueReq,
            HttpServletResponse httpServletResponse) throws Exception {

        // 入力チェック
        validateService.validate(otpIssueReq);

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
		RemoteApiServerResponse<OtpIssueRes> res = authenticationService.otpIssueNotifyMethod(headerInfo, service,
				notifyMethod, otpIssueReq);

		// レスポンスへ変換
		ResponseEntity<OtpIssueRes> responseEntity = new RemoteApiServerResponseConverter<OtpIssueRes>()
				.toResponseEntity(res);
		logger.info("### api result: " + responseEntity);
		return responseEntity;
    }
}