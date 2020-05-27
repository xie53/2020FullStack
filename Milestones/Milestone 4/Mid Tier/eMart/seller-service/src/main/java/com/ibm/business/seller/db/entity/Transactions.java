package com.ibm.business.seller.db.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The persistent class for the T_TRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="T_TRANSACTIONS")
@NamedQuery(name="Transactions.findAll", query="SELECT a FROM Transactions a")
public class Transactions implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="BUYER_ID")
	private long buyerId;

	@Column(name="SELLER_ID")
	private long sellerId;

	@Column(name="TRANSACTION_TYPE")
	private String transactionsType;

	@Column(name="DATE_TIME")
	private Timestamp dateTime;

	@Column(name="REMARKS")
	private String remarks;

	public Transactions() {
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

	public String getTransactionsType() {
		return transactionsType;
	}

	public void setTransactionsType(String transactionsType) {
		this.transactionsType = transactionsType;
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