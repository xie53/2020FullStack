package com.ibm.business.seller.db.entity;

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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name="CATEGORY_ID")
	private long categoryId;

	@Column(name="SUBCATEGORY_ID")
	private long subcategoryId;

	@Column(name="PRICE")
	private double price;

	@Column(name="ITEM_NAME")
	private String itemName;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="STOCK_NUMBER")
	private int stockNumber;

	@Column(name="REMAIN_NUMBER")
	private int remainNumber;

	@Column(name="REMARKS")
	private String remarks;

	public Items() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public int getRemainNumber() {
		return remainNumber;
	}

	public void setRemainNumber(int remainNumber) {
		this.remainNumber = remainNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}