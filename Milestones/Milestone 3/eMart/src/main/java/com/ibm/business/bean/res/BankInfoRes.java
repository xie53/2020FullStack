package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BankInfoRes {
	@JsonAlias("fiCode")
	private String bankToken;
	@JsonAlias("fiMei")
	private String bankName;
	@JsonAlias("fiMeiKana")
	private String bankNameKana;
	public String getBankToken() {
		return bankToken;
	}
	public void setBankToken(String bankToken) {
		this.bankToken = bankToken;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNameKana() {
		return bankNameKana;
	}
	public void setBankNameKana(String bankNameKana) {
		this.bankNameKana = bankNameKana;
	}
	@Override
	public String toString() {
		return "BankInfoRes [bankToken=" + bankToken + ", bankName=" + bankName + ", bankNameKana=" + bankNameKana
				+ "]";
	}
}
