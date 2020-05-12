package com.ibm.business.bean.res;

/**
 * 再発行通帳情報
 */
public class SuspensionReissuePassbookInfoRes {

    /** 店番 */
    private String branchNumber;
    /** 店名 */
    private String branchName;
    /** 科目コード */
    private String accountType;
    /** 科目名 */
    private String accountTypeName;
    /** 口座番号 */
    private String accountNumber;
    /** 貯蓄フラグ */
    private Boolean savingsFlag;
    /** 総合口座フラグ */
    private Boolean multipleAccountFlag;
    /** 口座名義 */
    private String accountName;

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getSavingsFlag() {
        return savingsFlag;
    }

    public void setSavingsFlag(Boolean savingsFlag) {
        this.savingsFlag = savingsFlag;
    }

    public Boolean getMultipleAccountFlag() {
        return multipleAccountFlag;
    }

    public void setMultipleAccountFlag(Boolean multipleAccountFlag) {
        this.multipleAccountFlag = multipleAccountFlag;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
