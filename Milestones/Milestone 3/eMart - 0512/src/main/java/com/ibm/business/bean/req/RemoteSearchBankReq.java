package com.ibm.business.bean.req;

import java.util.Date;

import com.ibm.business.util.DateUtil;

/**
* BFFDigital
* @author ShiYan Jun 10, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteSearchBankReq {

	private String _strUserID;
	private String _strCnsmrMktSeg = "11";
	private String _strStaffID = "0001";
	private String _strSystemDiv = "01";
	private String _strEigyoTenID;
	private String _strCifNo;
	private String _strContactID = "BANK_SEARCH01";
	private String _strBranchNum = "00000";
	private String _strChannelID = "IK";
	private String _strDeviceType = "P";
	private String _strIPAddr = "http://dummy";
	private String _strAppID = "KtBanksrhBsrh";
	private String _strOperationCD = " ";
	private String _strGyoTp = "KTBANKSRC";
	private String _strTrnsID = "1209";
	private String _strMsgNum = "00000";
	private String _strErrMsgCDAttr = "0";
	private String _strBankNoSrchType = "11";
	private String _strBankNoKanaKey;
	private String _strValidDate = DateUtil.getYYYYMMDD(new Date());
	
	public RemoteSearchBankReq(String username, String searchContent, String validDate) {
		this._strUserID = username;
		this._strEigyoTenID = username.substring(0, 3);
		this._strCifNo = username.substring(3);
		this._strBankNoKanaKey = searchContent;
		this._strValidDate = validDate;
	}

	public String get_strUserID() {
		return _strUserID;
	}

	public void set_strUserID(String _strUserID) {
		this._strUserID = _strUserID;
	}

	public String get_strCnsmrMktSeg() {
		return _strCnsmrMktSeg;
	}

	public void set_strCnsmrMktSeg(String _strCnsmrMktSeg) {
		this._strCnsmrMktSeg = _strCnsmrMktSeg;
	}

	public String get_strStaffID() {
		return _strStaffID;
	}

	public void set_strStaffID(String _strStaffID) {
		this._strStaffID = _strStaffID;
	}

	public String get_strSystemDiv() {
		return _strSystemDiv;
	}

	public void set_strSystemDiv(String _strSystemDiv) {
		this._strSystemDiv = _strSystemDiv;
	}

	public String get_strEigyoTenID() {
		return _strEigyoTenID;
	}

	public void set_strEigyoTenID(String _strEigyoTenID) {
		this._strEigyoTenID = _strEigyoTenID;
	}

	public String get_strCifNo() {
		return _strCifNo;
	}

	public void set_strCifNo(String _strCifNo) {
		this._strCifNo = _strCifNo;
	}

	public String get_strContactID() {
		return _strContactID;
	}

	public void set_strContactID(String _strContactID) {
		this._strContactID = _strContactID;
	}

	public String get_strBranchNum() {
		return _strBranchNum;
	}

	public void set_strBranchNum(String _strBranchNum) {
		this._strBranchNum = _strBranchNum;
	}

	public String get_strChannelID() {
		return _strChannelID;
	}

	public void set_strChannelID(String _strChannelID) {
		this._strChannelID = _strChannelID;
	}

	public String get_strDeviceType() {
		return _strDeviceType;
	}

	public void set_strDeviceType(String _strDeviceType) {
		this._strDeviceType = _strDeviceType;
	}

	public String get_strIPAddr() {
		return _strIPAddr;
	}

	public void set_strIPAddr(String _strIPAddr) {
		this._strIPAddr = _strIPAddr;
	}

	public String get_strAppID() {
		return _strAppID;
	}

	public void set_strAppID(String _strAppID) {
		this._strAppID = _strAppID;
	}

	public String get_strOperationCD() {
		return _strOperationCD;
	}

	public void set_strOperationCD(String _strOperationCD) {
		this._strOperationCD = _strOperationCD;
	}

	public String get_strGyoTp() {
		return _strGyoTp;
	}

	public void set_strGyoTp(String _strGyoTp) {
		this._strGyoTp = _strGyoTp;
	}

	public String get_strTrnsID() {
		return _strTrnsID;
	}

	public void set_strTrnsID(String _strTrnsID) {
		this._strTrnsID = _strTrnsID;
	}

	public String get_strMsgNum() {
		return _strMsgNum;
	}

	public void set_strMsgNum(String _strMsgNum) {
		this._strMsgNum = _strMsgNum;
	}

	public String get_strErrMsgCDAttr() {
		return _strErrMsgCDAttr;
	}

	public void set_strErrMsgCDAttr(String _strErrMsgCDAttr) {
		this._strErrMsgCDAttr = _strErrMsgCDAttr;
	}

	public String get_strBankNoSrchType() {
		return _strBankNoSrchType;
	}

	public void set_strBankNoSrchType(String _strBankNoSrchType) {
		this._strBankNoSrchType = _strBankNoSrchType;
	}

	public String get_strBankNoKanaKey() {
		return _strBankNoKanaKey;
	}

	public void set_strBankNoKanaKey(String _strBankNoKanaKey) {
		this._strBankNoKanaKey = _strBankNoKanaKey;
	}

	public String get_strValidDate() {
		return _strValidDate;
	}

	public void set_strValidDate(String _strValidDate) {
		this._strValidDate = _strValidDate;
	}

	@Override
	public String toString() {
		return "SearchBankReq [_strUserID=" + _strUserID + ", _strCnsmrMktSeg=" + _strCnsmrMktSeg + ", _strStaffID="
				+ _strStaffID + ", _strSystemDiv=" + _strSystemDiv + ", _strEigyoTenID=" + _strEigyoTenID
				+ ", _strCifNo=" + _strCifNo + ", _strContactID=" + _strContactID + ", _strBranchNum=" + _strBranchNum
				+ ", _strChannelID=" + _strChannelID + ", _strDeviceType=" + _strDeviceType + ", _strIPAddr="
				+ _strIPAddr + ", _strAppID=" + _strAppID + ", _strOperationCD=" + _strOperationCD + ", _strGyoTp="
				+ _strGyoTp + ", _strTrnsID=" + _strTrnsID + ", _strMsgNum=" + _strMsgNum + ", _strErrMsgCDAttr="
				+ _strErrMsgCDAttr + ", _strBankNoSrchType=" + _strBankNoSrchType + ", _strBankNoKanaKey="
				+ _strBankNoKanaKey + ", _strValidDate=" + _strValidDate + "]";
	}
}
