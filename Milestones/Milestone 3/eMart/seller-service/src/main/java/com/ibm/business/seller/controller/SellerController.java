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
import com.ibm.business.seller.bean.req.ItemsInfoRes;
import com.ibm.business.seller.constant.ApiConstant;
import com.ibm.business.seller.db.entity.Buyer;
import com.ibm.business.seller.response.BaseResponse;
import com.ibm.business.seller.response.EmptyResponse;
import com.ibm.business.seller.response.ErrorResponse;
import com.ibm.business.seller.service.SellerService;

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
     * View Item Stock Api
     * @param itemName
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/viewStock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "View Item Stock Api", notes = "View Item Stock Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<ItemsInfoRes> getViewStock(
			@RequestParam(value="itemName",required = true) @NonNull String itemName,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<ItemsInfoRes> res = sellerService.getViewStock(itemName);
    	
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }

    /**
     * Seller Add Items Api
     * @param buyerInfoRes
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/addItems", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Seller Add Items Api", notes = "Seller Add Items Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<ItemsInfoRes> postAddItems(
			@RequestBody(required = true) @NonNull ItemsInfoRes itemsInfoRes,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<ItemsInfoRes> res = sellerService.postAddItems(itemsInfoRes);
    			
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }
}

