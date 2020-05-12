package com.ibm.business.exception;

import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 * 業務エラークラス
 * 
 * @author HeYe
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 5499421843434232215L;

    /** 設定するHttpStatus */
    private HttpStatus httpStatus = null;

    /** ヘッダーマップ */
    private Map<String, String> headerMap;

    /** メッセージコード */
    private String messageId;

    /** メッセージパラメータ */
    private Object[] arguments;

    /** メッセージボディ */
    private Object body = null;

    /**
     * コンストラクター
     * @param messageId メッセージID
     */
    public ApplicationException(String messageId) {
        super(messageId);
        this.messageId = messageId;
        this.arguments = null;
        this.headerMap = null;
        this.body = null;
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param e エラー
     */
    public ApplicationException(String messageId, Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = null;
        this.headerMap = null;
        this.body = null;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     */
    public ApplicationException(String messageId, Object[] arguments) {
        super(messageId);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = null;
        this.body = null;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     * @param e エラー
     */
    public ApplicationException(String messageId, Object[] arguments, Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = null;
        this.body = null;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     * @param headerMap ヘッダーマップ
     */
    public ApplicationException(String messageId, Object[] arguments,
            Map<String, String> headerMap) {
        super(messageId);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
        this.body = null;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     * @param headerMap ヘッダーマップ
     * @param e エラー
     */
    public ApplicationException(String messageId, Object[] arguments, Map<String, String> headerMap,
            Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
        this.body = null;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     * @param headerMap ヘッダーマップ
     * @param body ボディ
     */
    public ApplicationException(String messageId, Object[] arguments, Map<String, String> headerMap,
            Object body) {
        super(messageId);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
        this.body = body;
    }

    /**
     * コンストラクター
     * 
     * @param messageId メッセージID
     * @param arguments メッセージ・パラメータ
     * @param headerMap ヘッダーマップ
     * @param body ボディ
     * @param e エラー
     */
    public ApplicationException(String messageId, Object[] arguments, Map<String, String> headerMap,
            Object body, Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
        this.body = body;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public String getMessageId() {
        return messageId;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object getBody() {
        return body;
    }


}
