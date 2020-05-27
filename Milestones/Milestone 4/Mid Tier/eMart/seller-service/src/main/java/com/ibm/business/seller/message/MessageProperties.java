package com.ibm.business.seller.message;

/**
 * メッセージ管理するコンポーネント
 *
 */
public interface MessageProperties {

    /**
     * メッセージIDよりメッセージを取得
     * @param messageId メッセージID
     * @return メッセージ
     */
    Message getMessage(String messageId);

    /**
     * メッセージIDよりメッセージを取得
     * @param messageId メッセージID
     * @param arguments パラメターリスト
     * @return メッセージ
     */
    public Message getMessage(String messageId, Object... arguments);

    /**
     * メッセージIDが存在するかをチェック
     * @param messageId メッセージID
     * @return メッセージIDが存在する場合はtrue、その他はfalse
     */
    boolean hasMessageId(String messageId);

}
