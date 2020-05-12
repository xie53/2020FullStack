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

import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.bean.req.UpdLostReissueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdLostReissueRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.remote.bean.RemoteApiServerResponseConverter;
import com.ibm.business.service.LostReissueService;
import com.ibm.business.validator.ValidateService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 喪失による再発行
 *
 */
@RestController
@RequestMapping(value = ApiConstant.DIGITAL_BASE_PATH + ApiConstant.LOST_REISSUE_PATH)
public class LostReissueApi {

    /** ロガー */
    private static final Logger logger = LogManager.getLogger(LostReissueApi.class);

    @Resource(name = "lostReissueService")
    LostReissueService lostReissueService;

    /** 入力チェックサービス */
    @Autowired
    ValidateService validateService;

    /**
     * 喪失による再発行API
     * <p>
     * POST /api/v1/lostreissue
     * </p>
     * @param accessToken BFFアクセストークン
     * @param clientID クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーティング情報
     * @param bankCode 銀行コード 
     * @param deviceID デバイスID
     * @param updLostReissueReq 喪失による再発行申込情報
     * @param httpServletResponse HTTPレスポンス
     * @return 喪失による再発行申込結果情報
     */
    @ApiOperation(value = "喪失による再発行", notes = "喪失による再発行")
    @RequestMapping(value = ApiConstant.DEFAULT_PATH, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = UpdLostReissueRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<UpdLostReissueRes> postLostReissue(
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "client_id", required = true) String clientID,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
            @RequestHeader(name = "bankCode", required = true) String bankCode,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestBody(required = true) UpdLostReissueReq updLostReissueReq,
            HttpServletResponse httpServletResponse) {
        // 入力チェック
        validateService.validate(updLostReissueReq);
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
        RemoteApiServerResponse<UpdLostReissueRes> res =
                lostReissueService.postLostReissue(headerInfo, updLostReissueReq);
        // レスポンスへ変換
        ResponseEntity<UpdLostReissueRes> responseEntity =
                new RemoteApiServerResponseConverter<UpdLostReissueRes>().toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }
}
