package com.ibm.business.bean.req;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ApiConfirmTransferReq {
	
	private String transferDate;
	private String fromBranchName;
	private String fromBranchNameKana;
	private String toBankToken;
	private String toBankName;
	private String toBankNameKana;
	private String toBranchToken;
	private String toBranchName;
	private String toBranchNameKana;
	private String toAccountNo;
	private String transferAmount;
	private String transferorName;

	public String getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}
	public String getFromBranchName() {
		return fromBranchName;
	}
	public void setFromBranchName(String fromBranchName) {
		this.fromBranchName = fromBranchName;
	}
	public String getFromBranchNameKana() {
		return fromBranchNameKana;
	}
	public void setFromBranchNameKana(String fromBranchNameKana) {
		this.fromBranchNameKana = fromBranchNameKana;
	}
	public String getToBankToken() {
		return toBankToken;
	}
	public void setToBankToken(String toBankToken) {
		this.toBankToken = toBankToken;
	}
	public String getToBankName() {
		return toBankName;
	}
	public void setToBankName(String toBankName) {
		this.toBankName = toBankName;
	}
	public String getToBankNameKana() {
		return toBankNameKana;
	}
	public void setToBankNameKana(String toBankNameKana) {
		this.toBankNameKana = toBankNameKana;
	}
	public String getToBranchToken() {
		return toBranchToken;
	}
	public void setToBranchToken(String toBranchToken) {
		this.toBranchToken = toBranchToken;
	}
	public String getToBranchName() {
		return toBranchName;
	}
	public void setToBranchName(String toBranchName) {
		this.toBranchName = toBranchName;
	}
	public String getToBranchNameKana() {
		return toBranchNameKana;
	}
	public void setToBranchNameKana(String toBranchNameKana) {
		this.toBranchNameKana = toBranchNameKana;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public String getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getTransferorName() {
		return transferorName;
	}
	public void setTransferorName(String transferorName) {
		this.transferorName = transferorName;
	}
	@Override
	public String toString() {
		return "ApiConfirmTransferReq [transferDate=" + transferDate + ", fromBranchName="
				+ fromBranchName + ", fromBranchNameKana=" + fromBranchNameKana + ", toBankToken=" + toBankToken
				+ ", toBankName=" + toBankName + ", toBankNameKana=" + toBankNameKana + ", toBranchToken="
				+ toBranchToken + ", toBranchName=" + toBranchName + ", toBranchNameKana=" + toBranchNameKana
				+ ", toAccountNo=" + toAccountNo + ", transferAmount=" + transferAmount + ", transferorName="
				+ transferorName + "]";
	}
}
