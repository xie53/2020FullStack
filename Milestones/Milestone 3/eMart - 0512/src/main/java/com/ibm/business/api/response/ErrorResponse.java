package com.ibm.business.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibm.business.message.Message;

public class ErrorResponse<T> {

    public ErrorResponse() {
        //this.status = ApiConstant.STATUS_NG;
    }

    /**
     * コンストラクタ
     * @param msg メッセージ
     */
    public ErrorResponse(Message msg) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = msg.getMessageID();
        this.errorMessage = msg.getMessage();
        this.reEnterableFlag = true;
    }

    /**
     * コンストラクタ
     * @param msg メッセージ
     */
    public ErrorResponse(Message msg, boolean reEnterableFlag) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = msg.getMessageID();
        this.errorMessage = msg.getMessage();
        this.reEnterableFlag = reEnterableFlag;
    }

    /**
     * コンストラクタ
     * @param msg メッセージ
     * @param body ボディ部
     */
    public ErrorResponse(Message msg, Object body) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = msg.getMessageID();
        this.errorMessage = msg.getMessage();
        this.reEnterableFlag = true;
        this.result = body;
    }

    /**
     * コンストラクタ
     * @param msg メッセージ
     * @param reEnterableFlag 再入力可能フラグ
     * @param body ボディ部
     */
    public ErrorResponse(Message msg, boolean reEnterableFlag, Object body) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = msg.getMessageID();
        this.errorMessage = msg.getMessage();
        this.reEnterableFlag = reEnterableFlag;
        this.result = body;
    }

//    /**
//     * コンストラクター
//     * @param errorCode　メッセージコード
//     * @param errorMessage　メッセージ
//     */
//    public ErrorResponse(String errorCode, String errorMessage) {
//        //this.status = ApiConstant.STATUS_NG;
//        this.errorCode = errorCode;
//        this.errorMessage = errorMessage;
//        this.reEnterableFlag = true;
//    }

    /**
     * コンストラクター
     * @param errorCode　メッセージコード
     * @param errorMessage　メッセージ
     * @param reEnterableFlag 再入力可能フラグ
     */
    public ErrorResponse(String errorCode, String errorMessage, boolean reEnterableFlag) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.reEnterableFlag = reEnterableFlag;
    }

    /**
     * コンストラクター
     * @param errorCode メッセージコード
     * @param msg メッセージ
     * @param body ボディ部
     */
    public ErrorResponse(String errorCode, String errorMessage, boolean reEnterableFlag,
            Object body) {
        //this.status = ApiConstant.STATUS_NG;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.reEnterableFlag = reEnterableFlag;
        this.result = body;
    }

    @JsonIgnore
    private Object result;
    private String errorCode;
    private String errorMessage;
    private Boolean reEnterableFlag;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getReEnterableFlag() {
        return reEnterableFlag;
    }

    public void setReEnterableFlag(Boolean reEnterableFlag) {
        this.reEnterableFlag = reEnterableFlag;
    }

    @Override
    public String toString() {
        return "ErrorResponse [result=" + result + ", errorCode=" + errorCode + ", errorMessage="
                + errorMessage + ", reEnterableFlag=" + reEnterableFlag + "]";
    }


}
