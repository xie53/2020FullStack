package com.ibm.business.user.bean.req;

import java.sql.Timestamp;

public class SellerInfoRes {

	private String id;

	private String userName;

	private String password;

	private String company;

	private String gstin;

	private String briefCompany;

	private String postalAddress;

	private String website;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getBriefCompany() {
		return briefCompany;
	}

	public void setBriefCompany(String briefCompany) {
		this.briefCompany = briefCompany;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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
		return "SellerInfoRes [id=" + id + ", userName=" + userName + ", password=" + password + 
				", company=" + company + ", gstin=" + gstin + ", briefCompany=" + briefCompany 
				+ ", postalAddress=" + postalAddress + ", website=" + website + ", emailId=" + emailId 
				+ ", contactNumber=" + contactNumber + ", createDate=" + createDate + "]";
	}
}
