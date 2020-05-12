package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ExecuteTransferWithCheckRes extends BaseRemoteRes {

	@JsonAlias("_acceptNo")
	private String transferNumber;
	@JsonAlias("_acceptDt")
	private String transferExecuteDate;
	@JsonAlias("_acceptTm")
	private String transferExecuteTime;
	@JsonAlias("_tGinkouMei")
	private String toBankName;
	@JsonAlias("_tShitenMei")
	private String toBranchName;
	@JsonAlias("_tKouzaBangou")
	private String toAccountNo;
	@JsonAlias("_tfrNckN")
	private String toAccountName;
	@JsonAlias("_shitenMei")
	private String fromBranchName;
	@JsonAlias("_acctTpCl")
	private String subjectName;
	@JsonAlias("_kouzaBangou")
	private String fromAccountNo;
	@JsonAlias("")
	private String transferorName;
	@JsonAlias("_transferAmt")
	private String transferAmount;
	@JsonAlias("_echarge")
	private String usageFees;
	@JsonAlias("_fcharge")
	private String transferFees;
	@JsonAlias("_strMsgNum")
	private String msgNum;
	public String getTransferNumber() {
		return transferNumber;
	}
	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}
	public String getTransferExecuteDate() {
		return transferExecuteDate;
	}
	public void setTransferExecuteDate(String transferExecuteDate) {
		this.transferExecuteDate = transferExecuteDate;
	}
	public String getTransferExecuteTime() {
		return transferExecuteTime;
	}
	public void setTransferExecuteTime(String transferExecuteTime) {
		this.transferExecuteTime = transferExecuteTime;
	}
	public String getToBankName() {
		return toBankName;
	}
	public void setToBankName(String toBankName) {
		this.toBankName = toBankName;
	}
	public String getToBranchName() {
		return toBranchName;
	}
	public void setToBranchName(String toBranchName) {
		this.toBranchName = toBranchName;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public String getToAccountName() {
		return toAccountName;
	}
	public void setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
	}
	public String getFromBranchName() {
		return fromBranchName;
	}
	public void setFromBranchName(String fromBranchName) {
		this.fromBranchName = fromBranchName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(String fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public String getTransferorName() {
		return transferorName;
	}
	public void setTransferorName(String transferorName) {
		this.transferorName = transferorName;
	}
	public String getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getUsageFees() {
		return usageFees;
	}
	public void setUsageFees(String usageFees) {
		this.usageFees = usageFees;
	}
	public String getTransferFees() {
		return transferFees;
	}
	public void setTransferFees(String transferFees) {
		this.transferFees = transferFees;
	}
	public String getMsgNum() {
		return msgNum;
	}
	public void setMsgNum(String msgNum) {
		this.msgNum = msgNum;
	}
	@Override
	public String toString() {
		return "ExecuteTransferWithCheckRes [transferNumber=" + transferNumber + ", transferExecuteDate="
				+ transferExecuteDate + ", transferExecuteTime=" + transferExecuteTime + ", toBankName=" + toBankName
				+ ", toBranchName=" + toBranchName + ", toAccountNo=" + toAccountNo + ", toAccountName=" + toAccountName
				+ ", fromBranchName=" + fromBranchName + ", subjectName=" + subjectName + ", fromAccountNo="
				+ fromAccountNo + ", transferorName=" + transferorName + ", transferAmount=" + transferAmount
				+ ", usageFees=" + usageFees + ", transferFees=" + transferFees + ", msgNum=" + msgNum + "]";
	}
}
