package com.ibm.business.api.response;

public class Information {

    public Information() {

    }

    public Information(String appStoreRedirectUrl, String googlePlayRedirectUrl) {
        this.appStoreRedirectUrl = appStoreRedirectUrl;
        this.googlePlayRedirectUrl = googlePlayRedirectUrl;
    }


    private String appStoreRedirectUrl;

    private String googlePlayRedirectUrl;

    public String getAppStoreRedirectUrl() {
        return appStoreRedirectUrl;
    }

    public void setAppStoreRedirectUrl(String appStoreRedirectUrl) {
        this.appStoreRedirectUrl = appStoreRedirectUrl;
    }

    public String getGooglePlayRedirectUrl() {
        return googlePlayRedirectUrl;
    }

    public void setGooglePlayRedirectUrl(String googlePlayRedirectUrl) {
        this.googlePlayRedirectUrl = googlePlayRedirectUrl;
    }

    @Override
    public String toString() {
        return "Information [appStoreRedirectUrl=" + appStoreRedirectUrl
                + ", googlePlayRedirectUrl=" + googlePlayRedirectUrl + "]";
    }
}
