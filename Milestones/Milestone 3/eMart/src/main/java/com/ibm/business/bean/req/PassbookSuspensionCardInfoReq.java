package com.ibm.business.bean.req;

/**
 * 利用停止カード情報
 */
public class PassbookSuspensionCardInfoReq {

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
    /** 口座名義 */
    private String accountName;
    /** カード種類 */
    private String cardType;
    /** 本人・代理人区分 */
    private String principalAgentType;
    /** 再発行可能フラグ */
    private Boolean reissuePossibleFlag;
    /** カード氏名 */
    private String cardPrintName;

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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getPrincipalAgentType() {
        return principalAgentType;
    }

    public void setPrincipalAgentType(String principalAgentType) {
        this.principalAgentType = principalAgentType;
    }

    public Boolean getReissuePossibleFlag() {
        return reissuePossibleFlag;
    }

    public void setReissuePossibleFlag(Boolean reissuePossibleFlag) {
        this.reissuePossibleFlag = reissuePossibleFlag;
    }

    public String getCardPrintName() {
        return cardPrintName;
    }

    public void setCardPrintName(String cardPrintName) {
        this.cardPrintName = cardPrintName;
    }


}
