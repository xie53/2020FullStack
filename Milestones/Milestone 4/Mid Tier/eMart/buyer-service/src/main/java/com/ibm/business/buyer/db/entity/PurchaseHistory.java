package com.ibm.business.buyer.db.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The persistent class for the T_TRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="PurchaseHistory")
@NamedQuery(name="PurchaseHistory.findAll", query="SELECT a FROM PurchaseHistory a")
public class PurchaseHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="BUYER_ID")
	private long buyerId;

	@Column(name="SELLER_ID")
	private long sellerId;

	@Column(name="TRANSACTION_ID")
	private long transactionId;

	@Column(name="ITEM_ID")
	private long itemId;

	@Column(name="NUMBER_OF_ITEMS")
	private int numberOfItems;

	@Column(name="DATE_TIME")
	private Timestamp dateTime;

	@Column(name="REMARKS")
	private String remarks;

	public PurchaseHistory() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}