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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.bean.req.GetReissueChargeInfoReq;
import com.ibm.business.bean.res.GetReissueChargeinfoRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.remote.bean.RemoteApiServerResponse;
import com.ibm.business.remote.bean.RemoteApiServerResponseConverter;
import com.ibm.business.service.ReissueChargeInfoService;
import com.ibm.business.validator.ValidateService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 再発行手数料情報API
 *
 */
@RestController
@RequestMapping(value = ApiConstant.DIGITAL_BASE_PATH + ApiConstant.REISSUE_CHARGE_INFO_PATH)
//@Validated
public class ReissueChargeInfoApi {
    /** ロガー */
    private static final Logger logger = LogManager.getLogger(ReissueChargeInfoApi.class);

    @Resource(name = "reissueChargeInfoService")
    ReissueChargeInfoService reissueChargeInfoService;

    /** 入力チェックサービス */
    @Autowired
    ValidateService validateService;

    /**
     * 再発行手数料情報照会API
     * <p>
     * GET /api/v1/reissuechargeinfo
     * </p>
     * @param accessToken BFFアクセストークン
     * @param clientID クライアントID
     * @param transactionID トランザクションID
     * @param routingInfo ルーティング情報
     * @param bankCode 銀行コード 
     * @param deviceID デバイスID
     * @param cashcardCount カード再発行枚数
     * @param passbookCount 通帳再発行枚数
     * @param httpServletResponse HTTPレスポンス
     * @return 再発行手数料情報照会情報
     */
    @ApiOperation(value = "再発行手数料情報照会", notes = "再発行手数料情報照会")
    @RequestMapping(value = ApiConstant.DEFAULT_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.COMMON_HTTP_200_RES_DESC_MESSAGE,
                    response = GetReissueChargeinfoRes.class),
            @ApiResponse(code = 400, message = SwaggerConstant.COMMON_HTTP_400_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 401, message = SwaggerConstant.COMMON_HTTP_401_RES_DESC_MESSAGE,
                    response = ErrorResponse.class),
            @ApiResponse(code = 426, message = SwaggerConstant.COMMON_HTTP_426_RES_ERROR_DESC,
                    response = UpgradeRequiredErrorResponse.class),
            @ApiResponse(code = 500, message = SwaggerConstant.COMMON_HTTP_500_RES_DESC_MESSAGE,
                    response = ErrorResponse.class)})
    public ResponseEntity<GetReissueChargeinfoRes> getReissueChargeInfo(
            @RequestHeader(name = "Authorization", required = true) String accessToken,
            @RequestHeader(name = "client_id", required = true) String clientID,
            @RequestHeader(name = "transactionID", required = false) String transactionID,
            @RequestHeader(name = "routingInfo", required = true) String routingInfo,
            @RequestHeader(name = "bankCode", required = true) String bankCode,
            @RequestHeader(name = "deviceID", required = true) String deviceID,
            @RequestParam(name = "cashcardCount", required = false) String cashcardCount,
            @RequestParam(name = "passbookCount", required = false) String passbookCount,
            HttpServletResponse httpServletResponse) {
        // Validateチェック
        GetReissueChargeInfoReq getReissueChargeInfoReq = new GetReissueChargeInfoReq();
        // カード再発行枚数
        getReissueChargeInfoReq.setCashcardCount(cashcardCount);
        // 通帳再発行枚数
        getReissueChargeInfoReq.setPassbookCount(passbookCount);
        // 入力チェック
        validateService.validate(getReissueChargeInfoReq);

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
        RemoteApiServerResponse<GetReissueChargeinfoRes> res = reissueChargeInfoService
                .getReissueChargeInfo(headerInfo, getReissueChargeInfoReq.getCashcardCount(),
                        getReissueChargeInfoReq.getPassbookCount());
        // レスポンスへ変換
        ResponseEntity<GetReissueChargeinfoRes> responseEntity =
                new RemoteApiServerResponseConverter<GetReissueChargeinfoRes>()
                        .toResponseEntity(res);
        logger.info("### api result: " + responseEntity);
        return responseEntity;
    }
}
