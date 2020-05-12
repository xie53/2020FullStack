package com.ibm.business.bean.res;

/**
 * 喪失による再発行の申込情報
 */
public class UpdLostReissueRes extends InitRemoteRes {

    /** 受付番号（顧客表示用） */
    private String receiptNumberCustomer;

    public String getReceiptNumberCustomer() {
        return receiptNumberCustomer;
    }

    public void setReceiptNumberCustomer(String receiptNumberCustomer) {
        this.receiptNumberCustomer = receiptNumberCustomer;
    }

}
