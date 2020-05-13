package com.ibm.business.user.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_BUYER database table.
 * 
 */
@Entity
@Table(name="T_BUYER")
@NamedQuery(name="Buyer.findAll", query="SELECT a FROM Buyer a")
public class Buyer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="USERNAME")
	private String userName;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="EMAILID")
	private String email_id;

	@Column(name="CONTACT_NUMBER")
	private String contact_number;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	public Buyer() {
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