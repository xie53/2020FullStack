package com.ibm.business.bean.res;

import java.util.ArrayList;
import java.util.List;

/**
* BFFDigital
* @author xieys May 28, 2020
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class AddressChangeListRes extends InitRemoteRes{
	private String hitCount;
	private List<AddressChangeInfoRes> addressInformationList = new ArrayList<>();

	public String getHitCount() {
		return hitCount;
	}

	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}

	public List<AddressChangeInfoRes> getAddressInformationList() {
		return addressInformationList;
	}

	public void setAddressInformationList(List<AddressChangeInfoRes> addressInformationList) {
		this.addressInformationList = addressInformationList;
	}

	@Override
	public String toString() {
		return "AddressChangeListRes [hitCount=" + hitCount + ", addressInformationList=" + addressInformationList + "]";
	}
}
