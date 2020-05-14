package com.ibm.business.buyer.db.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the T_ITEMS database table.
 * 
 */
@Entity
@Table(name="T_ITEMS")
@NamedQuery(name="Items.findAll", query="SELECT a FROM Items a")
public class Items implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="CATEGORY_ID")
	private long category_id;

	@Column(name="SUBCATEGORY_ID")
	private long subcategory_id;

	@Column(name="PRICE")
	private double price;

	@Column(name="ITEM_NAME")
	private String item_name;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="STOCK_NUMBER")
	private int stock_number;

	@Column(name="REMAIN_NUMBER")
	private int remain_number;

	@Column(name="REMARKS")
	private String remarks;

	public Items() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public long getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(long subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock_number() {
		return stock_number;
	}

	public void setStock_number(int stock_number) {
		this.stock_number = stock_number;
	}

	public int getRemain_number() {
		return remain_number;
	}

	public void setRemain_number(int remain_number) {
		this.remain_number = remain_number;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}