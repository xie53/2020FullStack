package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AccountInfoRes {
	private String branchNumber;
	private String branchName;
	private String accountType;
	private String accountTypeName;
	private String accountNumber;

	public String getBranchNumber() {
		return branchNumber;
	}

	public void setBranchNumber(String branchNumber) {
		this.branchNumber = branchNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "AccountInfoRes [branchNumber=" + branchNumber + ", branchName=" + branchName + ", accountType=" + accountType + ", accountTypeName=" + accountTypeName + ", accountNumber=" + accountNumber + "]";
	}
}
