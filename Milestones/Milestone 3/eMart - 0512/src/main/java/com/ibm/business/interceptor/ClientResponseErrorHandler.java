package com.ibm.business.interceptor;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.ibm.business.exception.UnauthorizedException;

/**
 * リモートAPIをアクセスする時、エラーハンドリング処理。
 * <p>リモートAPIが401 UNAUTHORIZEDを返す時、UnauthorizedExceptionを投げる。再度ログオンさせる</p>
 * @author HeYe
 *
 */
public class ClientResponseErrorHandler implements ResponseErrorHandler {

    private static final Logger logger = LogManager.getLogger(ClientResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            if (logger.isDebugEnabled()) {
                logger.debug("RemoteApiが401 UNAUTHORIZEDを返し、再度ログオンさせる。");
            }
            throw new UnauthorizedException();
        } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            if (logger.isErrorEnabled()) {
                logger.error("RemoteApiが" + response.getStatusCode() + "を返し、BFF/IDG不備になる。システムエラー。");
            }
        } else if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            if (logger.isErrorEnabled()) {
                logger.error("RemoteApiが" + response.getStatusCode() + "を返し、システムエラー。");
            }
        }
    }

}
