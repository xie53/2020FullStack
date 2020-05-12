package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;

import java.util.List;

import com.ibm.business.validator.InputConstraint;

/**
 * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の更新情報
 */
public class UpdPassbookCashcardSuspensionReq {
    /** 漢字氏名 */
    private String userKanjiName;
    /** カナ氏名 */
    private String userName;
    /** 届出事由 */
    @InputConstraint(itemName="届出事由", notEmpty=false, type=HALF_DIGIT, length=1)
    private String reissueReason;
    /** 利用停止カード情報 */
    private List<SuspensionCardInfoReq> suspensionCardInfo;
    /** 利用停止通帳情報 */
    private List<SuspensionPassbookInfoReq> suspensionPassbookInfo;

    public String getUserKanjiName() {
        return userKanjiName;
    }

    public void setUserKanjiName(String userKanjiName) {
        this.userKanjiName = userKanjiName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReissueReason() {
        return reissueReason;
    }

    public void setReissueReason(String reissueReason) {
        this.reissueReason = reissueReason;
    }

    public List<SuspensionCardInfoReq> getSuspensionCardInfo() {
        return suspensionCardInfo;
    }

    public void setSuspensionCardInfo(List<SuspensionCardInfoReq> suspensionCardInfo) {
        this.suspensionCardInfo = suspensionCardInfo;
    }

    public List<SuspensionPassbookInfoReq> getSuspensionPassbookInfo() {
        return suspensionPassbookInfo;
    }

    public void setSuspensionPassbookInfo(List<SuspensionPassbookInfoReq> suspensionPassbookInfo) {
        this.suspensionPassbookInfo = suspensionPassbookInfo;
    }

}
