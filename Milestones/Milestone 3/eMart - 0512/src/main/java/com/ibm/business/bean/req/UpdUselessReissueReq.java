package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.MAIL;

import java.util.List;

import com.ibm.business.validator.InputConstraint;

/**
 * 利用不能カード再発行申込受付情報
 */
public class UpdUselessReissueReq {
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
    /** 再発行カード情報 */
    private List<UselessReissueCashcardInfoReq> reissueCardInfo;

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

    public List<UselessReissueCashcardInfoReq> getReissueCardInfo() {
        return reissueCardInfo;
    }

    public void setReissueCardInfo(List<UselessReissueCashcardInfoReq> reissueCardInfo) {
        this.reissueCardInfo = reissueCardInfo;
    }

}
