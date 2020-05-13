package com.ibm.business.user.bean.req;

import java.sql.Timestamp;

public class BuyerInfoRes {

	private String userName;

	private String password;

	private String email_id;

	private String contact_number;

	private Timestamp createDate;
	
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

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BuyerInfoRes [userName=" + userName + ", password=" + password + ", email_id=" + email_id + 
				", contact_number=" + contact_number + ", createDate=" + createDate + "]";
	}
}
