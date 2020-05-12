package com.ibm.business.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.api.response.BaseResponse;
import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.bean.req.UpdUselessReissueReq;
import com.ibm.business.bean.res.GetUselessReissueRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdUselessReissueRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.remote.bean.RemoteApiServerResponseConverter;
import com.ibm.business.service.UselessReissueService;
import com.ibm.business.validator.ValidateService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 利用不能カード再発行用登録内容照会・更新API
 *
 */
@RestController
@RequestMapping(value = ApiConstant.DIGITAL_BASE_PATH + ApiConstant.USELESS_REISSUE_PATH)
public class UselessReissueApi {

    /** ロガー */
    private static final Logger logger = LogManager.getLogger(LostReissueApi.class);

    @Resource(name = "uselessReissueService")
    UselessReissueService uselessReissueService;

    /** 入力チェックサービス */
    @Autowired
    ValidateService validateService;

    /**
     * 利用不能カード再発行用登録内容を照会する。
     * <p>
     * GET /api/v1/uselessreissue
     * </p>
     * @param accessToken BFFアクセストークン
     * @param clientID クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーティング情報
     * @param bankCode 銀行コード 
     * @param deviceID デバイスID
     * @param httpServletResponse HTTPレスポンス
     * @return 再発行可能物件と連絡先（送付先住所・電話番号）の照会情報
     */
    @ApiOperation(value = "利用不能カード再発行用登録内容を照会する", notes = "利用不能カード再発行用登録内容を照会する")
    @RequestMapping(value = ApiConstant.DEFAULT_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = GetUselessReissueRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<GetUselessReissueRes> getUselessReissue(
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "client_id", required = true) String clientID,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
            @RequestHeader(name = "bankCode", required = true) String bankCode,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            HttpServletResponse httpServletResponse) {

        HeaderInfoRes headerInfo = new HeaderInfoRes();
        // クライアントID
        headerInfo.setClientId(clientID);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // BFFアクセストークン
        headerInfo.setToken(accessToken);
        // リモートApi通信
        RemoteApiServerResponse<GetUselessReissueRes> res =
                uselessReissueService.getUselessReissue(headerInfo);
        // レスポンスへ変換
        ResponseEntity<GetUselessReissueRes> responseEntity =
                new RemoteApiServerResponseConverter<GetUselessReissueRes>().toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }


    /**
     * 利用不能によるカード再発行申込を受け付ける。
     * <p>
     * POST /api/v1/uselessreissue
     * </p>
     * @param accessToken BFFアクセストークン
     * @param clientID クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーティング情報
     * @param bankCode 銀行コード 
     * @param deviceID デバイスID
     * @param updUselessReissueReq 利用不能によるカード再発行申込情報
     * @param httpServletResponse HTTPレスポンス
     * @return 利用不能によるカード再発行申込結果情報
     */
    @ApiOperation(value = "利用不能によるカード再発行申込を受け付ける", notes = "利用不能によるカード再発行申込を受け付ける")
    @RequestMapping(value = ApiConstant.DEFAULT_PATH, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = BaseResponse.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<UpdUselessReissueRes> postGetPassbookCashcardSuspension(
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "client_id", required = true) String clientID,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
            @RequestHeader(name = "bankCode", required = true) String bankCode,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestBody(required = true) UpdUselessReissueReq updUselessReissueReq,
            HttpServletResponse httpServletResponse) {

        // 入力チェック
        validateService.validate(updUselessReissueReq);

        HeaderInfoRes headerInfo = new HeaderInfoRes();
        // クライアントID
        headerInfo.setClientId(clientID);
        // 取引ID
        headerInfo.setTransactionID(transactionID);
        // 経路選択情報
        headerInfo.setRoutingInfo(routingInfo);
        // 金融機関コード
        headerInfo.setBankCode(bankCode);
        // 端末ID
        headerInfo.setDeviceID(deviceID);
        // BFFアクセストークン
        headerInfo.setToken(accessToken);
        // リモートApi通信
        RemoteApiServerResponse<UpdUselessReissueRes> res =
                uselessReissueService.postUselessReissue(headerInfo, updUselessReissueReq);
        // レスポンスへ変換
        ResponseEntity<UpdUselessReissueRes> responseEntity =
                new RemoteApiServerResponseConverter<UpdUselessReissueRes>().toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }
}
