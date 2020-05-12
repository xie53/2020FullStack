package com.ibm.business.exception;

import java.util.HashMap;
import java.util.Map;

import com.ibm.business.bean.res.InitRemoteRes;

/**
 * リモートサービス業務アプリケーションエラー
 *
 */
public class RemoteApiApplicationException extends ApplicationException {

    private static final long serialVersionUID = -691725363183025330L;

    /** エラーコード */
    private String errorCode;
    /** エラーメッセージ */
    private String errorMessage;
    /** 再入力可能フラグ */
    private Boolean reEnterableFlag;

    /**
     * コンストラクター
     * @param initRemoteRes サーバからレスポンス
     * @param headerMap ヘッダーマップ
     */
    public RemoteApiApplicationException(InitRemoteRes initRemoteRes, Map<String, String> headerMap) {
        super(initRemoteRes.getErrorCode(), null, headerMap);
        this.errorCode = initRemoteRes.getErrorCode();
        this.errorMessage = initRemoteRes.getErrorMessage();
        this.reEnterableFlag = initRemoteRes.getReEnterableFlag();
    }
    
    /**
     * コンストラクター
     * @param initRemoteRes サーバからレスポンス
     */
    public RemoteApiApplicationException(InitRemoteRes initRemoteRes) {
        super(initRemoteRes.getErrorCode(), null, new HashMap<String, String>());
        this.errorCode = initRemoteRes.getErrorCode();
        this.errorMessage = initRemoteRes.getErrorMessage();
        this.reEnterableFlag = initRemoteRes.getReEnterableFlag();
    }

//    /**
//     * コンストラクター
//     * @param messageId エラーコード
//     * @param errorMessage エラーメッセージ
//     * @param reEnterableFlag 再入力可能フラグ
//     * @param headerMap　ヘッダーマップ
//     */
//    public RemoteApiApplicationException(String messageId, String errorMessage,
//            Boolean reEnterableFlag, Map<String, String> headerMap) {
//        super(messageId, null, headerMap);
//        this.errorCode = messageId;
//        this.errorMessage = errorMessage;
//        this.reEnterableFlag = reEnterableFlag;
//    }
//
//    /**
//     * コンストラクター
//     * @param messageId エラーコード
//     * @param errorMessage エラーメッセージ
//     * @param arguments メッセージ・パラメータ
//     * @param reEnterableFlag 再入力可能フラグ
//     * @param headerMap　ヘッダーマップ
//     */
//    public RemoteApiApplicationException(String messageId, String errorMessage, Object[] arguments,
//            Boolean reEnterableFlag, Map<String, String> headerMap) {
//        super(messageId, arguments, headerMap);
//        this.errorCode = messageId;
//        this.errorMessage = errorMessage;
//        this.reEnterableFlag = reEnterableFlag;
//    }

    /**
     * サーバからエラーコードを取得
     * @return　サーバからエラーコード
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * サーバからエラーメッセージを取得
     * @return　サーバからエラーメッセージ
     */
    public String getErrorMessage() {
        return errorMessage;
    }


    /**
     * サーバから再入力可能フラグを取得
     * @return　サーバから再入力可能フラグ
     */
    public Boolean getReEnterableFlag() {
        return reEnterableFlag;
    }

}
