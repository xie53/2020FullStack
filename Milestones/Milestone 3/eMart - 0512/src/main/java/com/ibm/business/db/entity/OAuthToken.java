package com.ibm.business.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_OAUTH_TOKEN database table.
 * 
 */
@Entity
@Table(name="T_OAUTH_TOKEN")
@NamedQuery(name="OAuthToken.findAll", query="SELECT o FROM OAuthToken o")
public class OAuthToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="DEVICE_ID")
	private String deviceId;

	@Column(name="OAUTH_ACCESS_TOKEN")
	private String oauthAccessToken;

	@Column(name="OAUTH_REFRESH_TOKEN")
	private String oauthRefreshToken;

	@Column(name="OAUTH_SCOPE")
	private String oauthScope;

	@Column(name="OAUTH_TOKEN_EXPIRES_IN")
	private int oauthTokenExpiresIn;

	@Column(name="OAUTH_TOKEN_ISSUED_AT")
	private Timestamp oauthTokenIssuedAt;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	public OAuthToken() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getOauthRefreshToken() {
		return this.oauthRefreshToken;
	}

	public void setOauthRefreshToken(String oauthRefreshToken) {
		this.oauthRefreshToken = oauthRefreshToken;
	}

	public String getOauthScope() {
		return this.oauthScope;
	}

	public void setOauthScope(String oauthScope) {
		this.oauthScope = oauthScope;
	}

	public int getOauthTokenExpiresIn() {
		return this.oauthTokenExpiresIn;
	}

	public void setOauthTokenExpiresIn(int oauthTokenExpiresIn) {
		this.oauthTokenExpiresIn = oauthTokenExpiresIn;
	}

	public Timestamp getOauthTokenIssuedAt() {
		return this.oauthTokenIssuedAt;
	}

	public void setOauthTokenIssuedAt(Timestamp oauthTokenIssuedAt) {
		this.oauthTokenIssuedAt = oauthTokenIssuedAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}