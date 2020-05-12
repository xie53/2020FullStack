package com.ibm.business.bean.res;

import java.util.List;

/**
 * 利用不能カード再発行用登録内容の照会情報
 */
public class GetUselessReissueRes extends InitRemoteRes {
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
    /** 再発行カード情報 */
    private List<UselessReissueCashcardInfoRes> reissueCardInfo;

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

    public List<UselessReissueCashcardInfoRes> getReissueCardInfo() {
        return reissueCardInfo;
    }

    public void setReissueCardInfo(List<UselessReissueCashcardInfoRes> reissueCardInfo) {
        this.reissueCardInfo = reissueCardInfo;
    }

}
