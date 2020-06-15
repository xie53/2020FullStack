package com.ibm.business.buyer.message;

/**
 * BFF用のメッセージ
 *
 */
public interface Message {

    /**
     * メッセージレベルを取得
     * @return メッセージレベル
     */
    MessageLevel getLevel();

    /**
     * HttpStatusCodeを取得
     * @return HttpStatusCode
     */
    int getHttpStatusCode();

    /**
     * メッセージIDを取得
     * @return メッセージID
     */
    String getMessageID();

    /**
     * メッセージを取得
     * @return メッセージ
     */
    String getMessage();


}
