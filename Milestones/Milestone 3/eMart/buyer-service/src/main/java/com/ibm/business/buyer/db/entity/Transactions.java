package com.ibm.business.buyer.db.entity;

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
	private long buyer_id;

	@Column(name="SELLER_ID")
	private long seller_id;

	@Column(name="TRANSACTION_TYPE")
	private String transactions_type;

	@Column(name="DATE_TIME")
	private Timestamp date_Time;

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

	public String getTransactions_type() {
		return transactions_type;
	}

	public void setTransactions_type(String transactions_type) {
		this.transactions_type = transactions_type;
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