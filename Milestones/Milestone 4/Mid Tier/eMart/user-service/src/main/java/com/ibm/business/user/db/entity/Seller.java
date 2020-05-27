package com.ibm.business.user.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the T_SELLER database table.
 * 
 */
@Entity
@Table(name="T_SELLER")
@NamedQuery(name="Seller.findAll", query="SELECT a FROM Seller a")
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="USERNAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="COMPANY")
	private String company;

	@Column(name="GSTIN")
	private String gstin;

	@Column(name="BRIEF_COMPANY")
	private String briefCompany;

	@Column(name="POSTAL_ADDRESS")
	private String postalAddress;

	@Column(name="WEBSITE")
	private String website;

	@Column(name="EMAILID")
	private String emailId;

	@Column(name="CONTACT_NUMBER")
	private String contactNumber;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	public Seller() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}