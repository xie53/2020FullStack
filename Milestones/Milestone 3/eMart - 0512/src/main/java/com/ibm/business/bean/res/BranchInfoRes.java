package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BranchInfoRes {

	@JsonAlias("shitenBangou")
	private String branchToken;
	@JsonAlias("shitenMei")
	private String branchName;
	@JsonAlias("shitenMeiKana")
	private String branchNameKana;
	public String getBranchToken() {
		return branchToken;
	}
	public void setBranchToken(String branchToken) {
		this.branchToken = branchToken;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchNameKana() {
		return branchNameKana;
	}
	public void setBranchNameKana(String branchNameKana) {
		this.branchNameKana = branchNameKana;
	}
	@Override
	public String toString() {
		return "BranchInfoRes [branchToken=" + branchToken + ", branchName=" + branchName + ", branchNameKana="
				+ branchNameKana + "]";
	}
}
