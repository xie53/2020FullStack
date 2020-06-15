package com.ibm.business.buyer.controller;

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

import com.ibm.business.buyer.bean.req.BuyerInfoRes;
import com.ibm.business.buyer.bean.req.ItemsInfoListRes;
import com.ibm.business.buyer.constant.ApiConstant;
import com.ibm.business.buyer.db.entity.Buyer;
import com.ibm.business.buyer.response.BaseResponse;
import com.ibm.business.buyer.response.EmptyResponse;
import com.ibm.business.buyer.response.ErrorResponse;
import com.ibm.business.buyer.service.BuyerService;

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
     * Search Items Api
     * @param itemName
     * @param category
     * @param subCategory
     * @param startPrice
     * @param endPrice
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/searchItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Items Api", notes = "Search Items Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<ItemsInfoListRes> searchItemsInfo(
			@RequestParam(value="itemName",required = false) String itemName,
			@RequestParam(value="category",required = false) String category,
			@RequestParam(value="subCategory",required = false) String subCategory,
			@RequestParam(value="startPrice",required = false) Double startPrice,
			@RequestParam(value="endPrice",required = false) Double endPrice,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<ItemsInfoListRes> res = buyerService.searchItemsInfo(itemName, category, subCategory, startPrice, endPrice);
    	
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }

    /**
     * Get Item Api
     * @param itemName
     * @param category
     * @param subCategory
     * @param startPrice
     * @param endPrice
     * @param httpServletResponse HTTP
     * @return　HTTP
     */
    @RequestMapping(value = "/getItem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get Item Api", notes = "Get Item Api")
    @ApiImplicitParams(value = {})
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 500, message = "ERROR", response = ErrorResponse.class), 
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class)})
    public BaseResponse<ItemsInfoListRes> getItemById(
			@RequestParam(value="id",required = true) String id,
            HttpServletResponse httpServletResponse) {

    	BaseResponse<ItemsInfoListRes> res = buyerService.getItemById(id);
    	
		setResponseStatus(res, httpServletResponse);
		logger.info("### api result: " + res.getResult());
		return res;
    }

}

