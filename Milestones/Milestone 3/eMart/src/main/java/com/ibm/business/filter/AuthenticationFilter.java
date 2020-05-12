package com.ibm.business.filter;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.ibm.business.api.response.Information;
import com.ibm.business.constant.ApiConstant;
import com.ibm.business.constant.EnumAppStatus;
import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.message.Message;
import com.ibm.business.message.MessageConst;
import com.ibm.business.message.MessageProperties;
import com.ibm.business.message.impl.CommonMessageProperties;
import com.ibm.business.service.AuthenticationService;
import com.ibm.business.util.RequestCorrelation;

/**
 * 認証フィルター
 *
 */
public class AuthenticationFilter extends BaseFilter {

    private static final Logger logger = LogManager.getLogger(AuthenticationFilter.class);

    @Value("${pbk.app.appStoreRedirectUrl}")
    String appStoreRedirectUrl;

    @Value("${pbk.app.googlePlayRedirectUrl}")
    String googlePlayRedirectUrl;

    public AuthenticationFilter(AuthenticationService authenticationService,
            MessageProperties messageProperties, boolean isSwaggerEnabled) {
        super(messageProperties);
        this.authenticationService = authenticationService;
        this.isSwaggerEnabled = isSwaggerEnabled;
    }

    private boolean isSwaggerEnabled;
    private AuthenticationService authenticationService;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String currentCorrId = UUID.randomUUID().toString();
        RequestCorrelation.setCorrelationId(currentCorrId);
        MDC.put("correlationId", currentCorrId);

        super.doFilterInternal(request, response, filterChain);

        // アプリシークレットをチェックする
        if (!checkAppSecret(request, response, filterChain)) {
            return;
        }

        // BFFトークンをチェックする
        if (!checkBffToken(request, response, filterChain)) {
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if (isSwaggerEnabled && (request.getRequestURI()
                .startsWith(request.getContextPath() + SwaggerConstant.HTML_PATH)
                || request.getRequestURI()
                        .startsWith(request.getContextPath() + SwaggerConstant.DOC_PATH)
                || request.getRequestURI()
                        .startsWith(request.getContextPath() + SwaggerConstant.WEB_JARS_PATH)
                || request.getRequestURI().startsWith(
                        request.getContextPath() + SwaggerConstant.SWAGGER_RESOURCES_PATH)
                || request.getRequestURI()
                        .startsWith(request.getContextPath() + SwaggerConstant.CSRF)
                || request.getRequestURI()
                        .startsWith(request.getContextPath() + SwaggerConstant.ERROR)
                || request.getRequestURI().equals(request.getContextPath() + "/"))) {
            return true;
        }
        return false;
    }

    /**
     * アプリシークレットを処理
     * @param request リクエスト
     * @param response　レスポンス
     * @param filterChain フィルターチェーン
     * @return エラーなしの場合はtrue
     * @throws IOException IOエラー
     */
    private boolean checkAppSecret(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws IOException {

        // アプリシークレット
        String appSecret = request.getHeader("appSecret");
        EnumAppStatus appStatus = authenticationService.isValidateAppSecret(appSecret);
        if(appStatus == EnumAppStatus.ACCEPTABLE) {
            return true;
        }
        Message message = null;
        if (appStatus == null) {
            message = CommonMessageProperties.loadMessage(MessageConst.E000000001001);
        } else {
            message = CommonMessageProperties.loadMessage(MessageConst.E000000001002);
        }
        Information information =
                new Information(appStoreRedirectUrl, googlePlayRedirectUrl);
        sendAppSecretError(response, appSecret, message, information);
        return false;
    }

    /**
     * BFFトークンを処理
     * @param request リクエスト
     * @param response　レスポンス
     * @param filterChain フィルターチェーン
     * @return エラーなしの場合はtrue
     * @throws IOException IOエラー
     */
    private boolean checkBffToken(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws IOException {
        // BFFトークン
        if (!request.getRequestURI().startsWith(request.getContextPath()
                + ApiConstant.DIGITAL_BASE_PATH + ApiConstant.CONTACT_CHANGE_PATH)) {
            String authHeader = request.getHeader("Authorization");
            if (StringUtils.isEmpty(authHeader)) {
                sendTokenError(response);
                return false;
            } else {
                if (!authenticationService.isValidateAccessToken(authHeader)) {
                    sendTokenError(response);
                    return false;
                }
            }
        }
        return true;
    }
}
