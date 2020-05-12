package com.ibm.business.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = InputConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InputConstraint {
    /** メッセージ（使用不可） */
    String message() default "入力チェックエラー";
    /** 日本語名 */
    String itemName();
    /** null許可有無　*/
    boolean notNull() default false;
    /** 空文字許可有無 */
    boolean notEmpty() default false;
    /** 桁数チェック */
    int length() default -1;
    /** 最小桁数（最大桁数と同時指定必要がある） */
    int minLength() default -1;
    /** 最大桁数（最大桁数と同時指定必要がある）*/
    int maxLength() default -1;
    /** 文字属性チェック */
    InputTypeEnum type() default InputTypeEnum.NONE;
    /** グループ */
    Class<?>[] groups() default {};
    /** ペーロード */
    Class<? extends Payload>[] payload() default {};
}
