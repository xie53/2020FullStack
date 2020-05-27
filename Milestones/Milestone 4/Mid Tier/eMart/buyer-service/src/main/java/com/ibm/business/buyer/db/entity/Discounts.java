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
	private String discountCode;

	@Column(name="PERCENTAGE")
	private double percentage;

	@Column(name="START_DATE")
	private Timestamp startDate;

	@Column(name="END_DATE")
	private Timestamp endDate;

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

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}