package com.ibm.business.exception;

/**
 * 未登録・トークン無効エラー
 */
public class UnauthorizedException extends SystemException {
    
    private static final long serialVersionUID = 7528513302020997421L;

    public UnauthorizedException() {
    }

    public UnauthorizedException(String messageId) {
        super(messageId);
    }

}
