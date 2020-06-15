package com.ibm.business.buyer.bean.res;

import java.util.List;

/**
 * 再発行手数料情報照会
 */
public class GetReissueChargeinfoRes extends InitRemoteRes {

    /** カード再発行枚数 */
    private String cashcardCount;
    /** 通帳再発行枚数 */
    private String passbookCount;
    /** 再発行手数料 */
    private String reissueCharge;
    /** 手数料引落情報 */
//    private List<ReissueWithdrawingInformationRes> withdrawingInformation;

    public String getCashcardCount() {
        return cashcardCount;
    }

    public void setCashcardCount(String cashcardCount) {
        this.cashcardCount = cashcardCount;
    }

    public String getPassbookCount() {
        return passbookCount;
    }

    public void setPassbookCount(String passbookCount) {
        this.passbookCount = passbookCount;
    }

    public String getReissueCharge() {
        return reissueCharge;
    }

    public void setReissueCharge(String reissueCharge) {
        this.reissueCharge = reissueCharge;
    }

//    public List<ReissueWithdrawingInformationRes> getWithdrawingInformation() {
//        return withdrawingInformation;
//    }
//
//    public void setWithdrawingInformation(
//            List<ReissueWithdrawingInformationRes> withdrawingInformation) {
//        this.withdrawingInformation = withdrawingInformation;
//    }

}
