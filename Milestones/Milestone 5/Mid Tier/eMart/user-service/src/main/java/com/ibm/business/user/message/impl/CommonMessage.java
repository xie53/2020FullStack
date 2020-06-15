package com.ibm.business.user.message.impl;

import java.io.Serializable;
import com.ibm.business.user.message.MessageLevel;
import com.ibm.business.user.message.Message;

/**
 * メッセージ
 *
 */
public class CommonMessage implements Cloneable, Serializable, Message {

    private static final long serialVersionUID = 3843925410772607903L;
    /** ログレベル */
    private MessageLevel level;
    /** HTTPStatusCode */
    private int httpStatusCode;
    /** メッセージID */
    private String messageID;
    /** メッセージ */
    private String message;

    /**
     * コンストラクター
     */
    public CommonMessage() {

    }

    /**
     * コンストラクター
     * @param level ログレベル
     * @param code HTTPStatusCode
     * @param messageID メッセージID
     * @param message メッセージ
     */
    public CommonMessage(MessageLevel level, int code, String messageID, String message) {
        this.level = level;
        this.messageID = messageID;
        this.httpStatusCode = code;
        this.message = message;
    }

    @Override
    public MessageLevel getLevel() {
        return level;
    }

    public void setLevel(MessageLevel level) {
        this.level = level;
    }

    @Override
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int code) {
        this.httpStatusCode = code;
    }

    @Override
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonMessage [level=" + level + ", httpStatusCode=" + httpStatusCode
                + ", messageID=" + messageID + ", message=" + message + "]";
    }
}
