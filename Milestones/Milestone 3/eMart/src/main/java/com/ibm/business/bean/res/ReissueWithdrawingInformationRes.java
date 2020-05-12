package com.ibm.business.bean.res;

/**
 * 手数料引落情報（再発行手数料）
 *
 */
public class ReissueWithdrawingInformationRes {

    /** 店番 */
    private String withdrawingBranchNumber;
    /** 店名 */
    private String withdrawingBranchName;
    /** 科目コード */
    private String withdrawingAccountType;
    /** 科目名 */
    private String withdrawingAccountTypeName;
    /** 口座番号 */
    private String withdrawingAccountNumber;
    /** 口座名義 */
    private String withdrawingaccountName;

    public String getWithdrawingBranchNumber() {
        return withdrawingBranchNumber;
    }

    public void setWithdrawingBranchNumber(String withdrawingBranchNumber) {
        this.withdrawingBranchNumber = withdrawingBranchNumber;
    }

    public String getWithdrawingBranchName() {
        return withdrawingBranchName;
    }

    public void setWithdrawingBranchName(String withdrawingBranchName) {
        this.withdrawingBranchName = withdrawingBranchName;
    }

    public String getWithdrawingAccountType() {
        return withdrawingAccountType;
    }

    public void setWithdrawingAccountType(String withdrawingAccountType) {
        this.withdrawingAccountType = withdrawingAccountType;
    }

    public String getWithdrawingAccountTypeName() {
        return withdrawingAccountTypeName;
    }

    public void setWithdrawingAccountTypeName(String withdrawingAccountTypeName) {
        this.withdrawingAccountTypeName = withdrawingAccountTypeName;
    }

    public String getWithdrawingAccountNumber() {
        return withdrawingAccountNumber;
    }

    public void setWithdrawingAccountNumber(String withdrawingAccountNumber) {
        this.withdrawingAccountNumber = withdrawingAccountNumber;
    }

    public String getWithdrawingaccountName() {
        return withdrawingaccountName;
    }

    public void setWithdrawingaccountName(String withdrawingaccountName) {
        this.withdrawingaccountName = withdrawingaccountName;
    }

}
