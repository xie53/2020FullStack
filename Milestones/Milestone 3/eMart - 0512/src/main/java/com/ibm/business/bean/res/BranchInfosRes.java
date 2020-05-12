package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
* BFFDigital
* @author ShiYan May 28, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class BranchInfosRes extends BaseRemoteRes {

	@JsonAlias("branchInfo")
	private List<BranchInfoRes> branchInfos = new ArrayList<>();

	public List<BranchInfoRes> getBranchInfos() {
		return branchInfos;
	}

	public void setBranchInfos(List<BranchInfoRes> branchInfos) {
		this.branchInfos = branchInfos;
	}

	@Override
	public String toString() {
		return "BranchInfosRes [branchInfos=" + branchInfos + "]";
	}
}
