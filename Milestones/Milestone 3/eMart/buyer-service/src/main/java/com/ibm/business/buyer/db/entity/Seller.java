package com.ibm.business.buyer.db.entity;

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
	private String brief_company;

	@Column(name="POSTAL_ADDRESS")
	private String postal_address;

	@Column(name="WEBSITE")
	private String website;

	@Column(name="EMAILID")
	private String email_id;

	@Column(name="CONTACT_NUMBER")
	private String contact_number;

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

	public String getBrief_company() {
		return brief_company;
	}

	public void setBrief_company(String brief_company) {
		this.brief_company = brief_company;
	}

	public String getPostal_address() {
		return postal_address;
	}

	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

}