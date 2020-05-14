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
	private long subcategory_id;

	@Column(name="SUBCATEGORY_NAME")
	private String subcategory_name;

	@Column(name="CATEGORY_ID")
	private long category_id;

	@Column(name="BRIEF_DETAILS")
	private String brief_details;

	@Column(name="GSTIN")
	private String gstin;

	public SubCategory() {
	}

	public long getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getBrief_details() {
		return brief_details;
	}

	public void setBrief_details(String brief_details) {
		this.brief_details = brief_details;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

}