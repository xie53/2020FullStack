package com.ibm.business.user.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class HeaderInfoRes {
    /** BFFトークン */
    private String token;
    /** BFO用通信トークン */
    private String authorization;
    /** アプリシークレット */
    private String appSecret;
    /** クライアントID */
	private String client_id;
	/** リソースオーナー */
	private String userinfo;
	/** 認証区分 */
	private String authtype;
	/** 取引ID */
	private String transactionID;
	/** 経路選択情報 */
	private String routingInfo;
	/** 金融機関コード */
	private String bankCode;
	/** 端末ID */
	private String deviceID;

	public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getClientId() {
		return client_id;
	}
    public String getAuthorization() {
        return authorization;
    }
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }
    public void setClientId(String client_id) {
		this.client_id = client_id;
	}
	public String getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	public String getAuthtype() {
		return authtype;
	}
	public void setAuthtype(String authtype) {
		this.authtype = authtype;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getRoutingInfo() {
		return routingInfo;
	}
	public void setRoutingInfo(String routingInfo) {
		this.routingInfo = routingInfo;
	}
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getDeviceID() {
        return deviceID;
    }
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
    public String toString() {
        return "HeaderInfoRes [token=" + token + ", authorization=" + authorization + ", client_id="
                + client_id + ", userinfo=" + userinfo + ", authtype=" + authtype + ", transactionID=" 
                + transactionID + ", routingInfo=" + routingInfo  + ", appSecret=" + appSecret
                + ", bankCode=" + bankCode + ", deviceID=" + deviceID + "]";
    }

}
