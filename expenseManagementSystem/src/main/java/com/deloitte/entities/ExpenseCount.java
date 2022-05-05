package com.deloitte.entities;



public class ExpenseCount {

	private String expenseName;
	
	private Integer count;

	public ExpenseCount() {
		
	}
	
	public ExpenseCount(String expenseName, Integer count) {
		super();
		this.expenseName = expenseName;
		this.count = count;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
