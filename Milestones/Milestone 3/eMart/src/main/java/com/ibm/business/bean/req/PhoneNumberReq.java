package com.ibm.business.bean.req;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class PhoneNumberReq {
    private String phoneNumber;
    private String phoneType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneNumberRes [phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + "]";
    }
}
