package com.ibm.business.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

/**
 * <pre>
 * デバッグのためリモートAPI通信の受送信電文をログに出力
 * </pre>
 *
 */
public class LogClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    /** ログ */
    private static final Logger logger =
            LogManager.getLogger(LogClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
            ClientHttpRequestExecution execution) throws IOException {
        // RemoteAPI実行時間を測るため
        long execStartTime = System.currentTimeMillis();
        ClientHttpResponse response = null;
        Exception e = null;
        try {
            response = execution.execute(request, body);
            return response;
        } catch (IOException ex) {
            // ネットワーク通信エラー
            e = ex;
            throw ex;
        } catch (RuntimeException ex) {
            // その他エラー
            e = ex;
            throw ex;
        } finally {
            // 実行後のログを出す
            long execDuration = System.currentTimeMillis() - execStartTime;
            postLogRequest(request, body, response, e, execDuration);
        }
    }

    /**
     * ログ出力
     * @param request リクエスト
     * @param body Postの場合ボディ部
     * @param response レスポンス
     * @param e エラー
     * @param execTime 実行時間(ms)
     * @throws IOException IOエラー
     */
    private void postLogRequest(HttpRequest request, byte[] body, ClientHttpResponse response,
            Exception e, long execTime) throws IOException {
        if (logger.isDebugEnabled()) {
            // Request
            String uri = request.getURI().toString();
            String method = request.getMethodValue();
            HttpHeaders requestHeaders = request.getHeaders();
            String requestHeadersStr = "なし";
            if (requestHeaders != null) {
                requestHeadersStr = requestHeaders.toString();
            }
            String bodyStr = "なし";
            if (body != null && body.length > 0) {
                bodyStr = new String(body, StandardCharsets.UTF_8);
            }
            String requestMsg = "[API送信]" + method + ":" + uri + ". Header:" + requestHeadersStr
                    + ". Body:" + bodyStr;
            // エラー処理
            if (e != null) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                requestMsg = requestMsg + "|Receive Error:" + sw.toString();
                logger.trace(requestMsg + "|実行時間:" + execTime + "ms");
            } else if (response != null) {
                // Response
                int statusCode = -1;
                String statusText = null;
                String responseHeadersStr = "なし";
                String responseBody = "なし";
                String responseMsg = "なし";
                if (response != null) {
                    statusCode = response.getRawStatusCode();
                    statusText = response.getStatusText();
                    if (response.getHeaders() != null) {
                        responseHeadersStr = response.getHeaders().toString();
                    }
                    responseBody =
                            StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8);
                    responseMsg = "Receive:" + statusCode + " " + statusText + ". Headers:"
                            + responseHeadersStr + ". Body:" + responseBody;
                }
                logger.debug(requestMsg + "|" + responseMsg + "|実行時間:" + execTime + "ms");
            } else {
                logger.debug(requestMsg + "|レスポンスなし|実行時間:" + execTime + "ms");
            }
        }
    }
}
