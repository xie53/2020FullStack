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
	private long buyer_id;

	@Column(name="SELLER_ID")
	private long seller_id;

	@Column(name="TRANSACTION_ID")
	private long transaction_id;

	@Column(name="ITEM_ID")
	private long item_id;

	@Column(name="NUMBER_OF_ITEMS")
	private int number_of_items;

	@Column(name="DATE_TIME")
	private Timestamp date_Time;

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

	public long getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}

	public long getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(long seller_id) {
		this.seller_id = seller_id;
	}

	public long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public int getNumber_of_items() {
		return number_of_items;
	}

	public void setNumber_of_items(int number_of_items) {
		this.number_of_items = number_of_items;
	}

	public Timestamp getDate_Time() {
		return date_Time;
	}

	public void setDate_Time(Timestamp date_Time) {
		this.date_Time = date_Time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}