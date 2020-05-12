package com.ibm.business.exception;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * BFFDigital
 * 
 * @author ShiYan May 11, 2019 © Copyright IBM Corp. 2019 All rights reserved.
 **/

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import com.ibm.business.api.response.ErrorResponse;
import com.ibm.business.message.Message;
import com.ibm.business.message.MessageConst;
import com.ibm.business.message.MessageProperties;
import com.ibm.business.util.HttpHeaderUtil;

/**
 * <ol>
 * <li>バックエンドAPI通信。401エラーの場合：401 Unauthorizedを返し</li>
 * <li>バックエンドAPI通信。他の40xエラーの場合：500 Interal Server Errorを返し</li>
 * <li>バックエンドAPI通信。他の50xエラーの場合：500 Interal Server Errorを返し</li>
 * <li>内部処理。ApplicationExceptionエラーの場合：500 Interal Server Errorを返し、メッセージボディ{"status":"NG", "code": "Exxxxx", "msg": "xxxxx"}を返し</li>
 * <li>内部処理。SystemExceptionエラーの場合：500 Interal Server Errorを返し</li>
 * <li>内部処理。Throwableエラーの場合：500 Interal Server Errorを返し</li>
 * </ol>
 * @author HeYe
 *
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    /** HTTPヘッダーマッピング */
    @Autowired
    HttpHeaderUtil httpHeaderUtil;

    /** メッセージプロパティ */
    @Autowired
    MessageProperties messageProperties;

    // ========================================================================
    // 業務エラー処理
    // ========================================================================
    /**
     * 業務エラーを処理
     * @param response Httpレスポンス
     * @param ex 業務エラー
     * @return Httpレスポンス・エンティティ
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleApplicationException(HttpServletResponse response,
            final ApplicationException ex) {
        logger.error("アプリケーションエラーが発生。", ex);
        // メッセージID
        String messageId = ex.getMessageId();
        // メッセージパラメータ
        Object[] arguments = ex.getArguments();
        // ヘッダーマップ
        Map<String, String> headerMap = ex.getHeaderMap();
        // ボディ部
        @SuppressWarnings("unused")
        Object body = ex.getBody();
        // Httpヘッダーを作成
        HttpHeaders headers = createHttpHeaders(headerMap);
        // フォーマットされたエラーメッセージ
        Message errorMessage = messageProperties.getMessage(messageId, arguments);
        // クライアントに定義されたHttpStatusCode
        int httpStatusCode = errorMessage.getHttpStatusCode();
        // ログレベル
        Level level = errorMessage.getLevel().getLog4JLevel();
        // ログ出力
        logger.log(level, errorMessage.getMessageID() + ":" + errorMessage.getMessage(), ex);
        // エラーレスポンスを作成
        ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(errorMessage, body);
        return ResponseEntity.status(httpStatusCode).headers(headers).body(errorResponse);
    }

    /**
     * 業務エラーを処理
     * @param response Httpレスポンス
     * @param ex 業務エラー
     * @return Httpレスポンス・エンティティ
     */
    @ExceptionHandler(RemoteApiApplicationException.class)
    public ResponseEntity<?> handleRemoteApiApplicationException(HttpServletResponse response,
            final RemoteApiApplicationException ex) {
        logger.error("BackendApiにてアプリケーションエラーが発生。", ex);
        // メッセージID
        String messageId = ex.getErrorCode();
        // メッセージ
        String errorMessage = ex.getErrorMessage();
        // 再入力可能フラグ
        Boolean reEnterableFlag = ex.getReEnterableFlag();
        // ヘッダーマップ
        Map<String, String> headerMap = ex.getHeaderMap();
        // ボディ部
        @SuppressWarnings("unused")
        Object body = ex.getBody();
        // Httpヘッダーを作成
        HttpHeaders headers = createHttpHeaders(headerMap);
        // エラーレスポンスを作成
        ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(messageId, errorMessage, reEnterableFlag, body);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errorResponse);
    }

    // ========================================================================
    // RestTemplate通信エラー処理
    // ========================================================================
    /**
     * Apiリモートサービス接続エラーを処理。
     * 
     * @param response Httpレスポンス
     * @param ex インバウンドパラメータが存在しないエラー
     * @return Httpレスポンス・エンティティ
     */
    public ResponseEntity<?> handleResourceAccessException(HttpServletResponse response,
            final ResourceAccessException ex) {
        logger.info("リモートサービス接続エラーが発生。", ex);
        Message msg = messageProperties.getMessage(MessageConst.E000000004001);
        // メッセージコード（リモートサービスとの通信に失敗しました。）
        return createErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, msg.getMessageID(), msg.getMessage(), true);
    }

    /**
     * 汎用リモートサービスエラーを処理。
     * <p>
     * 4xxクライアントエラーを処理する。(HttpStatus: 400,402〜428)
     * 5xxサーバエラーを処理する。(HttpStatus: 500)
     * </p>
     * @param response Httpレスポンス
     * @param ex 汎用リモートサービスエラー
     * @return 500 (INTERNAL SERVER ERROR)
     */
    public ResponseEntity<?> handleRestClientResponseException(HttpServletResponse response,
            final RestClientResponseException ex) {
        if (ex instanceof HttpClientErrorException.Unauthorized) {
            logger.info("ユーザ未認証：再度ログオンを依頼する。");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        logger.error("リモートサービスが想定外処理エラーが発生。", ex);
        Message msg = messageProperties.getMessage(MessageConst.E000000004004);
        // リモートサービスが処理エラーが発生しました。
        return createErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, msg.getMessageID(), msg.getMessage(), false);
    }

    // ========================================================================
    // インバウンドパラメータ不備エラー処理
    // ========================================================================
    /**
     * Apiインバウンドパラメータが存在しないエラーを処理。
     * @param response Httpレスポンス
     * @param ex インバウンドパラメータが存在しないエラー
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(
            HttpServletResponse response, final MissingServletRequestParameterException ex) {
        logger.info("インバウンドパラメータ不備エラーが発生。", ex);
        Message msg = messageProperties.getMessage(MessageConst.E000000002000, ex.getParameterName());
        // {0}は入力必須項目です。
        return createErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, msg.getMessageID(), msg.getMessage(), false);
    }

    /**
     * Apiインバウンドヘッダーが存在しないエラーを処理。
     * @param response Httpレスポンス
     * @param ex インバウンドヘッダーが存在しないエラー
     * @return
     */
    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<?> handleMissingRequestHeaderException(HttpServletResponse response,
            final MissingRequestHeaderException ex) {
        logger.info("インバウンドヘッダー不備エラーが発生。", ex);
        Message msg = messageProperties.getMessage(MessageConst.E000000002004, ex.getHeaderName());
        // ヘッダー部に{0}が必須項目です。
        return createErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, msg.getMessageID(), msg.getMessage(), false);
    }
    // ConstraintViolationException
    
    /**
     * Api入力チェックエラーを処理。
     * @param response Httpレスポンス
     * @param ex 入力チェックエラー
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(HttpServletResponse response,
            final ConstraintViolationException ex) {
        logger.info("入力チェックエラー。", ex);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        int size = constraintViolations.size();
        int index = 0;
        Iterator<ConstraintViolation<?>> iter = constraintViolations.iterator();
        StringBuffer sbf = new StringBuffer();
        while(iter.hasNext()) {
            ConstraintViolation<?> constraint = iter.next();
            String message = constraint.getMessage();
            sbf.append(message);
            index++;
            if(index<size) {
                sbf.append("\n");
            }
        }
        // ヘッダー部に{0}が必須項目です。
        return createErrorResp(HttpStatus.BAD_REQUEST, MessageConst.E000000002900, sbf.toString(), false);
    }
    // ========================================================================
    // システムエラー処理
    // ========================================================================
    /**
     * 未ログオン・トークン無効エラーを処理
     * @param response Httpレスポンス
     * @param ex 未ログオン・トークン無効エラー
     * @return Httpレスポンス・エンティティ
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(HttpServletResponse response,
            final UnauthorizedException ex) {
        logger.info("ユーザ未認証。アクセストークンが未渡しもしくは失効しました。再度ログオンを依頼する。");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    /**
     * システムエラー処理
     * @param response Httpレスポンス
     * @param ex システムエラー
     * @return Httpレスポンス・エンティティ
     */
    @ExceptionHandler(SystemException.class)
    public ResponseEntity<?> handleSystemException(HttpServletResponse response,
            final SystemException ex) {
        logger.error("システムエラーが発生。", ex);
        // メッセージID
        String messageId = ex.getMessageId();
        // メッセージパラメータ
        Object[] arguments = ex.getArguments();
        // ヘッダーマップ
        Map<String, String> headerMap = ex.getHeaderMap();
        // Httpヘッダーを作成
        HttpHeaders headers = createHttpHeaders(headerMap);
        // フォーマットされたエラーメッセージ
        Message errorMessage = messageProperties.getMessage(messageId, arguments);
        // クライアントに定義されたHttpStatusCode
        int httpStatusCode = errorMessage.getHttpStatusCode();
        // ログレベル
        Level level = errorMessage.getLevel().getLog4JLevel();
        // ログ出力
        logger.log(level, errorMessage.getMessageID() + ":" + errorMessage.getMessage(), ex);
        // エラーレスポンスを作成
        ErrorResponse<Object> errorResponse = new ErrorResponse<Object>(errorMessage);
        return ResponseEntity.status(httpStatusCode).headers(headers).body(errorResponse);
    }

    /**
     * 汎用エラー処理
     * @param response Httpレスポンス
     * @param ex 汎用エラー
     * @return Httpレスポンス・エンティティ
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<?> handleException(HttpServletResponse response, final Throwable ex) {
        logger.error("想定外システムエラーが発生。", ex);
        Message msg = messageProperties.getMessage(MessageConst.E000000000000);
        // システムエラーが発生しました。只今対応しております、しばらくお待ちください。
        return createErrorResp(HttpStatus.INTERNAL_SERVER_ERROR, msg.getMessageID(), msg.getMessage(), false);
    }

    private HttpHeaders createHttpHeaders(Map<String, String> headerMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);// application/json
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);// application/json
        List<Charset> acceptCharsets = Collections.singletonList(StandardCharsets.UTF_8); // Accept-Charset:UTF-8
        headers.setAcceptCharset(acceptCharsets);
        httpHeaderUtil.setHttpHeaders(headers, headerMap);
        return headers;
    }
    
    
    private ResponseEntity<?> createErrorResp(HttpStatus httpStatus, String messageId, String message, Boolean reEnterableFlag) {
        // HTTPヘッダーを作成
        HttpHeaders headers = createHttpHeaders(null);
        // HTTPレスポンスを作成
        return ResponseEntity
                .status(httpStatus) //
                .headers(headers) //
                .body(new ErrorResponse<Object>(messageId, message, reEnterableFlag));
    }
}
