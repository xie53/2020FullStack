package com.ibm.business.buyer.bean.req;

public class ItemsInfoRes {

	private String itemName;

	private String categoryId;

	private String subcategoryId;

	private double price;

	private String description;

	private int stockNumber;

	private int remainNumber;

	private String remarks;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	@Override
	public String toString() {
		return "ItemsInfoRes [itemName=" + itemName + ", categoryId=" + categoryId + ", subcategoryId=" + subcategoryId + 
				", price=" + price + ", description=" + description + ", stockNumber=" + stockNumber + ", remainNumber=" + 
				remainNumber + ", remarks=" + remarks + "]";
	}
}
