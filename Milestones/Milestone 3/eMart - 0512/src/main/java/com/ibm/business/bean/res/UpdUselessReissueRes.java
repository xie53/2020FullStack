package com.ibm.business.bean.res;

/**
 * 利用不能カード再発行申込受付情報
 */
public class UpdUselessReissueRes extends InitRemoteRes {
    /** 受付番号（顧客表示用） */
    private String receiptNumberCustomer;

    public String getReceiptNumberCustomer() {
        return receiptNumberCustomer;
    }

    public void setReceiptNumberCustomer(String receiptNumberCustomer) {
        this.receiptNumberCustomer = receiptNumberCustomer;
    }

}
