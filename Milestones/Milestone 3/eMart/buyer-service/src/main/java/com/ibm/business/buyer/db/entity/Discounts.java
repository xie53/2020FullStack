package com.ibm.business.buyer.db.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The persistent class for the T_DISCOUNTS database table.
 * 
 */
@Entity
@Table(name="T_DISCOUNTS")
@NamedQuery(name="Discounts.findAll", query="SELECT a FROM Discounts a")
public class Discounts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="DISCOUNT_CODE")
	private String discount_code;

	@Column(name="PERCENTAGE")
	private double percentage;

	@Column(name="START_DATE")
	private Timestamp start_date;

	@Column(name="END_DATE")
	private Timestamp end_date;

	@Column(name="DESCRIPTION")
	private String description;

	public Discounts() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiscount_code() {
		return discount_code;
	}

	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}