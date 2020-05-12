package com.ibm.business.remote.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.bean.req.UpdUselessReissueReq;
import com.ibm.business.bean.res.GetUselessReissueRes;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdUselessReissueRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.remote.UselessReissueRemote;

/**
 * 利用不能カード再発行用登録内容照会・更新
 *
 */
@Service("uselessReissueRemote")
public class UselessReissueRemoteImpl extends BaseRemoteImpl implements UselessReissueRemote {
    /** ロガー */
    private static final Logger logger = LogManager.getLogger(UselessReissueRemoteImpl.class);

    /**
     * 口座情報に紐づく再発行可能物件と連絡先（送付先住所・電話番号）を照会する。
     * <p>
     * 再発行可能物件がない場合は、エラーを応答する。
     * </p>
     * 
     * @param header ヘッダー
     * @return レスポンス・エンティティ
     */
    @Override
    public ResponseEntity<GetUselessReissueRes> getUselessReissue(HeaderInfoRes headerInfo) {
        logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);

        HttpEntity<String> entity = new HttpEntity<>(null, getAddressChangeHeaderMap(headerInfo));
        logger.info("API input -> " + entity);

        ResponseEntity<GetUselessReissueRes> responseEntity =
                execute(builder.build().encode().toUri(), HttpMethod.GET, entity,
                        GetUselessReissueRes.class);

        logger.info("API output <- " + responseEntity);
        logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);
        return responseEntity;
    }

    /**
     * 利用不能によるカード再発行申込を受け付ける。
     * 
     * @param header ヘッダー
     * @param request 利用不能によるカード再発行申込情報
     * @return レスポンス・エンティティ
     */
    @Override
    public ResponseEntity<UpdUselessReissueRes> postUselessReissue(HeaderInfoRes headerInfo,
            UpdUselessReissueReq request) {
        logger.info("### Remote API call start: [GET] " + remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);

        HttpEntity<UpdUselessReissueReq> entity = new HttpEntity<UpdUselessReissueReq>(request,
                getAddressChangeHeaderMap(headerInfo));
        logger.info("API input -> " + entity);

        ResponseEntity<UpdUselessReissueRes> responseEntity =
                execute(builder.build().encode().toUri(), HttpMethod.POST, entity,
                        UpdUselessReissueRes.class);

        logger.info("API output <- " + responseEntity);
        logger.info("### Remote API call end: [GET] " + remoteBaseUrl + RemoteConstant.USELESS_REISSUE_PATH);
        return responseEntity;
    }
}
