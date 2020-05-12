package com.ibm.business.api.response;

import com.ibm.business.message.Message;

/**
 * アップグレード必要レスポンス
 *
 */
public class UpgradeRequiredErrorResponse extends ErrorResponse<Object> {

    public UpgradeRequiredErrorResponse() {
        super();
    }

    public UpgradeRequiredErrorResponse(Message msg, Object body) {
        super(msg, body);
    }

    public UpgradeRequiredErrorResponse(Message msg) {
        super(msg);
    }

    public UpgradeRequiredErrorResponse(String errorCode, String errorMessage, Object body) {
        super(errorCode, errorMessage, true, body);
    }

    public UpgradeRequiredErrorResponse(String errorCode, String errorMessage) {
        super(errorCode, errorMessage, true);
    }

    private Information information;

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}
