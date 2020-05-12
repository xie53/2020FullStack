package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoListRes {
//public class UserInfoListRes extends BaseRemoteRes{

	private List<UserInfoTelPhoneRes> telPhoneRes = new ArrayList<>();
	private List<UserInfoAddrRes> addr = new ArrayList<>();
	private List<UserInfoArticlesRes> articles = new ArrayList<>();

	public List<UserInfoTelPhoneRes> getTelPhoneRes() {
		return telPhoneRes;
	}

	public void setTelPhoneRes(List<UserInfoTelPhoneRes> telPhoneRes) {
		this.telPhoneRes = telPhoneRes;
	}

	public List<UserInfoAddrRes> getAddr() {
		return addr;
	}

	public void setAddr(List<UserInfoAddrRes> addr) {
		this.addr = addr;
	}

	public List<UserInfoArticlesRes> getArticles() {
		return articles;
	}

	public void setArticles(List<UserInfoArticlesRes> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "UserInfoListRes [telPhone=" + telPhoneRes + ", addr=" + addr + ", articles=" + articles + "]";
	}
}
