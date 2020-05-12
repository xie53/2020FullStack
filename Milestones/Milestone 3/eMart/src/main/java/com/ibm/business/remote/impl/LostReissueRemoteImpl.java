package com.ibm.business.remote.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.business.bean.req.UpdLostReissueReq;
import com.ibm.business.bean.res.HeaderInfoRes;
import com.ibm.business.bean.res.UpdLostReissueRes;
import com.ibm.business.constant.RemoteConstant;
import com.ibm.business.remote.LostReissueRemote;

/**
 * 喪失による再発行の申込を受け付ける
 *
 */
@Service("lostReissueRemote")
public class LostReissueRemoteImpl extends BaseRemoteImpl implements LostReissueRemote {
    /** ロガー */
    private static final Logger logger = LogManager.getLogger(LostReissueRemoteImpl.class);

    /**
     * 喪失による再発行の申込を受け付ける
     * 
     * @param header ヘッダー
     * @param request 喪失による再発行の申込情報
     * @return レスポンス・エンティティ
     */
    @Override
    public ResponseEntity<UpdLostReissueRes> postLostReissue(HeaderInfoRes headerInfo,
            UpdLostReissueReq request) {
        logger.info("### Remote API call start: [GET] " + remoteBaseUrl
                + RemoteConstant.LOST_REISSUE_PATH);

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(remoteBaseUrl + RemoteConstant.LOST_REISSUE_PATH);

        HttpEntity<UpdLostReissueReq> entity =
                new HttpEntity<UpdLostReissueReq>(request, getAddressChangeHeaderMap(headerInfo));
        logger.info("API input -> " + entity);

        ResponseEntity<UpdLostReissueRes> responseEntity = execute(builder.build().encode().toUri(),
                HttpMethod.POST, entity, UpdLostReissueRes.class);

        logger.info("API output <- " + responseEntity);
        logger.info("### Remote API call end: [GET] " + remoteBaseUrl
                + RemoteConstant.LOST_REISSUE_PATH);
        return responseEntity;
    }
}
