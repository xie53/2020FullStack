package com.ibm.business.bean.res;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class OtpIssueRes extends InitRemoteRes{
	private String seqNo;

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		return "OtpIssueRes [seqNo=" + seqNo + "]";
	}
}
