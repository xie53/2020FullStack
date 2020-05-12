package com.ibm.business.constant;

public enum EnumAppStatus {

    ACCEPTABLE("0"), UPDATE_REQUIRED("1");

    private String status;

    private EnumAppStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static EnumAppStatus status(String status) {
        if("0".equals(status)) {
            return ACCEPTABLE;
        }else if("1".equals(status)) {
            return UPDATE_REQUIRED;
        }else {
            return null;
        }
    }
}
