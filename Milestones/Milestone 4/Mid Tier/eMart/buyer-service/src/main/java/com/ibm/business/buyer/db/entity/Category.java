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
	private long categoryId;

	@Column(name="CATEGORY_NAME")
	private String categoryName;

	@Column(name="BRIEF_DETAILS")
	private String briefDetails;

	public Category() {
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBriefDetails() {
		return briefDetails;
	}

	public void setBriefDetails(String briefDetails) {
		this.briefDetails = briefDetails;
	}

}