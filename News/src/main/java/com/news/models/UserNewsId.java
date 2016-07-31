package com.news.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserNewsId implements Serializable {
	private static final long serialVersionUID = -4523632527338323837L;
	
	@Column(name="userId")
    private int userId;
	@Column(name="newsId")
    private int newsId;
	
	public UserNewsId() {
		
	}

	public UserNewsId(int userId, int newsId) {
		this.userId = userId;
		this.newsId = newsId;
	}
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public boolean equals(Object o) {
		if(!(o instanceof UserNewsId))
			return false;
		UserNewsId userNewsId = (UserNewsId)o;
		return ((userId==userNewsId.getUserId()) && (newsId ==userNewsId.getNewsId()));
    }
 
    public int hashCode() {
        return userId*31 + newsId;
    }
}
