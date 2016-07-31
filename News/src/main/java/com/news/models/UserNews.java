package com.news.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class UserNews {
	@EmbeddedId
	private UserNewsId id;
	
	@NotNull
	private int status;

	public UserNews() {
		status = 1;
	}
	public UserNews(int userId, int newsId)	{
		this.id = new UserNewsId(userId, newsId);
		status = 1;
	}

	public UserNewsId getId() {
		return id;
	}
	public void setId(UserNewsId id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public boolean isCreated() {
		return status == 1;
	}
}
