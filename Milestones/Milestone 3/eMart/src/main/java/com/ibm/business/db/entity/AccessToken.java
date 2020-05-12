package com.ibm.business.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_ACCESS_TOKEN database table.
 * 
 */
@Entity
@Table(name="T_ACCESS_TOKEN")
@NamedQuery(name="AccessToken.findAll", query="SELECT a FROM AccessToken a")
public class AccessToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="ACCESS_TOKEN")
	private String accessToken;

	@Column(name="BIZ_KBN")
	private String bizKbn;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="OAUTH_ACCESS_TOKEN")
	private String oauthAccessToken;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	public AccessToken() {
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

	public String getBizKbn() {
		return this.bizKbn;
	}

	public void setBizKbn(String bizKbn) {
		this.bizKbn = bizKbn;
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

	public String getOauthAccessToken() {
		return this.oauthAccessToken;
	}

	public void setOauthAccessToken(String oauthAccessToken) {
		this.oauthAccessToken = oauthAccessToken;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}