package com.ibm.business.user.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_ACCESS_TOKEN database table.
 * 
 */
@Entity
@Table(name="T_ACCESS_TOKEN")
@NamedQuery(name="AccessToken.findAll", query="SELECT a FROM AccessToken a")
public class AccessToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="ACCESS_TOKEN")
	private String accessToken;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	public AccessToken() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}