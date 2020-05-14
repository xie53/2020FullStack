package com.ibm.business.buyer.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the T_CATEGORY database table.
 * 
 */
@Entity
@Table(name="T_CATEGORY")
@NamedQuery(name="Category.findAll", query="SELECT a FROM Category a")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private long category_id;

	@Column(name="CATEGORY_NAME")
	private String category_name;

	@Column(name="BRIEF_DETAILS")
	private String brief_details;

	public Category() {
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getBrief_details() {
		return brief_details;
	}

	public void setBrief_details(String brief_details) {
		this.brief_details = brief_details;
	}

}