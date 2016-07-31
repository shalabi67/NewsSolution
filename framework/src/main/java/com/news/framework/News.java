package com.news.framework;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class News {
	private String news;
	private String source;
	private NewsCategory category;
	
	public News() {
		
	}
	protected News(NewsCategory category, String news, String source) {
		this.category = category;
		this.news = news;
		this.source = source;
	}
	
	public static News create(NewsCategory category, String newsData, String source) {
		News news = new News(category, newsData, source);
		
		return news;
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
	public NewsCategory getCategory() {
		return category;
	}
	public void setCategory(NewsCategory category) {
		this.category = category;
	}
	
	
	@Override
    public String toString() {
		String newsString = String.format("News{news='%s', source='%s', category='%s'}", getNews(), getSource(), getCategory().getValue());
        return newsString;
    }

}
