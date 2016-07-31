package com.news.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String news;
	
	@NotNull
	private String source;
	
	@NotNull
	private int category;
	
	@NotNull
	private Date creationDate;
	
	
	
	public News() {
		
	}
	public static News create(com.news.framework.News news) {
		News entity = new News();
		entity.news = news.getNews();
		entity.source = news.getSource();
		entity.category = news.getCategory().getValue();
		entity.creationDate = new Date();
		
		return entity;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	@Override
    public String toString() {
		String newsString = String.format("Quote{news='%s', source='%s'}", getNews(), getSource() );
        return newsString;
    }

}
