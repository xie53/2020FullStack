package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;

import com.ibm.business.validator.InputConstraint;

/**
 * 再発行カード情報（喪失再発行申込受付用）
 *
 */
public class LostReissueCashcardInfoReq {

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
    /** カード氏名 */
    private String cardPrintName;
    /** デザイン */
    @InputConstraint(itemName="デザイン", notEmpty=false, type=HALF_DIGIT, length=1)
    private String articleDesign;

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

    public String getCardPrintName() {
        return cardPrintName;
    }

    public void setCardPrintName(String cardPrintName) {
        this.cardPrintName = cardPrintName;
    }

    public String getArticleDesign() {
        return articleDesign;
    }

    public void setArticleDesign(String articleDesign) {
        this.articleDesign = articleDesign;
    }

}
