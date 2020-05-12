package com.ibm.business.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.ibm.business.message.Message;
import com.ibm.business.message.MessageProperties;
import com.ibm.business.util.ApplicationContextUtil;

public class InputConstraintValidator implements ConstraintValidator<InputConstraint, Object> {

    /** ロガー */
    private static final Logger logger = LogManager.getLogger(InputConstraintValidator.class);

    /** I,400,{0}は入力必須項目です。 */
    private static final String E000000002000 = "E000000002000";

    /** I,400,項目 {0} は {1} から {2} 文字である必要があります。 */
    private static final String E000000002001 = "E000000002001";

    /** I,400,項目 {0} は {1} である必要があります。 */
    private static final String E000000002002 = "E000000002002";

    /** I,400,項目 {0} は {1} 文字である必要があります。 */
    private static final String E000000002003 = "E000000002003";

    InputConstraint constraint;

    @Override
    public void initialize(InputConstraint constraintAnnotation) {
        this.constraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintContext) {
        MessageProperties messageProperties =
                ApplicationContextUtil.getApplicationContext().getBean(MessageProperties.class);
        // 日本語名
        String itemName = constraint.itemName();
        // 入力必須チェック
        if (constraint.notNull()) {
            if (value == null) {
                Message message = messageProperties.getMessage(E000000002000, itemName);
                constraintContext.disableDefaultConstraintViolation();
                constraintContext.buildConstraintViolationWithTemplate(message.getMessage())
                        .addConstraintViolation();
                return false;
            }
        }
        String messageTemplate = check(value, messageProperties);
        if (messageTemplate != null) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(messageTemplate)
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    protected String check(Object value, MessageProperties messageProperties) {
        if (value instanceof String) {
            return checkValid((String) value, messageProperties);
        } else if (value instanceof Boolean) {
            return checkValid((Boolean) value, messageProperties);
        } else if (value instanceof Object[]) {
            return checkValid((Object[]) value, messageProperties);
        } else {
            throw new IllegalArgumentException("認識できない型：" + value);
        }
    }

    protected String checkValid(String value, MessageProperties messageProperties) {
        // 日本語名
        String itemName = constraint.itemName();
        // 空文字チェック
        if (constraint.notEmpty()) {
            if (StringUtils.isEmpty(value)) {
                Message message = messageProperties.getMessage(E000000002000, itemName);
                return message.getMessage();
            }
        }
        // 桁数チェック
        final int length = constraint.length();
        if (length >= 0) {
            if (!StringUtils.isEmpty(value) && value.length() != length) {
                Message message = messageProperties.getMessage(E000000002003, itemName, length);
                return message.getMessage();
            }
        }
        // 最小、最大桁数チェック（同時指定）
        final int minLength = constraint.minLength();
        final int maxLength = constraint.maxLength();
        if (minLength >= 0 && maxLength >= 0) {
            if (!StringUtils.isEmpty(value) && (value.length() > maxLength || value.length() < minLength)) {
                Message message =
                        messageProperties.getMessage(E000000002001, itemName, minLength, maxLength);
                return message.getMessage();
            }
        }
        // 文字属性チェック
        // TODO
        InputTypeEnum type = constraint.type();
        if(type!= null && type != InputTypeEnum.NONE) {
            switch(type){
                case MAIL:
                    if("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$".matches(value)) {
                        Message message =
                                messageProperties.getMessage(E000000002002, itemName, type.getPropertyName());
                        return message.getMessage();
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    protected String checkValid(Boolean value, MessageProperties messageProperties) {
        // 日本語名
        String itemName = constraint.itemName();
        // 空文字チェック
        if (constraint.notEmpty()) {
            if (value == null) {
                Message message = messageProperties.getMessage(E000000002000, itemName);
                return message.getMessage();
            }
        }
        // 桁数チェック
        final int length = constraint.length();
        if (length >= 0) {
            logger.warn("桁数チェックはBoolean型に適用できない：" + itemName);
        }
        // 最小、最大桁数チェック（同時指定）
        final int minLength = constraint.minLength();
        final int maxLength = constraint.maxLength();
        if (minLength >= 0 && maxLength >= 0) {
            logger.warn("最小、最大桁数チェックはBoolean型に適用できない：" + itemName);
        }
        // 属性チェック
        if (constraint.type() != null && constraint.type() != InputTypeEnum.NONE) {
            logger.warn("文字属性チェックはBoolean型に適用できない：" + itemName);
        }
        return null;
    }


    protected String checkValid(Object[] value, MessageProperties messageProperties) {
        // 日本語名
        String itemName = constraint.itemName();
        // 空文字チェック
        if (constraint.notEmpty()) {
            if (value == null) {
                Message message = messageProperties.getMessage(E000000002000, itemName);
                return message.getMessage();
            }
        }
        // 桁数チェック
        final int length = constraint.length();
        if (length >= 0) {
            logger.warn("桁数チェックは配列型に適用できない：" + itemName);
        }

        // 最小、最大桁数チェック（同時指定）
        final int minLength = constraint.minLength();
        final int maxLength = constraint.maxLength();
        if (minLength >= 0 && maxLength >= 0) {
            logger.warn("最小、最大桁数チェックは配列型に適用できない：" + itemName);
        }
        // 属性チェック
        if (constraint.type() != null && constraint.type() != InputTypeEnum.NONE) {
            logger.warn("文字属性チェックは配列型に適用できない：" + itemName);
        }
        return null;
    }
}
