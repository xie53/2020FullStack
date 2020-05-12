package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;
import static com.ibm.business.validator.InputTypeEnum.MAIL;

import java.util.List;

import com.ibm.business.validator.InputConstraint;

/**
 * 喪失による再発行の申込情報
 * 
 */
public class UpdLostReissueReq {

    /** 漢字氏名 */
    private String userKanjiName;
    /** カナ氏名 */
    private String userName;
    /** メールアドレス */
    @InputConstraint(itemName="メールアドレス", notEmpty=true, type=MAIL, minLength=1, maxLength=256)
    private String mailAddress;
    /** 送付先郵便番号 */
    private String zipCode;
    /** 送付先漢字住所 */
    private String kanjiAddress;
    /** 送付先カナ住所 */
    private String kanaAddress;
    /** 電話番号 */
    private List<PhoneNumberReq> phoneNumber;
    /** 届出事由 */
    @InputConstraint(itemName="届出事由", notEmpty=false, type=HALF_DIGIT, length=1)
    private String reissueReason;
    /** 届出状況 */
    @InputConstraint(itemName="届出状況", notEmpty=false, type=HALF_DIGIT, length=1)
    private String reissueStatus;
    /** 再発行カード情報 */
    private List<LostReissueCashcardInfoReq> reissueCashcardInfo;
    /** 再発行通帳情報 */
    private List<LostReissuePassbookInfoReq> reissuePassbookInfo;
    /** 手数料引落情報 */
    private List<LostReissueWithdrawingInformationReq> withdrawingInformation;

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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getKanjiAddress() {
        return kanjiAddress;
    }

    public void setKanjiAddress(String kanjiAddress) {
        this.kanjiAddress = kanjiAddress;
    }

    public String getKanaAddress() {
        return kanaAddress;
    }

    public void setKanaAddress(String kanaAddress) {
        this.kanaAddress = kanaAddress;
    }

    public List<PhoneNumberReq> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumberReq> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReissueReason() {
        return reissueReason;
    }

    public void setReissueReason(String reissueReason) {
        this.reissueReason = reissueReason;
    }

    public String getReissueStatus() {
        return reissueStatus;
    }

    public void setReissueStatus(String reissueStatus) {
        this.reissueStatus = reissueStatus;
    }

    public List<LostReissueCashcardInfoReq> getReissueCashcardInfo() {
        return reissueCashcardInfo;
    }

    public void setReissueCashcardInfo(List<LostReissueCashcardInfoReq> reissueCashcardInfo) {
        this.reissueCashcardInfo = reissueCashcardInfo;
    }

    public List<LostReissuePassbookInfoReq> getReissuePassbookInfo() {
        return reissuePassbookInfo;
    }

    public void setReissuePassbookInfo(List<LostReissuePassbookInfoReq> reissuePassbookInfo) {
        this.reissuePassbookInfo = reissuePassbookInfo;
    }

    public List<LostReissueWithdrawingInformationReq> getWithdrawingInformation() {
        return withdrawingInformation;
    }

    public void setWithdrawingInformation(
            List<LostReissueWithdrawingInformationReq> withdrawingInformation) {
        this.withdrawingInformation = withdrawingInformation;
    }



}
