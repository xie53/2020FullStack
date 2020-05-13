package com.ibm.business.seller.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.seller.bean.req.BuyerInfoRes;
import com.ibm.business.seller.constant.ApiConstant;
import com.ibm.business.seller.db.entity.Buyer;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.EmptyResponse;
import com.ibm.business.seller.response.ErrorResponse;
import com.ibm.business.seller.service.BuyerService;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = ApiConstant.BUYER_INFO_PATH)
public class BuyerController extends BaseController {
	private static final Logger logger = LogManager.getLogger(BuyerController.class);

	@Resource(name = "buyerService")
	private BuyerService buyerService;

    /**
     * Buyer Login Api
     * @param userId
     * @param password
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/buyerLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buyer Login Api", notes = "Buyer Login Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<BuyerInfoRes> getBuyerLoginInfo(
			@RequestParam(value="userName",required = true) @NonNull String userName,
			@RequestParam(value="password",required = true) @NonNull String password,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<BuyerInfoRes> res = buyerService.buyerLogin(userName, password);
    	
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }

    /**
     * Buyer Signup Api
     * @param userId
     * @param password
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/buyerSignup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buyer Signup Api", notes = "Buyer Signup Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<BuyerInfoRes> postBuyerRegisterInfo(
			@RequestBody(required = true) @NonNull BuyerInfoRes buyerInfoRes,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<BuyerInfoRes> res = buyerService.buyerRegister(buyerInfoRes);
    			
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }
}

