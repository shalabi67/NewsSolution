package com.news.notification;

import com.news.models.News;
import com.news.models.User;
import com.news.notification.devices.DeviceType;

public class UserNewsNotification {
	private int userId;
	private DeviceType device;
	private String newsData;
	private int newsId;
	
	public UserNewsNotification() {
		
	}
	
	public UserNewsNotification(DeviceType device, User user, News news) {
		userId = user.getId();
		newsData = news.getNews();
		this.device = device;
		newsId = news.getId();
	}
	public UserNewsNotification( int userId, int newsId, String newsData) {
		this.userId = userId;
		newsData = newsData;
		this.device = DeviceType.Testing;
		this.newsId = newsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public DeviceType getDevice() {
		return device;
	}
	public void setDevice(DeviceType device) {
		this.device = device;
	}
	public String getNewsData() {
		return newsData;
	}
	public void setNewsData(String newsData) {
		this.newsData = newsData;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	

}
