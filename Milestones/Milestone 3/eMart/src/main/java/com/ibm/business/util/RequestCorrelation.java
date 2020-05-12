// © Copyright IBM Corp. 2017 All rights reserved.
package com.ibm.business.util;

import com.ibm.business.constant.EnumAppOsType;
import com.ibm.business.constant.EnumAppStatus;
import com.ibm.business.constant.EnumRegType;

public class RequestCorrelation {

    private static final ThreadLocal<String> correlationId = new ThreadLocal<String>();

    private static final ThreadLocal<String> threadDeviceId = new ThreadLocal<String>();

    private static final ThreadLocal<EnumAppStatus> threadAppStatus = new ThreadLocal<EnumAppStatus>();

    private static final ThreadLocal<EnumAppOsType> threadAppOsType = new ThreadLocal<EnumAppOsType>();

    private static final ThreadLocal<String> threadAppVersion = new ThreadLocal<String>();

    private static final ThreadLocal<String> threadOsVersion = new ThreadLocal<String>();

    private static final ThreadLocal<String> threadDeviceName = new ThreadLocal<String>();

    private static final ThreadLocal<EnumRegType> threadRegType = new ThreadLocal<EnumRegType>();

    public static void setCorrelationId(String id) {
    	correlationId.set(id);
    }

    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static void setDeviceId(String deviceId) {
    	threadDeviceId.set(deviceId);
    }

    public static String getDeviceId() {
        return threadDeviceId.get();
    }

    public static void setAppStatus(EnumAppStatus appStatus) {
    	threadAppStatus.set(appStatus);
    }

    public static EnumAppStatus getAppStatus() {
        return threadAppStatus.get();
    }

    public static void setAppOsType(EnumAppOsType appOsType) {
    	threadAppOsType.set(appOsType);
    }

    public static EnumAppOsType getAppOsType() {
        return threadAppOsType.get();
    }

    public static void setAppVersion(String appVersion) {
    	threadAppVersion.set(appVersion);
    }

    public static String getAppVersion() {
        return threadAppVersion.get();
    }
    
    public static void setDeviceOsVersion(String deviceOsVersion) {
    	threadOsVersion.set(deviceOsVersion);
    }

    public static String getDeviceOsVersion() {
        return threadOsVersion.get();
    }
    
    public static void setDeviceName(String deviceName) {
    	threadDeviceName.set(deviceName);
    }

    public static String getDeviceName() {
        return threadDeviceName.get();
    }
    
    public static void setRegType(EnumRegType regType) {
    	threadRegType.set(regType);
    }

    public static EnumRegType getRegType() {
        return threadRegType.get();
    }
}
