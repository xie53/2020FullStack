package com.ibm.business.buyer.bean.req;

import java.sql.Timestamp;

public class BuyerInfoRes {

	private String id;

	private String userName;

	private String password;

	private String emailId;

	private String contactNumber;

	private Timestamp createDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BuyerInfoRes [id=" + id + ", userName=" + userName + ", password=" + password + ", emailId=" + emailId + 
				", contactNumber=" + contactNumber + ", createDate=" + createDate + "]";
	}
}
