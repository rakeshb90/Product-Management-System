package com.example.rest1.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String name;
	private String mobile;
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Product.class,cascade=CascadeType.ALL)
	private List<Product> products;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String name, String mobile, List<Product> products) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.mobile = mobile;
		this.products = products;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", mobile=" + mobile + ", products=" + products + "]";
	}
	
	

}
