package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;

import com.ibm.business.validator.InputConstraint;

/**
 * 手数料引落情報（喪失再発行申込受付）
 *
 */
public class LostReissueWithdrawingInformationReq {

    /** 店番 */
    @InputConstraint(itemName="店番", notEmpty=true, type=HALF_DIGIT, length=3)
    private String withdrawingBranchNumber;
    /** 科目コード */
    @InputConstraint(itemName="科目コード", notEmpty=true, type=HALF_DIGIT, length=2)
    private String withdrawingAccountType;
    /** 口座番号 */
    @InputConstraint(itemName="口座番号", notEmpty=true, type=HALF_DIGIT, length=7)
    private String withdrawingAccountNumber;
    /** 再発行手数料 */
    @InputConstraint(itemName="再発行手数料", notEmpty=true, type=HALF_DIGIT, minLength=1, maxLength=5)
    private String reissueCharge;

    public String getWithdrawingBranchNumber() {
        return withdrawingBranchNumber;
    }

    public void setWithdrawingBranchNumber(String withdrawingBranchNumber) {
        this.withdrawingBranchNumber = withdrawingBranchNumber;
    }

    public String getWithdrawingAccountType() {
        return withdrawingAccountType;
    }

    public void setWithdrawingAccountType(String withdrawingAccountType) {
        this.withdrawingAccountType = withdrawingAccountType;
    }

    public String getWithdrawingAccountNumber() {
        return withdrawingAccountNumber;
    }

    public void setWithdrawingAccountNumber(String withdrawingAccountNumber) {
        this.withdrawingAccountNumber = withdrawingAccountNumber;
    }

    public String getReissueCharge() {
        return reissueCharge;
    }

    public void setReissueCharge(String reissueCharge) {
        this.reissueCharge = reissueCharge;
    }


}
