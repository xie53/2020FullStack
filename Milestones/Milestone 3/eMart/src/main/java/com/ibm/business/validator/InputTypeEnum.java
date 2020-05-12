package com.ibm.business.validator;

/**
 * 文字属性チェック
 *
 */
public enum InputTypeEnum {
    NONE("チェックなし"), // チェックなし
    HALF_DIGIT("半角数値"), // 半角数値文字列
    // FULL_TEXT("全角文字"), // 全角ｶﾅ,全角英数字,ホスト許容記号の全角文字 ※ホスト許容記号："\()-/*&$,.@=%+; "
    // HOST_TEXT("全半角文字列"), // 全角/半角ｶﾅ,全角/半角英数字,全角/半角ホスト許容記号 ※ホスト許容記号："\()-/*&$,.@=%+; "
    MAIL("メールアドレス") // 1-256桁の半角英字、半角数字、メールアドレス許容記号（!#$%&'*+-/=?^_`{|}~@. (21文字)）
    ;

    /** 属性名 */
    private String property;
    
    private InputTypeEnum(String property) {
        this.property = property;
    }
    
    public String getPropertyName() {
        return property;
    }
}
