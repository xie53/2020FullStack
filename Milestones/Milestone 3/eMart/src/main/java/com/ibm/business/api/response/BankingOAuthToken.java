package com.ibm.business.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankingOAuthToken {

	@JsonProperty("token_type")
	private String tokenType;

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private String expiresIn;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("refresh_token")
	private String refreshToken;

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("expires_in")
	public String getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
