package com.ibm.business.validator;

/**
 * 入力チェックサービス
 *
 */
public interface ValidateService {

    /**
     * 入力チェック
     * @param <T> チェッククラス
     * @param object チェック対象
     * @param groups チェックグループ
     */
    <T> void validate(T object, Class<?>... groups);

}
