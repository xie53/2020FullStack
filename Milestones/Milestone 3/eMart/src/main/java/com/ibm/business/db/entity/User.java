package com.ibm.business.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_USER database table.
 * 
 */
@Entity
@Table(name="T_USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="ACCESS_TOKEN")
	private String accessToken;

	@Column(name="ACCESS_TOKEN_ISSUED_AT")
	private Timestamp accessTokenIssuedAt;

	@Column(name="APP_OS_TYPE")
	private String appOsType;

	@Column(name="APP_VERSION")
	private String appVersion;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="DEVICE_NAME")
	private String deviceName;

	@Column(name="DEVICE_OS_VERSION")
	private String deviceOsVersion;

	@Column(name="LAST_LOGIN_AT")
	private Timestamp lastLoginAt;

	@Column(name="\"STATE\"")
	private String state;

	@Column(name="STATE_ISSUED_AT")
	private Timestamp stateIssuedAt;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Timestamp getAccessTokenIssuedAt() {
		return this.accessTokenIssuedAt;
	}

	public void setAccessTokenIssuedAt(Timestamp accessTokenIssuedAt) {
		this.accessTokenIssuedAt = accessTokenIssuedAt;
	}

	public String getAppOsType() {
		return this.appOsType;
	}

	public void setAppOsType(String appOsType) {
		this.appOsType = appOsType;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceOsVersion() {
		return this.deviceOsVersion;
	}

	public void setDeviceOsVersion(String deviceOsVersion) {
		this.deviceOsVersion = deviceOsVersion;
	}

	public Timestamp getLastLoginAt() {
		return this.lastLoginAt;
	}

	public void setLastLoginAt(Timestamp lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getStateIssuedAt() {
		return this.stateIssuedAt;
	}

	public void setStateIssuedAt(Timestamp stateIssuedAt) {
		this.stateIssuedAt = stateIssuedAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}