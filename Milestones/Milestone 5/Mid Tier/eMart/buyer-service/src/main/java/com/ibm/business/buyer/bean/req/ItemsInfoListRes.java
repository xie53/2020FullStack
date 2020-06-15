package com.ibm.business.buyer.bean.req;

import java.util.ArrayList;
import java.util.List;

public class ItemsInfoListRes {
	private List<ItemsInfoRes> itemInformationList = new ArrayList<>();

	public List<ItemsInfoRes> getItemInformationList() {
		return itemInformationList;
	}

	public void setItemInformationList(List<ItemsInfoRes> itemInformationList) {
		this.itemInformationList = itemInformationList;
	}

	@Override
	public String toString() {
		return "ItemsInfoListRes [itemInformationList=" + itemInformationList + "]";
	}
}
