package com.ibm.business.exception;

import java.util.HashMap;
import java.util.Map;

import com.ibm.business.message.MessageConst;

/**
 * システムエラークラス
 * 
 * @author HeYe
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -131368829794966095L;

    /** ヘッダーマップ */
    private Map<String, String> headerMap = new HashMap<String, String>();

    /** メッセージコード */
    private String messageId;

    /** メッセージパラメータ */
    private Object[] arguments;

    /**
     * コンストラクター
     */
    public SystemException() {
        this(MessageConst.E000000000000);
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     */
    public SystemException(String messageId) {
        this.messageId = messageId;
        this.arguments = null;
        this.headerMap = null;
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param arguments パラメータ
     */
    public SystemException(String messageId, Object... arguments) {
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = null;
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param arguments パラメータ
     * @param headerMap ヘッダーマップ
     */
    public SystemException(String messageId, Object[] arguments, Map<String, String> headerMap) {
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param e エラー
     */
    public SystemException(String messageId, Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = null;
    }

    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param arguments パラメータ
     * @param e エラー
     */
    public SystemException(String messageId, Object[] arguments, Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = arguments;
    }


    /**
     * コンストラクター
     * @param messageId メッセージID
     * @param arguments パラメータ
     * @param headerMap ヘッダーマップ
     * @param e エラー
     */
    public SystemException(String messageId, Object[] arguments, Map<String, String> headerMap,
            Throwable e) {
        super(e);
        this.messageId = messageId;
        this.arguments = arguments;
        this.headerMap = headerMap;
    }

    /**
     * コンストラクター
     * 
     * @param headerMap ヘッダーマップ
     */
    public SystemException(Map<String, String> headerMap) {
        this();
        this.headerMap = headerMap;
    }

    public String getMessageId() {
        return messageId;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

}
