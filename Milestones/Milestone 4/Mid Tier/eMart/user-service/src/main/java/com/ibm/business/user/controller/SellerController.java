package com.ibm.business.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.business.user.bean.req.BuyerInfoRes;
import com.ibm.business.user.bean.req.SellerInfoRes;
import com.ibm.business.user.db.entity.Buyer;
import com.ibm.business.user.response.BaseResponse;
import com.ibm.business.user.response.EmptyResponse;
import com.ibm.business.user.response.ErrorResponse;
import com.ibm.business.user.service.BuyerService;
import com.ibm.business.user.service.SellerService;
import com.ibm.business.user.constant.ApiConstant;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = ApiConstant.SELLER_INFO_PATH)
public class SellerController extends BaseController {
	private static final Logger logger = LogManager.getLogger(SellerController.class);

	@Resource(name = "sellerService")
	private SellerService sellerService;

    /**
     * Seller Login Api
     * @param userId
     * @param password
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/sellerLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Seller Login Api", notes = "Seller Login Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<SellerInfoRes> getBuyerLoginInfo(
			@RequestParam(value="userName",required = true) String userName,
			@RequestParam(value="password",required = true) String password,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<SellerInfoRes> res = sellerService.sellerLogin(userName, password);
    	
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }

    /**
     * Seller Signup Api
     * @param userId
     * @param password
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/sellerSignup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Seller Signup Api", notes = "Seller Signup Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<SellerInfoRes> postBuyerRegisterInfo(
			@RequestBody(required = true) SellerInfoRes sellerInfoRes,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<SellerInfoRes> res = sellerService.sellerRegister(sellerInfoRes);
    			
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }
}

