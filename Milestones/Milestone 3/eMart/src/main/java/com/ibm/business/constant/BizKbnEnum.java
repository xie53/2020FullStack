package com.ibm.business.constant;
/**
 * 業務区分
 * @author heye
 *
 */
public enum BizKbnEnum {

    BIZ_ADDRESS_CHANGE("01", "住所変更");
    // 02:
    // 03:
    /** 業務区分 */
    private String bizKbn;
    /** 業務名*/
    private String bizName;

    private BizKbnEnum(String bizKbn, String bizName) {
        this.bizKbn = bizKbn;
        this.bizName = bizName;
    }

    public String getBizKbn() {
        return bizKbn;
    }
    public String getBizName() {
        return bizName;
    }
    
}
