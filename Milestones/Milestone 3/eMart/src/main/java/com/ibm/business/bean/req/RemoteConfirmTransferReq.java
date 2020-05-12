package com.ibm.business.bean.req;

import java.util.Date;

import com.ibm.business.util.DateUtil;

/**
* BFFDigital
* @author ShiYan Jun 10, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class RemoteConfirmTransferReq {
	
	private String _strUserID;
    private String _strCnsmrMktSeg = "11";
    private String _strStaffID = "0001";
    private String _strSystemDiv = "01";
    private String _strEigyoTenID;
    private String _strCifNo;
    private String _strContactID = "FURIKOMI_CONF01";
    private String _strBranchNum = "00000";
    private String _strChannelID = "IK";
    private String _strDeviceType = "P";
    private String _strIPAddr = "http://dummy";
    private String _strAppID = "SiFkomiCnf";
    private String _strOperationCD = " ";
    private String _strGyoTp = "SIFKOMICNFRM";
    private String _strTrnsID = "0402";
    private String _strMsgNum = "00000";
    private String _strErrMsgCDAttr = "0";
    private String _effDt = DateUtil.getYYYYMMDD(new Date());;
    private String _tfrCode = "12";
    private String _shitenBangou;
    private String _shitenMei;
    private String _shitenMeiKana;
    private String _acctTpCl = "1";
    private String _kamokuMei = "普通預金";
    private String _kouzaServiceType = "0";
    private String _kouzaType = "0";
    private String _kouzaBangou;
    private String _cnsmrLastNm;
    private String _wrkPhNbrId = "012-345-6789";
    private String _tGinkouBangou;
    private String _tGinkouMei;
    private String _tGinkouMeiKana;
    private String _tShitenBangou;
    private String _tShitenMei;
    private String _tShitenMeiKana;
    private String _tAcctTpCl = "001";
    private String _tKamokuMei = "普通預金";
    private String _tKouzaServiceType = "0";
    private String _tKouzaType = "0";
    private String _tKouzaBangou;
    private String _tsuukaCode = "JPY";
    private String _transferAmt;
    private String _tfrHistShowTp = "1";
    private String _targetSelectTp = "0";
    private String _resultsDtlBangou = "0";
    
    public RemoteConfirmTransferReq(String username) {
    		this._strUserID = username;
    		this._strEigyoTenID = username.substring(0, 3);
    		this._strCifNo = username.substring(3);
    		this._shitenBangou = username.substring(0, 3);
    		this._kouzaBangou = username.substring(3);
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

	public String get_effDt() {
		return _effDt;
	}

	public void set_effDt(String _effDt) {
		this._effDt = _effDt;
	}

	public String get_tfrCode() {
		return _tfrCode;
	}

	public void set_tfrCode(String _tfrCode) {
		this._tfrCode = _tfrCode;
	}

	public String get_shitenBangou() {
		return _shitenBangou;
	}

	public void set_shitenBangou(String _shitenBangou) {
		this._shitenBangou = _shitenBangou;
	}

	public String get_shitenMei() {
		return _shitenMei;
	}

	public void set_shitenMei(String _shitenMei) {
		this._shitenMei = _shitenMei;
	}

	public String get_shitenMeiKana() {
		return _shitenMeiKana;
	}

	public void set_shitenMeiKana(String _shitenMeiKana) {
		this._shitenMeiKana = _shitenMeiKana;
	}

	public String get_acctTpCl() {
		return _acctTpCl;
	}

	public void set_acctTpCl(String _acctTpCl) {
		this._acctTpCl = _acctTpCl;
	}

	public String get_kamokuMei() {
		return _kamokuMei;
	}

	public void set_kamokuMei(String _kamokuMei) {
		this._kamokuMei = _kamokuMei;
	}

	public String get_kouzaServiceType() {
		return _kouzaServiceType;
	}

	public void set_kouzaServiceType(String _kouzaServiceType) {
		this._kouzaServiceType = _kouzaServiceType;
	}

	public String get_kouzaType() {
		return _kouzaType;
	}

	public void set_kouzaType(String _kouzaType) {
		this._kouzaType = _kouzaType;
	}

	public String get_kouzaBangou() {
		return _kouzaBangou;
	}

	public void set_kouzaBangou(String _kouzaBangou) {
		this._kouzaBangou = _kouzaBangou;
	}

	public String get_cnsmrLastNm() {
		return _cnsmrLastNm;
	}

	public void set_cnsmrLastNm(String _cnsmrLastNm) {
		this._cnsmrLastNm = _cnsmrLastNm;
	}

	public String get_wrkPhNbrId() {
		return _wrkPhNbrId;
	}

	public void set_wrkPhNbrId(String _wrkPhNbrId) {
		this._wrkPhNbrId = _wrkPhNbrId;
	}

	public String get_tGinkouBangou() {
		return _tGinkouBangou;
	}

	public void set_tGinkouBangou(String _tGinkouBangou) {
		this._tGinkouBangou = _tGinkouBangou;
	}

	public String get_tGinkouMei() {
		return _tGinkouMei;
	}

	public void set_tGinkouMei(String _tGinkouMei) {
		this._tGinkouMei = _tGinkouMei;
	}

	public String get_tGinkouMeiKana() {
		return _tGinkouMeiKana;
	}

	public void set_tGinkouMeiKana(String _tGinkouMeiKana) {
		this._tGinkouMeiKana = _tGinkouMeiKana;
	}

	public String get_tShitenBangou() {
		return _tShitenBangou;
	}

	public void set_tShitenBangou(String _tShitenBangou) {
		this._tShitenBangou = _tShitenBangou;
	}

	public String get_tShitenMei() {
		return _tShitenMei;
	}

	public void set_tShitenMei(String _tShitenMei) {
		this._tShitenMei = _tShitenMei;
	}

	public String get_tShitenMeiKana() {
		return _tShitenMeiKana;
	}

	public void set_tShitenMeiKana(String _tShitenMeiKana) {
		this._tShitenMeiKana = _tShitenMeiKana;
	}

	public String get_tAcctTpCl() {
		return _tAcctTpCl;
	}

	public void set_tAcctTpCl(String _tAcctTpCl) {
		this._tAcctTpCl = _tAcctTpCl;
	}

	public String get_tKamokuMei() {
		return _tKamokuMei;
	}

	public void set_tKamokuMei(String _tKamokuMei) {
		this._tKamokuMei = _tKamokuMei;
	}

	public String get_tKouzaServiceType() {
		return _tKouzaServiceType;
	}

	public void set_tKouzaServiceType(String _tKouzaServiceType) {
		this._tKouzaServiceType = _tKouzaServiceType;
	}

	public String get_tKouzaType() {
		return _tKouzaType;
	}

	public void set_tKouzaType(String _tKouzaType) {
		this._tKouzaType = _tKouzaType;
	}

	public String get_tKouzaBangou() {
		return _tKouzaBangou;
	}

	public void set_tKouzaBangou(String _tKouzaBangou) {
		this._tKouzaBangou = _tKouzaBangou;
	}

	public String get_tsuukaCode() {
		return _tsuukaCode;
	}

	public void set_tsuukaCode(String _tsuukaCode) {
		this._tsuukaCode = _tsuukaCode;
	}

	public String get_transferAmt() {
		return _transferAmt;
	}

	public void set_transferAmt(String _transferAmt) {
		this._transferAmt = _transferAmt;
	}

	public String get_tfrHistShowTp() {
		return _tfrHistShowTp;
	}

	public void set_tfrHistShowTp(String _tfrHistShowTp) {
		this._tfrHistShowTp = _tfrHistShowTp;
	}

	public String get_targetSelectTp() {
		return _targetSelectTp;
	}

	public void set_targetSelectTp(String _targetSelectTp) {
		this._targetSelectTp = _targetSelectTp;
	}

	public String get_resultsDtlBangou() {
		return _resultsDtlBangou;
	}

	public void set_resultsDtlBangou(String _resultsDtlBangou) {
		this._resultsDtlBangou = _resultsDtlBangou;
	}

	@Override
	public String toString() {
		return "RemoteConfirmTransferReq [_strUserID=" + _strUserID + ", _strCnsmrMktSeg=" + _strCnsmrMktSeg
				+ ", _strStaffID=" + _strStaffID + ", _strSystemDiv=" + _strSystemDiv + ", _strEigyoTenID="
				+ _strEigyoTenID + ", _strCifNo=" + _strCifNo + ", _strContactID=" + _strContactID + ", _strBranchNum="
				+ _strBranchNum + ", _strChannelID=" + _strChannelID + ", _strDeviceType=" + _strDeviceType
				+ ", _strIPAddr=" + _strIPAddr + ", _strAppID=" + _strAppID + ", _strOperationCD=" + _strOperationCD
				+ ", _strGyoTp=" + _strGyoTp + ", _strTrnsID=" + _strTrnsID + ", _strMsgNum=" + _strMsgNum
				+ ", _strErrMsgCDAttr=" + _strErrMsgCDAttr + ", _effDt=" + _effDt + ", _tfrCode=" + _tfrCode
				+ ", _shitenBangou=" + _shitenBangou + ", _shitenMei=" + _shitenMei + ", _shitenMeiKana="
				+ _shitenMeiKana + ", _acctTpCl=" + _acctTpCl + ", _kamokuMei=" + _kamokuMei + ", _kouzaServiceType="
				+ _kouzaServiceType + ", _kouzaType=" + _kouzaType + ", _kouzaBangou=" + _kouzaBangou
				+ ", _cnsmrLastNm=" + _cnsmrLastNm + ", _wrkPhNbrId=" + _wrkPhNbrId + ", _tGinkouBangou="
				+ _tGinkouBangou + ", _tGinkouMei=" + _tGinkouMei + ", _tGinkouMeiKana=" + _tGinkouMeiKana
				+ ", _tShitenBangou=" + _tShitenBangou + ", _tShitenMei=" + _tShitenMei + ", _tShitenMeiKana="
				+ _tShitenMeiKana + ", _tAcctTpCl=" + _tAcctTpCl + ", _tKamokuMei=" + _tKamokuMei
				+ ", _tKouzaServiceType=" + _tKouzaServiceType + ", _tKouzaType=" + _tKouzaType + ", _tKouzaBangou="
				+ _tKouzaBangou + ", _tsuukaCode=" + _tsuukaCode + ", _transferAmt=" + _transferAmt
				+ ", _tfrHistShowTp=" + _tfrHistShowTp + ", _targetSelectTp=" + _targetSelectTp + ", _resultsDtlBangou="
				+ _resultsDtlBangou + "]";
	}
    
    
}
