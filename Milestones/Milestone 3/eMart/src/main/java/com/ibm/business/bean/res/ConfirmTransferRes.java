package com.ibm.business.bean.res;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 29, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class ConfirmTransferRes extends BaseRemoteRes {

	@JsonAlias("_effDt")
	private String transferDesignatedDate;
	@JsonAlias("_tGinkouBangou")
	private String bankToken;
	@JsonAlias("_tGinkouMei")
	private String bankName;
	@JsonAlias("_tGinkouMeiKana")
	private String bankNameKana;
	@JsonAlias("_tShitenBangou")
	private String branchToken;
	@JsonAlias("_tShitenMei")
	private String branchName;
	@JsonAlias("_tShitenMeiKana")
	private String branchNameKana;
	@JsonAlias("_tAcctTpCl")
	private String subject;
	private String subjectName;
	@JsonAlias("_tKouzaBangou")
	private String accountNo;
	@JsonAlias("_tfrNckN")
	private String accountName;
	@JsonAlias("_transferAmt")
	private String transferAmount;
	@JsonAlias("_echarge")
	private String usageFees;
	@JsonAlias("_fcharge")
	private String transferFees;
	private String transferorName;
	private String transferContent;
	@JsonAlias("_strMsgNum")
	private String msgNum;
	@JsonAlias("_acceptNo")
	private String transactionNo;
	public String getTransferDesignatedDate() {
		return transferDesignatedDate;
	}
	public void setTransferDesignatedDate(String transferDesignatedDate) {
		this.transferDesignatedDate = transferDesignatedDate;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	public String getTransferorName() {
		return transferorName;
	}
	public void setTransferorName(String transferorName) {
		this.transferorName = transferorName;
	}
	public String getTransferContent() {
		return transferContent;
	}
	public void setTransferContent(String transferContent) {
		this.transferContent = transferContent;
	}
	public String getMsgNum() {
		return msgNum;
	}
	public void setMsgNum(String msgNum) {
		this.msgNum = msgNum;
	}
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	@Override
	public String toString() {
		return "ConfirmTransferRes [transferDesignatedDate=" + transferDesignatedDate + ", bankToken=" + bankToken
				+ ", bankName=" + bankName + ", bankNameKana=" + bankNameKana + ", branchToken=" + branchToken
				+ ", branchName=" + branchName + ", branchNameKana=" + branchNameKana + ", subject=" + subject
				+ ", subjectName=" + subjectName + ", accountNo=" + accountNo + ", accountName=" + accountName
				+ ", transferAmount=" + transferAmount + ", usageFees=" + usageFees + ", transferFees=" + transferFees
				+ ", transferorName=" + transferorName + ", transferContent=" + transferContent + ", msgNum=" + msgNum
				+ ", transactionNo=" + transactionNo + "]";
	}
}
