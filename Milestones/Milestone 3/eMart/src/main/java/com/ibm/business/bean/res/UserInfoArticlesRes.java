package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class UserInfoArticlesRes {
	private String type;
	private String supplementary;
	private String passbookType;
	private String status;
	private Boolean selected;
	private List<UserInfoArticleInfoRes> articleInfo = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSupplementary() {
		return supplementary;
	}

	public void setSupplementary(String supplementary) {
		this.supplementary = supplementary;
	}

	public String getPassbookType() {
		return passbookType;
	}

	public void setPassbookType(String passbookType) {
		this.passbookType = passbookType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<UserInfoArticleInfoRes> getArticleInfo() {
		return articleInfo;
	}

	public void setArticleInfo(List<UserInfoArticleInfoRes> articleInfo) {
		this.articleInfo = articleInfo;
	}

	@Override
	public String toString() {
		return "UserInfoArticlesRes [type=" + type + ", supplementary=" + supplementary + ", passbookType=" + passbookType + 
				", status=" + status + ", selected=" + selected + ", articleInfo=" + articleInfo + "]";
	}
}
