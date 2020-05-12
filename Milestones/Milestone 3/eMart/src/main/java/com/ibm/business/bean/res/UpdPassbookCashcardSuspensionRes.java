package com.ibm.business.bean.res;

/**
 * 口座情報に紐づく利用停止物件、再発行可能物件、連絡先（送付先住所・電話番号）の更新情報
 */
public class UpdPassbookCashcardSuspensionRes extends InitRemoteRes {
    /** 受付番号（顧客表示用） */
    private String receiptNumberCustomer;
    /** 取引結果 */
    private String resultOfTransaction;
    /** エラー情報 */
    private String errorInfoOfTransaction;

    public String getReceiptNumberCustomer() {
        return receiptNumberCustomer;
    }

    public void setReceiptNumberCustomer(String receiptNumberCustomer) {
        this.receiptNumberCustomer = receiptNumberCustomer;
    }

    public String getResultOfTransaction() {
        return resultOfTransaction;
    }

    public void setResultOfTransaction(String resultOfTransaction) {
        this.resultOfTransaction = resultOfTransaction;
    }

    public String getErrorInfoOfTransaction() {
        return errorInfoOfTransaction;
    }

    public void setErrorInfoOfTransaction(String errorInfoOfTransaction) {
        this.errorInfoOfTransaction = errorInfoOfTransaction;
    }


}
