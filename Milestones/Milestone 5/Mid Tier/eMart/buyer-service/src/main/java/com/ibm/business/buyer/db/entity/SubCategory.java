package com.ibm.business.buyer.db.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the T_SUBCATEGORY database table.
 * 
 */
@Entity
@Table(name="T_SUBCATEGORY")
@NamedQuery(name="SubCategory.findAll", query="SELECT a FROM SubCategory a")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SUBCATEGORY_ID")
	private long subcategoryId;

	@Column(name="SUBCATEGORY_NAME")
	private String subcategoryName;

	@Column(name="CATEGORY_ID")
	private long categoryId;

	@Column(name="BRIEF_DETAILS")
	private String briefDetails;

	@Column(name="GSTIN")
	private String gstin;

	public SubCategory() {
	}

	public long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getBriefDetails() {
		return briefDetails;
	}

	public void setBriefDetails(String briefDetails) {
		this.briefDetails = briefDetails;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

}