package com.deloitte.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Creating User table in the database with the following columns
@Entity
@Table(name = "USER_TB")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userId;
	@Column
	private String name;
	@Column(unique = true)
	private String userName;
	@Column
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Expense> eList;

	public User() {
		super();
	}

	public User(String name, String userName, String password, List<Expense> eList) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.eList = eList;
	}

	public User(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return userId;
	}

	public List<Expense> geteList() {
		return eList;
	}

	public void seteList(List<Expense> eList) {
		this.eList = eList;
	}

}
