package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BankInfosRes extends BaseRemoteRes{

	@JsonAlias("fiinfo")
	private List<BankInfoRes> bankInfos = new ArrayList<>();

	public List<BankInfoRes> getBankInfos() {
		return bankInfos;
	}

	public void setBankInfos(List<BankInfoRes> bankInfos) {
		this.bankInfos = bankInfos;
	}

	@Override
	public String toString() {
		return "BankInfosRes [bankInfos=" + bankInfos + "]";
	}
}
