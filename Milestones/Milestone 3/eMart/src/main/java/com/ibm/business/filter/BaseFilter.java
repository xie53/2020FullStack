package com.ibm.business.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.api.response.Information;
import com.ibm.business.api.response.UpgradeRequiredErrorResponse;
import com.ibm.business.message.Message;
import com.ibm.business.message.MessageConst;
import com.ibm.business.message.MessageProperties;
import com.ibm.business.message.impl.CommonMessageProperties;

/**
 * ベースフィルター
 *
 */
public class BaseFilter extends OncePerRequestFilter {

    protected MessageProperties messageProperties;
    private ObjectMapper objectMapper = new ObjectMapper();

    public BaseFilter() {

    }

    public BaseFilter(MessageProperties messageProperties) {
        this.messageProperties = messageProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

    }

    protected void sendTokenError(HttpServletResponse response)
            throws JsonProcessingException, IOException {
        Message message = CommonMessageProperties.loadMessage(MessageConst.E000000001000);
        ErrorResponse<Object> res =
                new ErrorResponse<Object>(message.getMessageID(), message.getMessage(), true);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE + "; charset=utf8");
        response.getWriter().write(objectMapper.writeValueAsString(res));
    }

    /**
     * AppSecretエラーの場合の処理
     * @param response レスポンス
     * @param appSecret Appシクレート
     * @param message メッセージ
     * @param information インフォメーション
     * @throws JsonProcessingException JSON処理エラー
     * @throws IOException IOエラー
     */
    protected void sendAppSecretError(HttpServletResponse response, String appSecret, Message message,
            Information information) throws JsonProcessingException, IOException {
        UpgradeRequiredErrorResponse res =
                new UpgradeRequiredErrorResponse(message.getMessageID(), message.getMessage());
        res.setInformation(information);
        response.setStatus(message.getHttpStatusCode());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE + "; charset=utf8");
        response.getWriter().write(objectMapper.writeValueAsString(res));
    }
}
