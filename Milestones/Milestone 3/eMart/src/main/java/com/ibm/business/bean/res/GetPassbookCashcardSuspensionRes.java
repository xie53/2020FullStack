package com.ibm.business.bean.res;

import java.util.List;

/**
 * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の照会情報
 */
public class GetPassbookCashcardSuspensionRes extends InitRemoteRes {
    /** 漢字氏名 */
    private String userKanjiName;
    /** カナ氏名 */
    private String userName;
    /** 送付先郵便番号 */
    private String zipCode;
    /** 送付先漢字住所 */
    private String kanjiAddress;
    /** 送付先カナ住所 */
    private String kanaAddress;
    /** 電話番号 */
    private List<PhoneNumberRes> phoneNumber;
    /** 利用停止カード情報 */
    private List<SuspensionCardInfoRes> suspensionCardInfo;
    /** 利用停止通帳情報 */
    private List<SuspensionPassbookInfoRes> suspensionPassbookInfo;
    /** 再発行カード情報 */
    private List<SuspensionReissueCashcardInfoRes> reissueCashcardInfo;
    /** 再発行通帳情報 */
    private List<SuspensionReissuePassbookInfoRes> reissuePassbookInfo;

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

    public List<PhoneNumberRes> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumberRes> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SuspensionCardInfoRes> getSuspensionCardInfo() {
        return suspensionCardInfo;
    }

    public void setSuspensionCardInfo(List<SuspensionCardInfoRes> suspensionCardInfo) {
        this.suspensionCardInfo = suspensionCardInfo;
    }

    public List<SuspensionPassbookInfoRes> getSuspensionPassbookInfo() {
        return suspensionPassbookInfo;
    }

    public void setSuspensionPassbookInfo(List<SuspensionPassbookInfoRes> suspensionPassbookInfo) {
        this.suspensionPassbookInfo = suspensionPassbookInfo;
    }

    public List<SuspensionReissueCashcardInfoRes> getReissueCashcardInfo() {
        return reissueCashcardInfo;
    }

    public void setReissueCashcardInfo(List<SuspensionReissueCashcardInfoRes> reissueCashcardInfo) {
        this.reissueCashcardInfo = reissueCashcardInfo;
    }

    public List<SuspensionReissuePassbookInfoRes> getReissuePassbookInfo() {
        return reissuePassbookInfo;
    }

    public void setReissuePassbookInfo(List<SuspensionReissuePassbookInfoRes> reissuePassbookInfo) {
        this.reissuePassbookInfo = reissuePassbookInfo;
    }

}
