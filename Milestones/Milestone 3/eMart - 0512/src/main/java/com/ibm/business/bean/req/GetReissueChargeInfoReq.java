package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;

import com.ibm.business.validator.InputConstraint;

/**
 * テスト日時が設定されている場合、テスト日時での再発行手数料を照会リクエスト
 *
 */
public class GetReissueChargeInfoReq {
    @InputConstraint(itemName="カード再発行枚数", notEmpty=false, type=HALF_DIGIT, minLength=1, maxLength=2) /** カード再発行枚数 */ private String cashcardCount;
    @InputConstraint(itemName="通帳再発行枚数", notEmpty=false, type=HALF_DIGIT, minLength=1, maxLength=2)  /** 通帳再発行枚数 */  private String passbookCount;   

    public String getCashcardCount() {
        return cashcardCount;
    }
    public void setCashcardCount(String cashcardCount) {
        this.cashcardCount = cashcardCount;
    }
    public String getPassbookCount() {
        return passbookCount;
    }
    public void setPassbookCount(String passbookCount) {
        this.passbookCount = passbookCount;
    }

}
