package com.ibm.business.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_PBK_APPLICATION_CONFIGURATION database table.
 * 
 */
@Entity
@Table(name="T_PBK_APPLICATION_CONFIGURATION")
@NamedQuery(name="PbkApplicationConfiguration.findAll", query="SELECT p FROM PbkApplicationConfiguration p")
public class PbkApplicationConfiguration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="APP_SECRET")
	private String appSecret;

	@Column(name="APP_SECRET_STATUS")
	private String appSecretStatus;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Column(name="UPDATED_AT")
	private Timestamp updatedAt;

	public PbkApplicationConfiguration() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppSecretStatus() {
		return this.appSecretStatus;
	}

	public void setAppSecretStatus(String appSecretStatus) {
		this.appSecretStatus = appSecretStatus;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}