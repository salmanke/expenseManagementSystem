package com.deloitte.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Creating Expense table in the database with the following columns
@Entity
@Table(name = "EXPENSE_TB")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int expenseId;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "expense_type")
	private String type;
	@Column(name = "expense_description")
	private String desc;
	@Column(name = "Amount")
	private Double amount;

	@ManyToOne
	private User user;

	public Expense() {
		super();
	}

	public Expense(LocalDate date, String type, String desc, Double amount, User user) {
		super();
		this.date = date;
		this.type = type;
		this.desc = desc;
		this.amount = amount;
		this.user = user;
	}

	public Expense(LocalDate date, String type, Double amount) {
		super();
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	public Expense(LocalDate date, String type, String desc, Double amount) {
		super();
		this.date = date;
		this.type = type;
		this.desc = desc;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getId() {
		return expenseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
