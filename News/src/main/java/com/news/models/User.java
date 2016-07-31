package com.news.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int status;  //o not active 1 active 2 logged in
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="UserNews", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="newsId"))
	private Set<News> newsList = new HashSet<News>();
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="UserCategories", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="categoryId"))
	private Set<Category> categoryList = new HashSet<Category>();
	
	
	public User() {
		
	}
	
	public boolean isLoggedin() {
		return status == 2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<News> getNewsList() {
		return newsList;
	}

	public Set<Category> getCategoryList() {
		return categoryList;
	}
	public void setNewsList(Set<News> newsList) {
		this.newsList = newsList;
	}


}
